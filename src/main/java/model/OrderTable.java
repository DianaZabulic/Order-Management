package model;

public class OrderTable {
    private int id;
    private int idClient;
    private int idProduct;
    private int quantity;

    public OrderTable() { // empty constructor required for the "createObjects" function from "AbstractDAO" class
    }

    public OrderTable(int id, int idClient, int idProduct, int quantity) {
        this.id = id;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public OrderTable(int idClient, int idProduct, int quantity) {
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public int getIdOrder() {
        return id;
    }

    public void setIdOrder(int idOrder) {
        this.id = idOrder;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order [id = " + id + ", client id = " + idClient + ", product id = " + idProduct
                + ", quantity = " + quantity + "]";
    }
}
