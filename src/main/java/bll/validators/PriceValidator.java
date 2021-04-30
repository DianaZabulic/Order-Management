package bll.validators;

import model.Product;

public class PriceValidator implements Validator<Product> {

    public void validate(Product t) {
        if (t.getPrice() < 0.0) {
            throw new IllegalArgumentException("The price must be a positive value!");
        }
    }
}
