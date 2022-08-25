
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
