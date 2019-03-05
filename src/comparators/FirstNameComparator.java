package comparators;

import java.util.Comparator;

import eu.glowacki.utp.assignment08.Person;


public class FirstNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
	}

}
