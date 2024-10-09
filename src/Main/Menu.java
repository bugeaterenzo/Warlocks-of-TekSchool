package Main;

import DataManager.DataManager;
import CourseEnrollment.CourseEnrollment;
import Cource.Course;
import Cource.ElectiveCourse;
import Cource.MandatoryCourse;
import Student.Student;
import Student.GraduateStudent;
import Student.UndergraduateStudent;

import java.util.Scanner;

public class Menu {

    private DataManager dataManager;
    private Scanner scanner;

    public Menu() {
        dataManager = new DataManager();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in a Course");
            System.out.println("4. Remove Student from a Course");
            System.out.println("5. Display All Students");
            System.out.println("6. Display All Courses");
            System.out.println("7. Search Student by ID");
            System.out.println("8. Search Course by ID");
            System.out.println("9. Display Enrolled Courses for a Student");
            System.out.println("10. Display Students Enrolled in a Course");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    enrollStudent();
                    break;
                case 4:
                    removeStudentFromCourse();
                    break;
                case 5:
                    dataManager.displayAllStudents();
                    break;
                case 6:
                    dataManager.displayAllCourses();
                    break;
                case 7:
                    searchStudentById();
                    break;
                case 8:
                    searchCourseById();
                    break;
                case 9:
                    displayEnrolledCoursesForStudent();
                    break;
                case 10:
                    displayStudentsInCourse();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.println("\n--- Add Student ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Student Type (Graduate/Undergraduate): ");
        String studentType = scanner.nextLine();

        Student student;
        if (studentType.equalsIgnoreCase("Graduate")) {
            student = new GraduateStudent(studentId, name, email, phoneNumber);
        } else {
            student = new UndergraduateStudent(studentId, name, email, phoneNumber);
        }

        dataManager.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private void addCourse() {
        System.out.println("\n--- Add Course ---");
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Course Type (Mandatory/Elective): ");
        String courseType = scanner.nextLine();

        Course course;
        if (courseType.equalsIgnoreCase("Mandatory")) {
            course = new MandatoryCourse(courseId, courseName, credits);
        } else {
            course = new ElectiveCourse(courseId, courseName, credits);
        }

        dataManager.addCourse(course);
        System.out.println("Course added successfully.");
    }

    private void enrollStudent() {
        System.out.println("\n--- Enroll Student in a Course ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = dataManager.getStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        Course course = dataManager.getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        CourseEnrollment enrollment = new CourseEnrollment();
        enrollment.enrollStudent(course, student);
        System.out.println("Student enrolled in course successfully.");
    }

    private void removeStudentFromCourse() {
        System.out.println("\n--- Remove Student from a Course ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = dataManager.getStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        Course course = dataManager.getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        CourseEnrollment enrollment = new CourseEnrollment();
        enrollment.removeStudent(course, student);
        System.out.println("Student removed from course successfully.");
    }

    private void searchStudentById() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = dataManager.getStudentById(studentId);

        if (student != null) {
            student.displayInfo();
        } else {
            System.out.println("Student not found.");
        }
    }

    private void searchCourseById() {
        System.out.print("\nEnter Course ID: ");
        String courseId = scanner.nextLine();
        Course course = dataManager.getCourseById(courseId);

        if (course != null) {
            course.displayInfo();
        } else {
            System.out.println("Course not found.");
        }
    }

    private void displayEnrolledCoursesForStudent() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = dataManager.getStudentById(studentId);

        if (student != null) {
            student.displayEnrolledCourses();
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displayStudentsInCourse() {
        System.out.print("\nEnter Course ID: ");
        String courseId = scanner.nextLine();
        Course course = dataManager.getCourseById(courseId);

        if (course != null) {
            CourseEnrollment enrollment = new CourseEnrollment();
            enrollment.displayEnrolledStudents(course);
        } else {
            System.out.println("Course not found.");
        }
    }
}
