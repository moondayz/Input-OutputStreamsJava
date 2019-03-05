package eu.glowacki.utp.assignment08.test;
import org.junit.Test;
import org.junit.BeforeClass;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import eu.glowacki.utp.assignment08.Assignment08Exception;
import eu.glowacki.utp.assignment08.InputParser;
import eu.glowacki.utp.assignment08.Person;
import eu.glowacki.utp.assignment08.PersonDatabase;


public class PersonDatabaseTest {
	
	
    @Test
	public void serializeAndDeserialize() throws
	FileNotFoundException, ParseException, Assignment08Exception  {	
		
		List<Person> persons = InputParser.parse(new File("file.txt"));
		PersonDatabase persondb = new PersonDatabase(persons);
		persondb.serialize(new DataOutputStream(new FileOutputStream(new File("files.dat"))));
		// persondb.deserialize(new DataInputStream(new FileInputStream(new File("files.dat"))));
		PersonDatabase.deserialize(new DataInputStream(new FileInputStream(new File("files.dat"))));
	} 
}