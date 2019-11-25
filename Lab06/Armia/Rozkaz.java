package Armia;

/**
 * Rozkaz class
 *
 * @author Piotr Moszkowicz
 * @version 1.0
 */
public class Rozkaz {
    private String orderText;

    /**
     * Constructs CentrumDowodzenia object
     * @param orderText         [String]        -   Text of the order
     */
    public Rozkaz(String orderText) {
        this.orderText = orderText;
    }

    /**
     * Returns string representation of order
     * @return                  [String]        -   Text of the order
     */
    @Override
    public String toString() {
        return this.orderText;
    }
}
