package hive;

import hive.effects.EffectInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class Process implements ProcessInterface {
    String title;

    boolean isStartableFlag;
    boolean isCompleteFlag;

    //Data structure to store the Requisite Processes that must be complete in order to carry out this Process
    ArrayList<String> reqProcesses = new ArrayList<>();

    //Data structure to store the steps to be taken in this Process
    ArrayList<String> procedures = new ArrayList<String>();

    //Data structure to store the abstract outcome of what this Process should accomplish
    ArrayList<String> goals = new ArrayList<String>();

    //Data structure to store the effects that this Process will have on the "Object universe"
    ArrayList<EffectInterface> effects = new ArrayList<EffectInterface>();

    //Scanner object to read user input
    Scanner sc = new Scanner(System.in);

    public Process() {

        //Init process title
        System.out.println("Initializing Process.");
        System.out.println("Enter Title of Process");

        title = sc.nextLine();

        //Loop to init required processes
        while (true) {
            System.out.println("Add Requisite Processes? n to quit");
            if (sc.nextLine().equals("n"))
                break;
            else {
                System.out.println("Enter Name of Requisite Process.");
                String reqProcessName = sc.nextLine();
                if (Universe.titleToProccessMap.containsKey(reqProcessName)) {
                    reqProcesses.add(reqProcessName);
                } else {
                    System.out.println("Process not found! Nothing done.");
                }
            }
        }

        //Loop to init procedure
        while (true) {
            System.out.println("Add Procedure? n to quit");
            if (sc.nextLine().equals("n")) break;
            System.out.println("Enter Procedure Description.");
            String procedureLine = sc.nextLine();
            procedures.add(procedureLine);
        }

        //Loop to init goals
        while (true) {
            System.out.println("Add Goal? n to quit");
            if (sc.nextLine().equals("n")) break;
            System.out.println("Enter Goal Description.");
            String goalLine = sc.nextLine();
            goals.add(goalLine);
        }

        //TODO Loop to add effects
    }

    //Method to print the information of this specific Process
    @Override
    public void show() {
        System.out.println("All " + title + " Properties\n");

        System.out.println("Required Processes");
        System.out.println(reqProcesses + "\n");

        System.out.println("Procedures");
        System.out.println(procedures + "\n");

        System.out.println("Goals");
        System.out.println(goals + "\n");
    }

    @Override
    public boolean isStartable() {
        for (String s : reqProcesses) {
            if (!Universe.titleToProccessMap.get(s).isCompleteFlag) return false;
        }
        isStartableFlag = true;
        return true;
    }

    @Override
    public boolean isComplete() {
        return isCompleteFlag;
    }

    public void setCompleteFlag(boolean completeFlag) {
        isCompleteFlag = completeFlag;
    }

    @Override
    public void modifyReqProcess() {}

    @Override
    public void modifyProcedure() {}

    @Override
    public void modifyGoals() {}

    @Override
    public void modifySideEffects() {}
}
