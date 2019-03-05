package eu.glowacki.utp.assignment08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Date;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Person implements Comparable<Person> {

	private final String _firstName;
	private final String _surname;
	private final Date _birthdate;
	private SimpleDateFormat format;

	public Person(String firstName, String surname, Date birthdate) {
		_firstName = firstName;
		_surname = surname;
		_birthdate = birthdate;
	}

	// assignment 8
	public void serialize(DataOutputStream op) throws Assignment08Exception {
		// serialize birth date with getTime() method
		// encapsulate IOException in Assignment08Exception
		
		try {
			
			op.writeUTF(_firstName);
			op.writeUTF(_surname);
			op.writeLong(_birthdate.getTime());
		} catch (Throwable e) {
			throw new Assignment08Exception(e);
		}

		
	}
	
	public static Person deserialize(DataInputStream ip) throws Assignment08Exception {
		
		try {
			String _firstname = ip.readUTF();
			String _surname = ip.readUTF();
			Date _birthdate = new Date(ip.readLong());
			return new Person(_firstname, _surname, _birthdate);
		} catch (Throwable e) {
			throw new Assignment08Exception(e);
		}
		// return null;
	}

	@Override
	public int compareTo(Person comp) {
		
		int compValue = _surname.compareToIgnoreCase(comp._surname);
		if (compValue == 0)
			compValue = _firstName.compareToIgnoreCase(comp._firstName);
		if (compValue == 0)
			return _birthdate.compareTo(comp._birthdate);
		return compValue;

	}

	public String getFirstName() {
		return _firstName;
	}

	public String getSurname() {
		return _surname;
	}

	public Date getBirthDate() {
		return _birthdate;
	}
	
	public String toString() {
		
		 format = null;
		return _firstName + " " + _surname + " " + format.format(_birthdate);
	}

}