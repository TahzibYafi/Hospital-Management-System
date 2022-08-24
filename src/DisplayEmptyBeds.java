/*
Name = Tahzib Yafi
NSID = tay642
Student number = 11255718
Course number = CMPT 270-01
Tutorial section = T09
*/


import java.util.LinkedList;

/**
 * Display the empty beds for the ward.
 * Method is just a stub, needs to be implemented
 */
public class DisplayEmptyBeds implements Command {

    @Override
    public void execute() {
        LinkedList<Integer> freebed = WardAccess.getInstance().availableBeds();
        for (Integer i : freebed) {
            IOAccess.getInstance().outputString(i + " ");
        }
    }
}
