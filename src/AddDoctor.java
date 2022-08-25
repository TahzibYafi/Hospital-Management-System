
/**
 * Read the information for a new doctor and then add the doctor
 * to the dictionary of all doctors.
 */

public class AddDoctor implements Command{

    @Override
    public void execute() {
        IOAccess.getInstance().outputString("Adding Doctor to Ward...");
        String name = IOAccess.getInstance().readString("Enter the name of the doctor: ");
        IOAccess.getInstance().outputString("Entered: " + name);
        if (DoctorMapAccess.getInstance().containsKey(name))
            throw new IllegalStateException("Doctor not added as there already "
                    + "is a doctor with the name " + name);

        String response = IOAccess.getInstance().readString("Is the doctor a surgeon? (yes or no)");
        IOAccess.getInstance().outputString("Entered: " + response);
        Doctor d;
        if (response.charAt(0) == 'y' || response.charAt(0) == 'Y')
            d = new Surgeon(name);
        else
            d = new Doctor(name);

        // check to make sure the doctor name doesn't already exist
        Doctor sameNumberDoctor = DoctorMapAccess.getInstance().put(name, d);
        if (sameNumberDoctor != null) {
            DoctorMapAccess.getInstance().put(name, sameNumberDoctor); // put the original doctor back
            throw new IllegalStateException("Name in the doctor dictionary even though "
                    + "containsKey failed.  Name " + name + " not entered.");
        }
    }
}
