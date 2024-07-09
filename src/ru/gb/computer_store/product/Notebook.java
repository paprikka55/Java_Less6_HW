package ru.gb.computer_store.product;

import ru.gb.computer_store.product.enums.Color;
import ru.gb.computer_store.product.enums.Os;

import java.util.LinkedHashMap;
import java.util.Map;

public class Notebook extends Product {

    private double screenDiagonal;
    private int ram;
    private int diskCapacity;
    private String processor;
    private Os os;
    private Color color;

    public Notebook(String model, String vendor, double price, double screenDiagonal, int ram, int diskCapacity, String processor, Os os, Color color) {
        super(model, vendor, price);
        this.screenDiagonal = screenDiagonal;
        this.ram = ram;
        this.diskCapacity = diskCapacity;
        this.processor = processor;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "________________________" + '\n' +
                "Notebook: " + "\n" +
                super.toString() +
                "Screen " + screenDiagonal + "\"" + '\n' +
                "RAM: " + ram + " GB" + '\n' +
                "ROM: " + diskCapacity + " GB" + '\n' +
                "Processor: " + processor + '\n' +
                "OS: " + os + '\n' +
                "Color: " + color + '\n' +
                "________________________" + '\n';
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDiskCapacity() {
        return diskCapacity;
    }

    public void setDiskCapacity(int diskCapacity) {
        this.diskCapacity = diskCapacity;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Map<String, Object> getFieldsAsMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("model", this.getModel());
        result.put("vendor", this.getVendor());
        result.put("price", this.getPrice());
        result.put("screenDiagonal", screenDiagonal);
        result.put("ram", ram);
        result.put("diskCapacity", diskCapacity);
        result.put("processor", processor);
        result.put("os", os);
        result.put("color", color);
        return result;
    }

    public Object getField(String param) {
        Object result = null;
        switch (param) {
            case ("model"):
                result = super.getModel();
                break;
            case ("vendor"):
                result = super.getVendor();
                break;
            case ("price"):
                result = super.getPrice();
                break;
            case ("screenDiagonal"):
                result = this.screenDiagonal;
                break;
            case ("ram"):
                result = ram;
                break;
            case ("diskCapacity"):
                result = diskCapacity;
                break;
            case ("processor"):
                result = processor;
                break;
            case ("os"):
                result = os;
                break;
            case ("color"):
                result = color;
                break;
        }
        return result;
    }

}
