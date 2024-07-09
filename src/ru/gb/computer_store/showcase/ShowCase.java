package ru.gb.computer_store.showcase;

import ru.gb.computer_store.product.Notebook;
import ru.gb.computer_store.product.Product;
import ru.gb.computer_store.product.enums.Color;
import ru.gb.computer_store.product.enums.Os;
import ru.gb.computer_store.product.enums.ProcessorVendors;

import java.util.*;

public class ShowCase implements Iterable<Product> {
    private List<Product> showCase;

    public ShowCase(List<Product> showCase) {
        this.showCase = showCase;
    }

    public ShowCase() {
        this.showCase = new ArrayList<>();
    }

    public void addProducts(Product... products) {
        showCase.addAll(Arrays.asList(products));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product pr : showCase) {
            result.append(pr);
        }
        return result.toString();
    }

    public List<Product> getShowCase() {
        return showCase;
    }

    private double maxValue(List<Object> values) {
        double maxValue = (double) values.getFirst();
        for (Object obj : values) {
            double curVal = (double) obj;
            if (curVal > maxValue) maxValue = curVal;
        }
        return maxValue;
    }

    private double minValue(List<Object> values) {
        double minValue = (double) values.getFirst();
        for (Object obj : values) {
            double curVal = (double) obj;
            if (curVal < minValue) minValue = curVal;
        }
        return minValue;
    }

    private int maxInt(List<Object> values) {
        int maxValue = (int) values.getFirst();
        for (Object obj : values) {
            int curVal = (int) obj;
            if (curVal > maxValue) maxValue = curVal;
        }
        return maxValue;
    }

    private int minInt(List<Object> values) {
        int minValue = (int) values.getFirst();
        for (Object obj : values) {
            int curVal = (int) obj;
            if (curVal < minValue) minValue = curVal;
        }
        return minValue;
    }

    public List<Product> filterShowCase(Map<String, List<Object>> filterParams) {
        List<Product> result = new ArrayList<>();
        boolean approach = true;

        for (Product product : showCase) {
            Notebook nb = (Notebook) product;


            for (Map.Entry<String, List<Object>> entry : filterParams.entrySet()) {
                String key = entry.getKey();
                List<Object> filterValues = entry.getValue();
                Object currentField = nb.getField(key);


                if (key.equals("price") || key.equals("screenDiagonal")) {
                    double maxValue = maxValue(filterValues);
                    double minValue = minValue(filterValues);
                    double currentValue = (double) currentField;
                    if (currentValue >= maxValue || currentValue <= minValue) {
                        approach = false;
                    }
                } else if (key.equals("ram") || key.equals("diskCapacity")) {
                    int maxValue = maxInt(filterValues);
                    int minValue = minInt(filterValues);
                    int currentValue = (int) currentField;
                    if (currentValue >= maxValue || currentValue <= minValue) {
                        approach = false;
                    }
                } else if (key.equals("os")) {
                    boolean match = false;
                    Os currentValue = (Os) currentField;
                    for (Object obj : filterValues) {
                        Os currentFilterValue = (Os) obj;
                        if (currentFilterValue.equals(currentValue)) match = true;
                    }
                    if (!match) approach = false;
                } else if (key.equals("color")) {
                    boolean match = false;
                    Color currentValue = (Color) currentField;
                    for (Object obj : filterValues) {
                        Color currentFilterValue = (Color) obj;
                        if (currentFilterValue.equals(currentValue)) match = true;
                    }
                    if (!match) approach = false;
                } else if (key.equals("model") || key.equals("vendor")) {
                    boolean match = false;
                    for (Object obj : filterValues) {
                        String currentFilterValue = ((String) obj);
                        String currentValue = (String) ((String) currentField);
                        if (currentValue.equals(currentFilterValue)) match = true;
                    }
                    if (!match) approach = false;
                } else if (key.equals("processor")) {
                    boolean match = false;
                    String currentValue = ((String) currentField).toLowerCase();
                    for (Object obj : filterValues) {
                        ProcessorVendors pv = (ProcessorVendors) obj;
                        String currentFilterValue = pv.toString().toLowerCase();
                        if (currentValue.contains(currentFilterValue)) match = true;
                    }
                    if (!match) approach = false;
                }

            }
            if(approach){
                result.add(product);
            }
            approach = true;
        }
        return result;
    }

    @Override
    public ShowCaseIterator iterator() {
        return new ShowCaseIterator(this);
    }


}
