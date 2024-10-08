package Student;

import Cource.Course;

import java.util.ArrayList;

public class Student {


    private String studentId;
    private String name;
    private String email;
    private String phoneNumber;
    protected ArrayList<Course> enrolledCourses;

    public Student(String studentId, String name, String email, String phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void removeCourse(Course course) {
        enrolledCourses.remove(course);
    }

    // Calculate GPA based on courses and their grades
    public double calculateGPA() {
        double totalPoints = 0;
        int totalCredits = 0;
        for (Course course : enrolledCourses) {
            totalPoints += course.getGrade() * course.getCredits();
            totalCredits += course.getCredits();
        }
        return totalCredits > 0 ? totalPoints / totalCredits : 0;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("GPA: " + calculateGPA());
    }

    public void displayEnrolledCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println(name + " is not enrolled in any courses.");
        } else {
            System.out.println(name + " is enrolled in the following courses:");
            for (Course course : enrolledCourses) {
                System.out.println(course); // Using the Course class's toString method
            }
        }
    }


}
