import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerDashboard {
    private Scene scene;

    public CustomerDashboard(Stage primaryStage, String username) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label welcomeLabel = new Label("Welcome, " + username);
        Button viewRoomsButton = new Button("View Available Rooms");
        Button makeReservationButton = new Button("Make a Reservation");
        Button extendReservationButton = new Button("Extend Reservation");
        Button cancelReservationButton = new Button("Cancel Reservation");
        Button submitReviewButton = new Button("Submit a Review");
        Button logoutButton = new Button("Logout");

        layout.getChildren().addAll(welcomeLabel, viewRoomsButton, makeReservationButton,
                extendReservationButton, cancelReservationButton,
                submitReviewButton, logoutButton);

        viewRoomsButton.setOnAction(e -> {
            RoomService roomService = new RoomService();
            roomService.displayAvailableRooms();
        });

        makeReservationButton.setOnAction(e -> {
            ReservationService reservationService = new ReservationService();
            reservationService.makeReservationUI(username);
        });

        extendReservationButton.setOnAction(e -> {
            ReservationService reservationService = new ReservationService();
            reservationService.extendReservationUI(username);
        });

        cancelReservationButton.setOnAction(e -> {
            ReservationService reservationService = new ReservationService();
            reservationService.cancelReservationUI(username);
        });

        submitReviewButton.setOnAction(e -> {
            ReviewService reviewService = new ReviewService();
            reviewService.submitReviewUI(username);
        });

        logoutButton.setOnAction(e -> primaryStage.setScene(new LoginScreen(primaryStage).getScene()));

        scene = new Scene(layout, 400, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
