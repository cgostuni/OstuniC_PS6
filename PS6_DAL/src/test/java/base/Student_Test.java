package base;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.StudentDomainModel;

public class Student_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StudentDomainModel student = new StudentDomainModel("first","middle","last",new Date());
		StudentDAL.addStudent(student);
		assertEquals(student, StudentDAL.getStudent(student.getStudentID()));
	
		assertEquals(1, StudentDAL.getStudents().size());
	}
	
	
	

}
