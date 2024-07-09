package ru.gb.computer_store.showcase;

import ru.gb.computer_store.product.Product;

import java.util.Iterator;
import java.util.List;

public class ShowCaseIterator implements Iterator {
    private int counter;
    private final List<Product> showCaseList;


    public ShowCaseIterator(ShowCase showCase) {
        this.showCaseList = showCase.getShowCase();
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < showCaseList.size() - 1;
    }

    @Override
    public Product next() {
        if (!hasNext()) {
            return null;
        }
        counter++;
        return showCaseList.get(counter);
    }
}
