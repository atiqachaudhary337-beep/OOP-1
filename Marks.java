package universitymanagment.com.universitymanagementsystem;

public class Marks {
    private Course course;
    private int score;

    public Marks(Course c, int s) {
        course = c;
        score = s;
    }

    public Course getCourse() {
        return course;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int s) {
        score = s;
    }
}