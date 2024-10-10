package DataManager;

import Cource.Course;
import Student.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<String, Student> studentMap = new HashMap<>();
    private static HashMap<String, Course> courseMap = new HashMap<>();

    public DataManager() {
    }


    public void addStudent(Student student) {
        if (students.contains(student)) {
            System.out.printf(" %s is already enrolled in the course." , student.getName());
            System.out.println("\n");
        } else {
            students.add(student);
            studentMap.put(student.getStudentId(), student);
            System.out.printf(" %s is added to the course." , student.getName());
            System.out.println("\n");
        }
    }


    public void removeStudent(Student student) {
        if (students.remove(student)) {
            studentMap.remove(student.getStudentId());
            System.out.println(" Successfully removed " + student.getName() + " from the course.\n");
        } else {
            System.out.printf(" %s is not found in this course." , student.getName() );
            System.out.println("\n");
        }
    }



    public void addCourse(Course course) {
        if (courses.contains(course)) {
            System.out.printf(" %s is already added." , course.getCourseName());
            System.out.println("\n");
        } else {
            courses.add(course);
            courseMap.put(course.getCourseId(), course);
            System.out.printf(" %s is added successfully." , course.getCourseName());
            System.out.println("\n");
        }
    }



    public void removeCourse(Course course) {
        // Check if the course exists in the list of courses
        if (courses.contains(course)) {
            courses.remove(course); // Remove the course from the list
            courseMap.remove(course.getCourseId()); // Remove the course from the courseMap
            System.out.printf(" %s is removed successfully.%n", course.getCourseName());
        } else {
            System.out.printf(" %s is not found, cannot remove.%n", course.getCourseName());
        }
        System.out.println();
    }



    public Student getStudentById(String studentId) {
        return studentMap.get(studentId);
    }

    public Course getCourseById(String courseId) {
        return courseMap.get(courseId);
    }

    public void displayAllStudents() {
        System.out.println("All Students:");
        for (Student student : students) {
            student.displayInfo();
            System.out.println();
        }
    }

    public void displayAllCourses() {
        System.out.println("All Courses:");
        for (Course course : courses) {
            course.displayInfo();
            System.out.println();
        }
    }


    // New method to display the studentMap
    public void displayStudentMap() {
        System.out.println("Student Map (ID -> Student Info):\n" );
        //System.out.println();
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            // System.out.println("Student ID: " + entry.getKey());
            entry.getValue().displayInfo();
            System.out.println();
        }
    }

    // New method to display the courseMap
    public void displayCourseMap() {
        System.out.println("Course Map (ID -> Course Info):\n");

        for (Map.Entry<String, Course> entry : courseMap.entrySet()) {
            // System.out.println("Course ID: " + entry.getKey());
            entry.getValue().displayInfo();
            System.out.println();
        }
    }

}
