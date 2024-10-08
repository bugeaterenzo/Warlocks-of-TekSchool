package Main;

import DataManager.DataManager;
import CourseEnrollment.CourseEnrollment;
import Cource.Course;
import Cource.ElectiveCourse;
import Cource.MandatoryCourse;
import Student.Student;
import Student.GraduateStudent;
import Student.UndergraduateStudent;


public class Main {


    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        // Create students
        Student Alice = new GraduateStudent("G001", "Alice", "alice@example.com", "1234567890");
        Student Bob = new UndergraduateStudent("U001", "Bob", "bob@example.com", "0987654321");

        dataManager.addStudent(Alice);
        dataManager.addStudent(Bob);

        // Create courses
        Course mandatoryCourse = new MandatoryCourse("C001", "Data Structures", 4);
        Course electiveCourse = new ElectiveCourse("C002", "Art History", 3);

        dataManager.addCourse(mandatoryCourse);
        dataManager.addCourse(electiveCourse);

        // Enroll students
        CourseEnrollment enrollment1 = new CourseEnrollment(mandatoryCourse);
        enrollment1.enrollStudent(Alice);

        CourseEnrollment enrollment2 = new CourseEnrollment(electiveCourse);
        enrollment2.enrollStudent(Bob);



        // Set grades
        mandatoryCourse.setGrade(3.5);
        electiveCourse.setGrade(4.0);


        // Display Enrolled Courses
        Alice.displayEnrolledCourses();
        System.out.println("\n");

        // Display Enrolled Courses
        Bob.displayEnrolledCourses();
        System.out.println("\n");


        // Get Student Info
        Alice.displayInfo();
        System.out.println("\n");

        // Get Student Info
        Bob.displayInfo();
        System.out.println("\n");

        // Display Enrolled Students
        enrollment1.displayEnrolledStudents();
        System.out.println("\n");

        // Display Enrolled Students
        enrollment2.displayEnrolledStudents();
        System.out.println("\n");


        // Display all students and their GPA
        dataManager.displayAllStudents();

        // Display all courses
        dataManager.displayAllCourses();


        // Search Student by id
        System.out.println(dataManager.getStudentById("G001"));
        // Search Student by id
        System.out.println(dataManager.getStudentById("U001"));


    }

}
