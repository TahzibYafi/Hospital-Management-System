import java.util.Collection;

/**
 * Displays the system state
 */
public class SystemState implements Command{
    @Override
    public void execute() {
        String result = "\nThe patients in the system are \n";
        Collection<Patient> patientsColl = PatientMapAccess.getInstance().values();
        for (Patient p : patientsColl)
            result = result + p;
        result = result + "\nThe doctors in the system are \n";
        Collection<Doctor> doctorsColl = DoctorMapAccess.getInstance().values();
        for (Doctor d : doctorsColl)
            result = result + d;
        result = result + "\nThe ward is " + WardAccess.getInstance();
        IOAccess.getInstance().outputString(result);
    }
}
