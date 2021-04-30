package bll.validators;

import dao.ClientDAO;
import dao.ProductDAO;
import model.Client;
import model.OrderTable;
import model.Product;

import java.util.NoSuchElementException;

public class StockValidator implements Validator<OrderTable> {

    public void validate(OrderTable order) {
        ClientDAO clientDAO = new ClientDAO();
        ProductDAO productDAO = new ProductDAO();
        Client c = clientDAO.findById(order.getIdClient());
        Product p = productDAO.findById(order.getIdProduct());
        if (c == null || p == null) {
            throw new NoSuchElementException("Wrong ID!");
        }
        if (order.getQuantity() > p.getQuantity()) {
            throw new IllegalArgumentException("There are not enough products!");
        }
        p.setQuantity(p.getQuantity()-order.getQuantity());
        productDAO.update(p);
    }
}
