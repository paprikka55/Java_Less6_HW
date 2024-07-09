package ru.gb.computer_store.product;

public class Product {
    private String model;
    private String vendor;
    private double price;

    public Product(String model, String vendor, double price) {
        this.price = price;
        this.model = model;
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Vendor: " + vendor + '\n' +
                "Model: " + model + '\n' +
                "Price: " + price + " RUB" + '\n';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
