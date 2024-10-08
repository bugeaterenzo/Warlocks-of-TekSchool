package DataManager;

import Cource.Course;
import Student.Student;
import java.util.ArrayList;
import java.util.HashMap;

public class DataManager {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private HashMap<String, Student> studentMap;
    private HashMap<String, Course> courseMap;

    public DataManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        studentMap = new HashMap<>();
        courseMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        studentMap.put(student.getStudentId(), student);
    }

    public void addCourse(Course course) {
        courses.add(course);
        courseMap.put(course.getCourseId(), course);
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
}
