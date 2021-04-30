package bll;

import bll.validators.PriceValidator;
import bll.validators.QuantityValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {
    private List<Validator<Product>> validators;
    private ProductDAO productDAO = new ProductDAO();

    public ProductBLL() {
        validators = new ArrayList<>();
        validators.add(new PriceValidator());
        validators.add(new QuantityValidator());
    }

    public Product findProductById(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return product;
    }

    public List<Product> findAll() {
        List<Product> products = productDAO.findAll();
        if (products.isEmpty()) {
            throw new NoSuchElementException("Empty list!");
        }
        return products;
    }

    public void insertProduct(String name, int quantity, double price) {
        Product product = new Product(name, quantity, price);
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        int id = productDAO.insert(product);
    }

    public void updateProduct(int id, String name, int quantity, double price) {
        Product product = new Product(id, name, quantity, price);
        if (findProductById(id) != null) {
            for (Validator<Product> v : validators) {
                v.validate(product);
            }
            productDAO.update(product);
        }else {
            throw new NoSuchElementException("Incorrect id!");
        }
    }

    public void deleteProduct(int id) {
        productDAO.delete(id);
    }
}
