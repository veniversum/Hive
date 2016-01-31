/**
 * Created by bhan on 1/30/16.
 */
public interface ProcessInterface {

    //Show Process information
    void show();

    //Method to check that Process can be initiated
    boolean isStartable();

    //Method to check that Process is complete
    boolean isComplete();

    //Method to modify the ArrayList of required Complete Processes
    void modifyReqProcess();

    //Method to modify the Procedure of the Process
    void modifyProcedure();

    //Method to modify the goals of the Process
    void modifyGoals();

    //Method to modify the effects of this process on the "Object universe"
    void modifySideEffects();



}
