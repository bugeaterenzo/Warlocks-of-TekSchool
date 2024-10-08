package CourseEnrollment;

import Cource.Course;

import Student.Student;

import java.util.ArrayList;

public class CourseEnrollment {

    private Course course;
    private ArrayList<Student> enrolledStudents;

    public CourseEnrollment(Course course) {
        this.course = course;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.addCourse(course);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
        student.removeCourse(course);
    }

    public void displayEnrolledStudents() {
        System.out.println("Students enrolled in " + course.getCourseName() + ":");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }
}
