/*
Name = Tahzib Yafi
NSID = tay642
Student number = 11255718
Course number = CMPT 270-01
Tutorial section = T09
*/

import java.util.TreeMap;

/**
 * Singleton class containing all patients of the system
 */
public class PatientMapAccess{
    private static TreeMap<String, Patient> dictionary;

    private PatientMapAccess(){};   // Ensures that no instance of this class is created

    public static TreeMap<String, Patient> getInstance(){
        if(dictionary==null){
            dictionary = new TreeMap<>();
        }
        return dictionary;
    }
}