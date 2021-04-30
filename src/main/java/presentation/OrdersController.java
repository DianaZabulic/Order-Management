package presentation;

import bll.OrderBLL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrdersController {
    @FXML
    private TextField clientField;
    @FXML
    private TextField productField;
    @FXML
    private TextField quantityField;
    @FXML
    private Label label;
    Stage stage;
    OrderBLL orderBLL = new OrderBLL();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void addOrder(ActionEvent actionEvent) {
        try {
            orderBLL.insertOrder(Integer.parseInt(clientField.getText()), Integer.parseInt(productField.getText()),
                    Integer.parseInt(quantityField.getText()));
            label.setText("Done!");
        }catch (Exception e){
            label.setText(e.getMessage());
        }
    }
}
