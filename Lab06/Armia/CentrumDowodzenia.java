package Armia;

import java.util.*;

/**
 * CentrumDowodzenia class
 *
 * @author Piotr Moszkowicz
 * @version 1.0
 */
public class CentrumDowodzenia {
    private ArrayList<Czolg> tanks;

    /**
     * Constructs CentrumDowodzenia object
     */
    public CentrumDowodzenia() {
        this.tanks = new ArrayList<>();
    }

    /**
     * Sends order to the tank by number
     * @param tankNumber [String]       -   Tank number
     * @param order      [Rokaz]        -   Order to send
     */
    public void wydajRozkaz(String tankNumber, Rozkaz order) {
        tanks.get(Integer.parseInt(tankNumber) - 1).addRozkaz(order);
    }

    /**
     * Registers tank to the headquarters
     * @param tank      [Czolg]         -   Tank to register
     */
    public void zarejestrujCzolg(Czolg tank) {
        this.tanks.add(tank);
    }

    /**
     * Returns current HQ status
     * @return          [String]        -   All tanks with assigned orders
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n");
        for (int i = 1; i <= this.tanks.size(); i++) {
            result.append(String.format("Czolg nr %d otrzymal rozkazy:\n", i));
            result.append(this.tanks.get(i - 1)).append("\n");
        }
        return result.toString();
    }
}
