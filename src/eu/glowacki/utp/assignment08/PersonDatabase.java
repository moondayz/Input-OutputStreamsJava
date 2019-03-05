package eu.glowacki.utp.assignment08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import comparators.BirthdateComparator;
import comparators.FirstNameComparator;



public final class PersonDatabase {
	private static List<Person> plist;
	
	public PersonDatabase(List<Person> persons) {
		plist = persons;	}




	// assignment 8 - factory method based on deserialization
	public static PersonDatabase deserialize(DataInputStream input) throws Assignment08Exception {
		
		List<Person> perList = new ArrayList<Person>();
		try {
			int i = input.readInt(), b = 0;
			while (b++ < i)
				perList.add(Person.deserialize(input));
		} catch (IOException e) {
		}
		return new PersonDatabase(perList);

	}

	// assignment 8
	public void serialize(DataOutputStream output) throws Assignment08Exception {

		try {
			output.writeInt(plist.size());
			for (Person p : plist) {
				p.serialize(output);
			}
		} catch (IOException e) {
		}

	}

	// assignment 4
	public List<Person> sortedByFirstName() {
		return plist.stream().sorted(new FirstNameComparator()).collect(Collectors.toList());
	}


	// assignment 4
	public List<Person> sortedBySurnameFirstNameAndBirthdate() {
	return plist.stream().sorted().collect(Collectors.toList());
	
	}

	// assignment 4
	public List<Person> sortedByBirthdate() {
		return plist.stream().sorted(new BirthdateComparator()).collect(Collectors.toList());

		
	}

	// assignment 4
	public List<Person> bornOnDay(Date date) {
		Map<Person, Date> m = new HashMap<Person, Date>();
		for (Person p : plist)
			m.put(p, p.getBirthDate());
		return m.entrySet().stream().filter(e -> e.getValue().equals(date)).map(e -> e.getKey())
				.collect(Collectors.toList());
	}

}