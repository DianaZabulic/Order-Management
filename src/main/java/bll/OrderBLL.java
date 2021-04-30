package bll;

import bll.validators.StockValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Client;
import model.OrderTable;
import model.Product;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderBLL {
    private List<Validator<OrderTable>> validators;
    private OrderDAO orderDAO = new OrderDAO();

    public OrderBLL() {
        validators = new ArrayList<>();
        validators.add(new StockValidator());
    }

    private void createPDF(OrderTable order) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream pageContentStream = new PDPageContentStream(document, page);
            pageContentStream.beginText();
            pageContentStream.setFont(PDType1Font.TIMES_ROMAN, 14);
            pageContentStream.newLineAtOffset(100, 700);
            pageContentStream.showText("Order #" + order.getIdOrder());
            pageContentStream.newLineAtOffset(0, -15);
            pageContentStream.newLineAtOffset(0, -15);
            ClientDAO clientDAO = new ClientDAO();
            Client client = clientDAO.findById(order.getIdClient());
            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.findById(order.getIdProduct());
            pageContentStream.showText(client.toString());
            pageContentStream.newLineAtOffset(0, -15);
            pageContentStream.showText(product.toString() + ", quantity: " + order.getQuantity());
            pageContentStream.newLineAtOffset(0, -15);
            pageContentStream.showText("Total: " + (order.getQuantity() * product.getPrice()));
            pageContentStream.endText();
            pageContentStream.close();
            String billName = "bill" + order.getIdOrder() + ".pdf";
            document.save(billName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertOrder(int idClient, int idProduct, int quantity) {
        OrderTable order = new OrderTable(idClient, idProduct, quantity);
        for (Validator<OrderTable> v : validators) {
            v.validate(order);
        }
        int orderID = orderDAO.insert(order);
        OrderTable orderTable = new OrderTable(orderID, idClient, idProduct, quantity);
        createPDF(orderTable);
    }
}
