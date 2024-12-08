import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReceptionistDashboard {
    private Scene scene;

    public ReceptionistDashboard(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label welcomeLabel = new Label("Receptionist Dashboard");
        Button confirmCheckInButton = new Button("Confirm Check-In");
        Button confirmCheckOutButton = new Button("Confirm Check-Out");
        Button viewBookedSpacesButton = new Button("View Booked Spaces");
        Button handleReviewsButton = new Button("Handle Reviews");
        Button logoutButton = new Button("Logout");

        layout.getChildren().addAll(welcomeLabel, confirmCheckInButton, confirmCheckOutButton,
                viewBookedSpacesButton, handleReviewsButton, logoutButton);

        confirmCheckInButton.setOnAction(e -> {
            ReceptionistService receptionistService = new ReceptionistService();
            receptionistService.confirmCheckInUI();
        });

        confirmCheckOutButton.setOnAction(e -> {
            ReceptionistService receptionistService = new ReceptionistService();
            receptionistService.confirmCheckOutUI();
        });

        viewBookedSpacesButton.setOnAction(e -> {
            RoomService roomService = new RoomService();
            roomService.viewBookedSpacesUI();
        });

        handleReviewsButton.setOnAction(e -> {
            ReviewService reviewService = new ReviewService();
            reviewService.viewReviewsUI();
        });

        logoutButton.setOnAction(e -> primaryStage.setScene(new LoginScreen(primaryStage).getScene()));

        scene = new Scene(layout, 400, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
