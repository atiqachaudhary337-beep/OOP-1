package universitymanagment.com.universitymanagementsystem;

import java.util.ArrayList;

public class Student extends User {

    private ArrayList<Course> courses;
    private ArrayList<Marks> marks;

    public Student(String u, String p) {
        super(u, p);
        courses = new ArrayList<>();
        marks = new ArrayList<>();
    }


    public String viewMarks() {
        if (marks.isEmpty()) {
            return "No courses registered!";
        }

        StringBuilder s = new StringBuilder();
        for (Marks m : marks) {
            s.append(m.getCourse().getCourseName())
                    .append(": ")
                    .append(m.getScore())
                    .append("\n");
        }
        return s.toString();
    }

    public ArrayList<Marks> getMarksList() {
        return marks;
    }

    @Override
    public String dashboard() {
        return "Student Dashboard";
    }
    public boolean registerCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
            marks.add(new Marks(c, 0));
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return getUsername();
    }
}