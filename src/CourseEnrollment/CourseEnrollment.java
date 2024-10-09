package CourseEnrollment;

import Cource.Course;

import Student.Student;

import java.util.HashMap;

public class CourseEnrollment {

    private Course course;
    private HashMap<String, Student> enrolledStudents; // Map to hold courseId (String) and Student

    public CourseEnrollment(Course course) {
        this.course = course;
        this.enrolledStudents = new HashMap<>();
    }

    public void enrollStudent(Course course, Student student) {
        // Get the course ID from the provided Course object
        String courseId = course.getCourseId();

        // Check if the student is already enrolled in the course by comparing course IDs
        if (enrolledStudents.containsKey(courseId)) {
            System.out.printf(" %s is already enrolled in the %s course. ", student.getName(), course.getCourseName());
            System.out.println("\n");
        } else {
            enrolledStudents.put(courseId, student); // Enroll the student in the course
            student.addCourse(course); // Add the course to the student's list of courses
            System.out.printf(" %s is successfully enrolled in the %s course. ", student.getName(), course.getCourseName());
            System.out.println("\n");
        }
    }


    public void removeStudent(Course course, Student student) {
        // Get the course ID from the provided Course object
        String courseId = course.getCourseId();

        // Check if the student is enrolled in the course by comparing course IDs
        if (enrolledStudents.containsKey(courseId) && enrolledStudents.get(courseId).equals(student)) {
            enrolledStudents.remove(courseId); // Remove the student from the course
            student.removeCourse(course); // Remove the course from the student's list of courses
            System.out.printf(" %s is successfully removed from the %s course. ", student.getName(), course.getCourseName());
            System.out.println("\n");
        } else {
            System.out.printf(" %s is not found in the %s course. ", student.getName(), course.getCourseName());
            System.out.println("\n");
        }
    }


    public void displayEnrolledStudents() {
        System.out.println("Students enrolled in " + course.getCourseName() + ":");
        for (Student student : enrolledStudents.values()) {
            System.out.println("- " + student.getName());
        }
    }
}
