package universitymanagment.com.universitymanagementsystem;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    University uni = new University();

    @Override
    public void start(Stage stage) {
        showLogin(stage);
    }

    private void showLogin(Stage stage) {
        TextField username = new TextField();
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Label msg = new Label();

        Button login = new Button("Login");
        Button exit = new Button("Exit");

        login.setOnAction(e -> {
            User user = uni.login(username.getText(), password.getText());

            if (user != null) {
                msg.setText("");

                if (user instanceof Student)
                    showStudent(stage, (Student) user);
                else if (user instanceof Teacher)
                    showTeacher(stage, (Teacher) user);
                else if (user instanceof Admin)
                    showAdmin(stage, (Admin) user);
            } else {
                msg.setText("Invalid Login!");
            }
        });

        exit.setOnAction(e -> stage.close());

        VBox layout = new VBox(10, username, password, login, exit, msg);
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout, 400, 300));
        stage.setTitle("Login");
        stage.show();
    }

    private void showStudent(Stage stage, Student s) {
        Button viewCourses = new Button("View Courses");
        Button register = new Button("Register Course");
        Button marks = new Button("View Marks");
        Button logout = new Button("Logout");

        Label output = new Label();

        viewCourses.setOnAction(e -> output.setText(uni.getCoursesString()));

        register.setOnAction(e -> {
            ChoiceDialog<Course> dialog = new ChoiceDialog<>(uni.getCourses().get(0), uni.getCourses());
            dialog.setTitle("Register Course");
            dialog.setHeaderText("Select a course to register");
            dialog.setContentText("Available Courses:");

            dialog.showAndWait().ifPresent(course -> {
                boolean added = s.registerCourse(course);

                if (added)
                    output.setText("Registered: " + course.getCourseName());
                else
                    output.setText("Already Registered!");
            });
        });

        marks.setOnAction(e -> output.setText(s.viewMarks()));

        logout.setOnAction(e -> showLogin(stage));

        VBox layout = new VBox(10, viewCourses, register, marks, logout, output);
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout, 400, 300));
        stage.setTitle("Student Dashboard");
    }

    private void showTeacher(Stage stage, Teacher t) {
        Button upload = new Button("Upload Marks");
        Button logout = new Button("Logout");

        Label msg = new Label();

        upload.setOnAction(e -> {

            ChoiceDialog<Student> studentDialog =
                    new ChoiceDialog<>(uni.getStudents().get(0), uni.getStudents());
            studentDialog.setTitle("Select Student");
            studentDialog.setHeaderText("Choose Student");

            studentDialog.showAndWait().ifPresent(student -> {

                ChoiceDialog<Course> courseDialog =
                        new ChoiceDialog<>(uni.getCourses().get(0), uni.getCourses());
                courseDialog.setTitle("Select Course");
                courseDialog.setHeaderText("Choose Course");

                courseDialog.showAndWait().ifPresent(course -> {

                    TextInputDialog marksDialog = new TextInputDialog();
                    marksDialog.setTitle("Enter Marks");
                    marksDialog.setHeaderText("Enter marks for student");
                    marksDialog.setContentText("Marks:");

                    marksDialog.showAndWait().ifPresent(input -> {
                        try {
                            int score = Integer.parseInt(input);

                            t.uploadMarks(student, course, score);
                            msg.setText("Marks Updated for " + student.getUsername());

                        } catch (NumberFormatException ex) {
                            msg.setText("Invalid marks input!");
                        }
                    });

                });
            });
        });

        logout.setOnAction(e -> showLogin(stage));

        VBox layout = new VBox(10, upload, logout, msg);
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout, 400, 300));
        stage.setTitle("Teacher Dashboard");
    }

    private void showAdmin(Stage stage, Admin a) {
        Button students = new Button("View Students");
        Button teachers = new Button("View Teachers");
        Button courses = new Button("View Courses");
        Button logout = new Button("Logout");

        Label output = new Label();

        students.setOnAction(e -> output.setText(uni.getStudentsString()));
        teachers.setOnAction(e -> output.setText(uni.getTeachersString()));
        courses.setOnAction(e -> output.setText(uni.getCoursesString()));

        logout.setOnAction(e -> showLogin(stage));

        VBox layout = new VBox(10, students, teachers, courses, logout, output);
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout, 400, 300));
        stage.setTitle("Admin Dashboard");
    }
}