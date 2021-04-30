package bll.validators;

import model.Product;

public class QuantityValidator implements Validator<Product>{

    public void validate(Product t) {
        if(t.getQuantity()<0){
            throw new IllegalArgumentException("The quantity must be greater than 0!");
        }
    }
}
