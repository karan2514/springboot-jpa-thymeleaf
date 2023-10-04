package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {

			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
	 //delete the student
		int studentId = 2;

		System.out.println("Deleting Student id: " +studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
	// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting Student with Id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);
		// change first name to scooby
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		//display updated student
		System.out.println("Updated Student: " +myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("hart");
		// display list of students
		for (Student tempStudent:theStudents
			 ) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent: theStudents
			 ) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("creating new student object ... ");
		Student student = new Student("rob", "patric", "patricrob@gmail.com");

		// save the student object
		System.out.println("saving the student object ... ");
		studentDAO.save(student);
		//display the id of the saved student

		System.out.println("saved student. Generated Id: " + student.getId());

		//retrieve student based on id : primary key

		System.out.println("saved student. Generated Id: " + student.getId());

		Student student1 = studentDAO.findById(student.getId());

		System.out.println("found the student: " + student1);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("creating new student object ... ");
		Student student = new Student("rob", "patric", "patricrob@gmail.com");

		// save the student object
		System.out.println("saving the student object ... ");
		studentDAO.save(student);
		//display the id of the saved student

		System.out.println("saved student. Generated Id: " + student.getId());

		//retrieve student based on id : primary key

		System.out.println("saved student. Generated Id: " + student.getId());

		Student student1 = studentDAO.findById(student.getId());

		System.out.println("found the student: " + student1);


	}


}
