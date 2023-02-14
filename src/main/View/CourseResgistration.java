package View;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CourseRegistration extends Application {
    private ObservableList<String> courses = FXCollections.observableArrayList();
    private ListView<String> coursesListView = new ListView<>(courses);

    @Override
    public void start(Stage primaryStage) {
        // Load the available course list from the backend
        loadCourses();

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> registerSelectedCourses());

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(coursesListView, registerButton);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Course Registration");
        primaryStage.show();
    }

    private void loadCourses() {
        // TODO: Load the available course list from the backend
        courses.addAll("SWE4403", "SWE4203, "SWE4103", "CS4103");
    }

    private void registerSelectedCourses() {
        // TODO: Send the registering information to the backend
        System.out.println("Selected courses: " + coursesListView.getSelectionModel().getSelectedItems());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

