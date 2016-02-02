package hive;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhan on 2/2/16.
 */
public class Job {

    //Job name
    String name;

    //Data structure that links names of input objects to the count required
    HashMap<String,Integer>inObjMap = new HashMap<>();

    //Data structure that links names of output objects to the count required
    HashMap<String,Integer>outObjMap = new HashMap<>();

    //Data structure that stores the description of the Job
    ArrayList<String> jobDescription = new ArrayList<>();

    //Method to show the Jobs input and output objects, as well as description
    public void show() {

        System.out.println("Job " + name + "\n");
        System.out.println("Input Objects");
        System.out.println(inObjMap + "\n");

        System.out.println("Output Objects");
        System.out.println(outObjMap + "\n");



    }

    //Method to change the input and output objects
    public void edit(char a, String objName, int count) {
        switch (a) {
            case 'i': if (count == 0) inObjMap.remove(objName);
                else inObjMap.put(objName, count);
                break;

            case 'o': if (count == 0) outObjMap.remove(objName);
                else outObjMap.put(objName, count);
                break;
        }

    }


    //Method to check if job is startable
    public boolean ready() {
        for (String s : inObjMap.keySet()) {
            //if the count of obj in universe is less than the required number specified, job is not ready
            try {
                if (Universe.objCountMap.get(s) < inObjMap.get(s)) return false;
            } catch (NullPointerException e) {
                return false;
            }
        }

        for (String t : outObjMap.keySet()) {
            //if the blueprints of output obj are not created, job is not ready
            if (Universe.objCountMap.get(t) == null) return false;
        }

        return true;
    }

}
