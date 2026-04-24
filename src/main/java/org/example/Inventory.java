package org.example;

public class Inventory {
    private String sku;
    private String name;
    private double price;
    private String department;
    private boolean inCart;
    private int quantity;


    public Inventory(String sku, String name, double price, String department, boolean inCart, int quantity) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
        this.inCart = inCart;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %.2f - %s", sku, name, price, department);
    }
}
