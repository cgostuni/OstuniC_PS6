package base;

import static org.junit.Assert.*;
import domain.PersonDomainModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Person_Test {

	@BeforeClass
	public static void setUpBeforeClass(LocalDate birthday) throws Exception {
		Date dDate = null;
		try {
			dDate = new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-16");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		PersonDomainModel per1 = new PersonDomainModel();
		per1.setFirstName("Caroline");
		per1.setLastName("Ostuni");
		per1.setBirthday(dDate);
		per1.setCity("Melville");
		per1.setPostalCode(11747);
		per1.setStreet("35 Wintergreen Drive");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel per1 = new PersonDomainModel();
		PersonDomainModel per;	
		PersonDAL.deletePerson(per1.getPersonID());
		per = PersonDAL.getPerson(per1.getPersonID());
		assertNull("The person does not belong in database",per);		
	}

	@Test
	public void AddPersonTest()
	{		
		PersonDomainModel per1 = new PersonDomainModel();
		PersonDomainModel per;		
		per = PersonDAL.getPerson(per1.getPersonID());		
		assertNull("The person does not belong in database",per);		
		PersonDAL.addPerson(per1);	
		
		per = PersonDAL.getPerson(per1.getPersonID());
		System.out.println(per1.getPersonID() + " found");
		assertNotNull("The person should be added to database",per);
	}
	
	@Test
	public void UpdatePersonTest()
	{		
		PersonDomainModel per1 = new PersonDomainModel();
		PersonDomainModel per;
		final String C_LASTNAME = "Smith";
		
		per = PersonDAL.getPerson(per1.getPersonID());		
		assertNull("The person does not belong in database",per);		
		PersonDAL.addPerson(per1);	
		
		per1.setLastName(C_LASTNAME);
		PersonDAL.updatePerson(per1);
		
		per = PersonDAL.getPerson(per1.getPersonID());

		assertTrue("Name Didn't Change",per1.getLastName() == C_LASTNAME);
	}

	@Test
	public void DeletePersonTest()
	{		
		
		PersonDomainModel per1 = new PersonDomainModel();
		PersonDomainModel per;		
		per = PersonDAL.getPerson(per1.getPersonID());		
		assertNull("The person does not belong in database",per);	
		
		PersonDAL.addPerson(per1);			
		per = PersonDAL.getPerson(per1.getPersonID());
		System.out.println(per1.getPersonID() + " found");
		assertNotNull("The person should be in database",per);
		
		PersonDAL.deletePerson(per1.getPersonID());
		per = PersonDAL.getPerson(per1.getPersonID());		
		assertNull("The person does not belong in database",per);	
		
	}
	

}
