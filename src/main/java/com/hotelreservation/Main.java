import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HotelReservationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Set up initial login screen
        LoginScreen loginScreen = new LoginScreen(primaryStage);
        primaryStage.setScene(loginScreen.getScene());
        primaryStage.setTitle("Hotel Reservation System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
