package Cource;

public class Course {
    private String courseId;
    private String courseName;
    private int credits;
    private double grade;

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.grade = 0.0; // default grade
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credits: " + credits);
        System.out.println("Grade: " + grade);
    }

    @Override
    public String toString() {
        return "Course{id='" + courseId + "', name='" + courseName + "', grade=" + grade + ", credits=" + credits + "}";
    }


}

