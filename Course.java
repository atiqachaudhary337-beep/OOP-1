package universitymanagment.com.universitymanagementsystem;

public class Course {

    private String courseName;
    private String courseCode;
    private int creditHours;

    public Course(String courseName, String courseCode, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    @Override
    public String toString() {
        return courseName + " (" + courseCode + ")";
    }

}