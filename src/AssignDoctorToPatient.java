import java.util.NoSuchElementException;


/**
 * Assign a doctor to take care of a patient.
 */
public class AssignDoctorToPatient implements Command{

    @Override
    public void execute() {
        IOAccess.getInstance().outputString("Assigning a new Doctor-Patient Association...");
        String healthNumber = IOAccess.getInstance().readString("Enter the health number of the patient: ");

        Patient p = PatientMapAccess.getInstance().get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        IOAccess.getInstance().outputString("Getting Doctor information...");
        String name = IOAccess.getInstance().readString("Enter the name of the doctor: ");
        Doctor d = DoctorMapAccess.getInstance().get(name);
        if (d == null)
            throw new NoSuchElementException("There is no doctor with name " + name);
        else {
            p.addDoctor(d);
            d.addPatient(p);
        }
    }
}
