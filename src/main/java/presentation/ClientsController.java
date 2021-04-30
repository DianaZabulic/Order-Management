package presentation;

import bll.ClientBLL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Client;

import java.io.IOException;
import java.util.List;

public class ClientsController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField idField;
    @FXML
    private Label label;
    @FXML
    private TableView<Client> table;
    @FXML
    private TableColumn<Client, Integer> idColumn;
    @FXML
    private TableColumn<Client, String> nameColumn;
    @FXML
    private TableColumn<Client, String> addressColumn;
    Stage stage;
    ClientBLL clientBLL = new ClientBLL();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void showClients(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/clientsView/showClients.fxml"));
        AnchorPane layout = Loader.load();
        ClientsController controller = Loader.getController();
        Scene newScene = new Scene(layout);
        stage.setScene(newScene);
        controller.setStage(stage);
        controller.showTable();
    }

    public void addClient(ActionEvent actionEvent) {
        clientBLL.insertClient(nameField.getText(), addressField.getText());
        label.setText("Done!");
    }

    public void editClient(ActionEvent actionEvent) {
        clientBLL.updateClient(Integer.parseInt(idField.getText()), nameField.getText(), addressField.getText());
        label.setText("Done!");
    }

    public void deleteClient(ActionEvent actionEvent) {
        clientBLL.deleteClient(Integer.parseInt(idField.getText()));
        label.setText("Done!");
    }

    public void showTable() {
        ObservableList<Client> data = FXCollections.observableArrayList();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        List<Client> clients = clientBLL.findAll();
        data.setAll(clients);
        table.setItems(data);
    }

    public void showAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/clientsView/addClient.fxml"));
        AnchorPane layout = Loader.load();
        ClientsController controller = Loader.getController();
        Scene newScene = new Scene(layout);
        stage.setScene(newScene);
        controller.setStage(stage);
    }

    public void showEdit(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/clientsView/editClient.fxml"));
        AnchorPane layout = Loader.load();
        ClientsController controller = Loader.getController();
        Scene newScene = new Scene(layout);
        stage.setScene(newScene);
        controller.setStage(stage);
    }

    public void showDelete(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/clientsView/deleteClient.fxml"));
        AnchorPane layout = Loader.load();
        ClientsController controller = Loader.getController();
        Scene newScene = new Scene(layout);
        stage.setScene(newScene);
        controller.setStage(stage);
    }
}
