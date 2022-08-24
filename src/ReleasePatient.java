/*
Name = Tahzib Yafi
NSID = tay642
Student number = 11255718
Course number = CMPT 270-01
Tutorial section = T09
*/

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
