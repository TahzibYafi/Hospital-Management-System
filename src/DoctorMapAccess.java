
import java.util.TreeMap;

/**
 * Singleton class containing all doctors of the system
 */
public class DoctorMapAccess{
    private static TreeMap<String, Doctor> dictionary;

    private DoctorMapAccess(){};   // Ensures that no instance of this class is created

    public static TreeMap<String, Doctor> getInstance(){
        if(dictionary==null){
            dictionary = new TreeMap<>();
        }
        return dictionary;
    }
}
