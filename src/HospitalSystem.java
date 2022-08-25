/**
 * A simple hospital system with only one ward.  Patients and doctors can be created,
 * and patients assigned to a doctor and/or placed in a bed of the ward.
 */
public class HospitalSystem {

    /**
     * Initialize an instance of the hospital ward
     * relies on user-input to get the relavent information
     */
    public HospitalSystem() {};

    /**
     * Run the hospital system.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        int task = -1;

        // Initializing all the classes that implements Command class
        SystemState systemState = new SystemState();
        AddPatient addPatient = new AddPatient();
        AddDoctor addDoctor = new AddDoctor();
        AssignDoctorToPatient assignDoctorToPatient = new AssignDoctorToPatient();
        DisplayEmptyBeds displayEmptyBeds = new DisplayEmptyBeds();
        AssignBed assignBed = new AssignBed();
        ReleasePatient releasePatient = new ReleasePatient();
        DropAssociation dropAssociation = new DropAssociation();

        Command[] commands;
        commands = new Command[]{systemState, addPatient, addDoctor, assignDoctorToPatient, displayEmptyBeds, assignBed, releasePatient, dropAssociation, systemState};

        IOAccess.getInstance().outputString("Initializing the system...");

        while (true) {
            // keep trying until the user enters the data correctly
            try {
                // get the ward information
                IOAccess.getInstance().outputString("Getting Ward information...");
                String ward_name = IOAccess.getInstance().readString("Enter the name of the Ward: ");
                IOAccess.getInstance().outputString("Entered: " + ward_name);
                int firstBedNum = IOAccess.getInstance().readInt("Enter the integer label of the first bed: ");
                IOAccess.getInstance().outputString("Entered: " + firstBedNum);

                int lastBedNum = IOAccess.getInstance().readInt("Enter the integer label of the last bed: ");
                IOAccess.getInstance().outputString("Entered: " + lastBedNum);
                WardAccess.initialize(ward_name, firstBedNum, lastBedNum);
                break;
            } catch (RuntimeException e) {
                IOAccess.getInstance().outputString(e.getMessage());
            }
        }
        IOAccess.getInstance().outputString("\nOptions: ");
        String[] options = new String[] {"\t1: quit"
                ,"\t2: add a new patient"
                ,"\t3: add a new doctor"
                ,"\t4: assign a doctor to a patient"
                ,"\t5: display the empty beds of the ward"
                ,"\t6: assign a patient a bed"
                ,"\t7: release a patient"
                ,"\t8: drop doctor-patient association"
                ,"\t9: display current system state"
                ,"Enter your selection {1-9}: "};
        while (task != 0) {
            try {
                task = IOAccess.getInstance().readChoice(options);

                if(task<0 || task>8){
                    IOAccess.getInstance().outputString("Invalid option, try again.");
                }
                else{
                    commands[task].execute();
                }

            } catch (RuntimeException e) {
                // No matter what  exception is thrown, this catches it
                // Dealing with it means discarding whatever went wrong
                // and starting the loop over.  Easy for the programmer,
                // tedious for the user.
                IOAccess.getInstance().outputString(e.getMessage());
            }
        }
    }
}
