package universitymanagment.com.universitymanagementsystem;

public class Teacher extends User {

    public Teacher(String u, String p) {
        super(u, p);
    }

    public void uploadMarks(Student s, Course c, int score) {
        for (Marks m : s.getMarksList()) {
            if (m.getCourse().getCourseCode().equals(c.getCourseCode())) {
                m.setScore(score);
            }
        }
    }

    @Override
    public String dashboard() {
        return "Teacher Dashboard";
    }
}