package hive;

public interface ProcessInterface {
    //Show hive.Process information
    void show();

    //Method to check that hive.Process can be initiated
    boolean isStartable();

    //Method to check that hive.Process is complete
    boolean isComplete();

    //Method to modify the ArrayList of required Complete Processes
    void modifyReqProcess();

    //Method to modify the Procedure of the hive.Process
    void modifyProcedure();

    //Method to modify the goals of the hive.Process
    void modifyGoals();

    //Method to modify the hive.effects of this process on the "hive.Object universe"
    void modifySideEffects();
}
