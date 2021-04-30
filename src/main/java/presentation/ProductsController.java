package presentation;

import bll.ProductBLL;
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
import model.Product;

import java.io.IOException;
import java.util.List;

public class ProductsController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField idField;
    @FXML
    private Label label;
    @FXML
    private TableView<Product> table;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, Integer> quantityColumn;
    @FXML
    private TableColumn<Product, Double> priceColumn;
    Stage stage;
    ProductBLL productBLL = new ProductBLL();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void showProducts(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/productsView/showProducts.fxml"));
        AnchorPane layout = Loader.load();
        ProductsController controller = Loader.getController();
        Scene newScene = new Scene(layout);
        stage.setScene(newScene);
        controller.setStage(stage);
        controller.showTable();
    }

    public void addProduct(ActionEvent actionEvent) {
        productBLL.insertProduct(nameField.getText(), Integer.parseInt(quantityField.getText()),
                Double.parseDouble(priceField.getText()));
        label.setText("Done!");
    }

    public void editProduct(ActionEvent actionEvent) {
        productBLL.updateProduct(Integer.parseInt(idField.getText()), nameField.getText(),
                Integer.parseInt(quantityField.getText()), Double.parseDouble(priceField.getText()));
        label.setText("Done!");
    }

    public void deleteProduct(ActionEvent actionEvent) {
        productBLL.deleteProduct(Integer.parseInt(idField.getText()));
        label.setText("Done!");
    }

    public void showTable() {
        ObservableList<Product> data = FXCollections.observableArrayList();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        List<Product> products = productBLL.findAll();
        data.setAll(products);
        table.setItems(data);
    }

    public void showAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/productsView/addProduct.fxml"));
        AnchorPane layout = Loader.load();
        ProductsController controller = Loader.getController();
        Scene newScene = new Scene(layout);
        stage.setScene(newScene);
        controller.setStage(stage);
    }

    public void showEdit(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/productsView/editProduct.fxml"));
        AnchorPane layout = Loader.load();
        ProductsController controller = Loader.getController();
        Scene newScene = new Scene(layout);
        stage.setScene(newScene);
        controller.setStage(stage);
    }

    public void showDelete(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/productsView/deleteProduct.fxml"));
        AnchorPane layout = Loader.load();
        ProductsController controller = Loader.getController();
        Scene newScene = new Scene(layout);
        stage.setScene(newScene);
        controller.setStage(stage);
    }
}
