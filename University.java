package universitymanagment.com.universitymanagementsystem;

import java.util.ArrayList;

public class University {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public University() {

        users = new ArrayList<>();
        students = new ArrayList<>();
        teachers = new ArrayList<>();

        students.add(new Student("Ali", "123"));
        students.add(new Student("Ahmed", "123"));
        students.add(new Student("Zainab", "123"));
        students.add(new Student("Fatima", "123"));
        students.add(new Student("Hassan", "123"));

        users.addAll(students);

        teachers.add(new Teacher("President Shahid", "123"));
        teachers.add(new Teacher("Dr.Khan", "123"));
        teachers.add(new Teacher("Ms.Johnson", "123"));
        teachers.add(new Teacher("Mr.Ali", "123"));
        teachers.add(new Teacher("Dr.Ahmed", "123"));

        users.addAll(teachers);

        Admin a = new Admin("admin", "123");
        users.add(a);

        courses.add(new Course("OOP", "C1", 3));
        courses.add(new Course("Calculus", "C2", 3));
        courses.add(new Course("Physics", "C3", 3));
        courses.add(new Course("English", "C4", 2));
        courses.add(new Course("DLD", "C5", 3));
        courses.add(new Course("Pakistan Studies", "C6", 2));
    }

    public User login(String u, String p) {
        for (User user : users) {
            if (user.getUsername().equals(u) && user.getPassword().equals(p)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<Course> getCourses() { return courses; }
    public ArrayList<Student> getStudents() { return students; }
    public ArrayList<Teacher> getTeachers() { return teachers; }

    public String getCoursesString() {
        StringBuilder s = new StringBuilder();
        for (Course c : courses) s.append(c).append("\n");
        return s.toString();
    }

    public String getStudentsString() {
        StringBuilder s = new StringBuilder();
        for (Student st : students) s.append(st.getUsername()).append("\n");
        return s.toString();
    }

    public String getTeachersString() {
        StringBuilder s = new StringBuilder();
        for (Teacher t : teachers) s.append(t.getUsername()).append("\n");
        return s.toString();
    }
}