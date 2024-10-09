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
        Course Data_Structures  = new MandatoryCourse("C001", "Data Structures", 4);
        Course Art_History  = new ElectiveCourse("C002", "Art History", 3);

        dataManager.addCourse(Data_Structures);
        dataManager.addCourse(Art_History);

        // Enroll students
        CourseEnrollment enrollment1 = new CourseEnrollment();
        enrollment1.enrollStudent(Data_Structures, Alice );
        enrollment1.enrollStudent(Data_Structures, Alice );
        enrollment1.removeStudent(Art_History, Alice );

        CourseEnrollment enrollment2 = new CourseEnrollment();
        enrollment2.enrollStudent(Data_Structures, Bob );



        // Set grades
        Data_Structures.setGrade(3.5);
        Art_History.setGrade(4.0);


        System.out.println();


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
        enrollment1.displayEnrolledStudents(Data_Structures);
        System.out.println("\n");

        // Display Enrolled Students
        enrollment2.displayEnrolledStudents(Art_History);
        System.out.println("\n");


        // Display all students and their GPA
        dataManager.displayAllStudents();

        // Display all courses
        dataManager.displayAllCourses();


        // Search Student by id
        System.out.println(dataManager.getStudentById("G001"));
        // Search Student by id
        System.out.println(dataManager.getStudentById("U001"));

        System.out.println();

        // Search Course by id
        System.out.println(dataManager.getCourseById("C001"));
        // Search Course by id
        System.out.println(dataManager.getCourseById("C002"));

        System.out.println();

        // Get Student Map
        dataManager.displayStudentMap();
        // Get Course Map
        dataManager.displayCourseMap();


    }

}
