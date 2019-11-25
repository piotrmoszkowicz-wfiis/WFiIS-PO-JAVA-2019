package Armia;

import java.util.ArrayList;

/**
 * Czolg class
 *
 * @author Piotr Moszkowicz
 * @version 1.0
 */
public class Czolg {
    private ArrayList<Rozkaz> orders;

    /**
     * Constructs Czolg object
     */
    public Czolg() {
        this.orders = new ArrayList<>();
    }

    /**
     * Adds order to the tank
     * @param order         [Rozkaz]        -   Order to add
     */
    void addRozkaz(Rozkaz order) {
        this.orders.add(order);
    }

    /**
     * Returns last order of tank
     * @return              [String]        -   Last order formatted
     */
    public String ostatniRozkaz() {
        return "Ostatni rozkaz do mnie: " + this.orders.get(this.orders.size() - 1);
    }

    /**
     * Returns string tank representation
     * @return              [String]        -   String tank representation
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Rozkaz order : this.orders) {
            result.append(order).append("\n");
        }
        return result.toString();
    }
}
