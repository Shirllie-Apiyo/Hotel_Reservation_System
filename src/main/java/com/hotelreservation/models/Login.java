import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginScreen {
    private Scene scene;

    public LoginScreen(Stage primaryStage) {
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setHgap(10);
        layout.setVgap(10);

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Button exitButton = new Button("Exit");

        layout.add(usernameLabel, 0, 0);
        layout.add(usernameField, 1, 0);
        layout.add(passwordLabel, 0, 1);
        layout.add(passwordField, 1, 1);
        layout.add(loginButton, 1, 2);
        layout.add(exitButton, 1, 3);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            UserService userService = new UserService();

            String role = userService.authenticateUser(username, password);
            if (role != null) {
                if (role.equals("Customer")) {
                    CustomerDashboard customerDashboard = new CustomerDashboard(primaryStage, username);
                    primaryStage.setScene(customerDashboard.getScene());
                } else if (role.equals("Receptionist")) {
                    ReceptionistDashboard receptionistDashboard = new ReceptionistDashboard(primaryStage);
                    primaryStage.setScene(receptionistDashboard.getScene());
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Credentials!");
                alert.show();
            }
        });

        exitButton.setOnAction(e -> primaryStage.close());

        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
