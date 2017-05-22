package base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	// Testing
	private static PersonDomainModel pdm1;
	private static PersonDomainModel pdm2;
	
	private static UUID randID1 = UUID.randomUUID();
	private static UUID randID2 = UUID.randomUUID();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pdm1 = new PersonDomainModel();
		pdm2 = new PersonDomainModel();
		
		pdm1.setPersonID(randID1);
		pdm1.setFirstName("Gabriel");
		pdm1.setLastName("Corella");
		pdm1.setPostalCode(11934);
		pdm1.setCity("Center Moriches");
		
		PersonDAL.addPerson(pdm1);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(randID1);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AddPerson() {
		PersonDomainModel per1 = new PersonDomainModel();
		per1.setBirthday(new Date(0));
		per1.setCity("Townsend");
		per1.setFirstName("Bert");
		per1.setLastName("Gibbons");
		per1.setPostalCode(19734);
		per1.setStreet("214 Labrador Lane");
		
		PersonDAL.addPerson(per1);
	}
	
	@Test
	public void TestGetPersons(){
		ArrayList<PersonDomainModel> list = PersonDAL.getPersons();
		assertTrue(PersonDAL.getPersons().contains(list));
	}
	@Test
	public void TestDeletePerson(){
		PersonDAL.deletePerson(randID1);
	}
	@Test 
	public void TestAddPerson(){
		PersonDAL.addPerson(pdm1);
		assertTrue(PersonDAL.getPersons().contains(pdm1));
	}
	@Test 
	public void TestGetPerson(){
		assertTrue(pdm1.equals(PersonDAL.getPerson(randID1)));
	}
	@Test 
	public void TestUpdatePerson(){
		pdm1.setFirstName("Lauren");
		PersonDAL.updatePerson(pdm1);
		assertTrue(PersonDAL.getPerson(randID1).getFirstName().equals("Lauren"));
	}
}
