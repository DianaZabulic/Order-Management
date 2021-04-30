package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.PrimaryController;

public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/primaryView.fxml"));
        AnchorPane layout = Loader.load();

        PrimaryController controller = Loader.getController();
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        controller.setStage(primaryStage);
        primaryStage.setTitle("Order management");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
