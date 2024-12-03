package it.unibo.javafx.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Counter {
    private final IntegerProperty value;

    public Counter() {
        this.value = new SimpleIntegerProperty(0);
    }

    public void increment() {
        //throw new UnsupportedOperationException("Not implemented yet");
        this.value.set(this.value.get() + 1);
    }

    public void decrement() {
        //throw new UnsupportedOperationException("Not implemented yet");
        this.value.set(this.value.get() - 1);
    }

    public IntegerProperty counterProperty() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
