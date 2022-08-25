/**
 * Release a patient from the ward.
 * Method is just a stub, needs to be implemented
 */
public class ReleasePatient implements Command{
    @Override
    public void execute() {
        String healthNumber = IOAccess.getInstance().readString("Enter the health number of the patient: ");
        Patient p = PatientMapAccess.getInstance().get(healthNumber);
        WardAccess.getInstance().freeBed(p.getBedLabel());
    }
}
