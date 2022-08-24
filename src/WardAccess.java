/*
Name = Tahzib Yafi
NSID = tay642
Student number = 11255718
Course number = CMPT 270-01
Tutorial section = T09
*/

/**
 * Singleton class containing reference to a single ward
 */
public class WardAccess{
    private static Ward ward;

    private WardAccess(){}; // Ensures that no instance of this class is created

    public static void initialize(String name, int first, int last){
        if(ward!=null){
            throw new  IllegalStateException("Ward has already been created!");
        }
        else{
            ward = new Ward(name, first, last);
        }

    }
    public static Ward getInstance(){
        if(ward==null){
            throw new  IllegalStateException("Ward has not been created yet!");
        }
        return ward;
    }
}
