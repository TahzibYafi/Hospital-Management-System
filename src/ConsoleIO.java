/*
Name = Tahzib Yafi
NSID = tay642
Student number = 11255718
Course number = CMPT 270-01
Tutorial section = T09
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIO implements InputOutputInterface{
    /**
     One Scanner for all methods
     */
    private static Scanner consoleIn = new Scanner(System.in);

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return consoleIn.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int entered;
        while (true) {
            try {
                consoleIn = new Scanner(System.in);
                entered = consoleIn.nextInt();
                break;
            } catch (InputMismatchException | NumberFormatException ex) {
                System.out.println("Please enter an integer");
            }
        }
        consoleIn.nextLine(); // discard the remainder of the line
        return entered;
    }

    @Override
    public int readChoice(String[] options) {
        String prompt = "";
        for(String str : options){
          //  prompt += str + "\n";
            System.out.println(str);
        }
        int entered;
        while (true) {
            try {
                consoleIn = new Scanner(System.in);
                entered = readInt(prompt);
                break;
            }  catch (InputMismatchException | NumberFormatException ex) {
                System.out.println("Please enter an integer");
            }
        }
        return entered-1;
    }

    @Override
    public void outputString(String outString) {
        System.out.println(outString);
    }

    public static void main(String[] args){
        // Testing each methods
        String []options = new String[] {"1: Default", "2: add a new patient", "3: add a new doctor",
                "4: assign a doctor to a patient", "5: display the empty beds of the ward", "6: assign a patient a bed",
                "7: release a patient", "8: drop doctor-patient association", "9: display current system state"};

        String name = "Enter your name";
        String val = "Enter a value";
        ConsoleIO console = new ConsoleIO();
        int intVal = console.readInt(val);
        String strVal = console.readString(name);
        int choice = console.readChoice(options);
        String output = "Input value for readString() " + intVal + "\nInput value for readInt() " + strVal
                        + "\nIndex value for readChoice() " + choice ;

        console.outputString(output);
    }
}

