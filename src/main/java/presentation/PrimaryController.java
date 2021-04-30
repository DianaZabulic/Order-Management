package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimaryController {
    Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void openWindowClients(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/clientsView/optionsClients.fxml"));
        AnchorPane layout = Loader.load();
        ClientsController controller = Loader.getController();
        Scene scene = new Scene(layout);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        controller.setStage(newStage);
        newStage.setTitle("Clients");
        newStage.show();
    }

    public void openWindowProducts(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/productsView/optionsProducts.fxml"));
        AnchorPane layout = Loader.load();
        ProductsController controller = Loader.getController();
        Scene scene = new Scene(layout);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        controller.setStage(newStage);
        newStage.setTitle("Products");
        newStage.show();
    }

    public void openWindowOrders(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/ordersView/addOrder.fxml"));
        AnchorPane layout = Loader.load();
        OrdersController controller = Loader.getController();
        Scene scene = new Scene(layout);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        controller.setStage(newStage);
        newStage.setTitle("Orders");
        newStage.show();
    }
}
