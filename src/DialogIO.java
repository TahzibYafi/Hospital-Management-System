/*
Name = Tahzib Yafi
NSID = tay642
Student number = 11255718
Course number = CMPT 270-01
Tutorial section = T09
*/

import javax.swing.*;
import java.util.InputMismatchException;

public class DialogIO extends AbstractDialogIO{

    @Override
    public String readString(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    @Override
    public int readInt(String prompt) {
        int entered;
        while (true) {
            try {
                entered = Integer.parseInt(JOptionPane.showInputDialog(prompt));
                break;
            } catch (InputMismatchException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Please enter an integer");
            }
        }
        return entered;
    }

    @Override
    public void outputString(String outString) {
        JOptionPane.showMessageDialog(null,outString);
    }

    public static void main(String[] args)
    {
        // Testing each methods
        String []options = new String[] {"1: Default", "2: add a new patient", "3: add a new doctor",
                "4: assign a doctor to a patient", "5: display the empty beds of the ward", "6: assign a patient a bed",
                "7: release a patient", "8: drop doctor-patient association", "9: display current system state"};

        String name = "Enter your name";
        String val = "Enter a value";
        DialogIO dialog = new DialogIO();
        int intVal = dialog.readInt(val);
        String strVal = dialog.readString(name);
        int choice = dialog.readChoice(options);
        String output = "Input value for readString() " + strVal + "\nInput value for readInt() " + intVal
                + "\nIndex value for readChoice() " + choice ;

        dialog.outputString(output);
    }
}
