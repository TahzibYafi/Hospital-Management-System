/*
Name = Tahzib Yafi
NSID = tay642
Student number = 11255718
Course number = CMPT 270-01
Tutorial section = T09
*/

import java.util.Scanner;

/**
 * Singleton class containing reference to a single IOinterface
 */
public class IOAccess {
    private static InputOutputInterface io;

    private IOAccess(){};  // Ensures that no instance of this class is created

    public static InputOutputInterface getInstance(){
        if (io==null){
            io = new DialogIO();
            io.outputString("Which interface do you prefer for communicating?");
            String answer = io.readString("Enter C for Console or D for Dialog : ");
            if (!answer.equalsIgnoreCase("D")){
                io = new ConsoleIO();
            }
        }
        return io;
    }
}

