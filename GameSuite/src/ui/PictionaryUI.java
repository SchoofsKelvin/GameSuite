package ui;

import domain.Punt;

import javax.swing.*;

public class PictionaryUI {

    private Speler speler;

    public PictionaryUI(Speler speler) {
        this.speler = speler;
    }

    public void showMenu() {
        int x = getIntegerUsingDialog("x coordinaat van het punt:");
        int y = getIntegerUsingDialog("y coordinaat van het punt:");
        Punt punt = new Punt(x, y);
        JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
    }

    private int getIntegerUsingDialog(String message) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(message));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "There was a problem!\n" + e.getClass() + ": " + e.getMessage());
            }
        }
    }

}
