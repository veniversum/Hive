package hive;

import java.util.HashMap;

/**
 * Created by bhan on 2/2/16.
 */
public class JobUniverse {

    //Data structure that maps the name of a job to its instantiation
    private static HashMap<String, Job> nameToJobMap = new HashMap<>();


    //Method to get an job reference by name
    public static Job getJob(String jobName) {
        return nameToJobMap.get(jobName);
    }

    //Method to show an overview of jobs in the universe
    public static void show() {
        System.out.println("Job Name \t\t Ready to Start?");
        for (String s : nameToJobMap.keySet()) {
            System.out.println(s + "\t\t" + getJob(s).ready());
        }
        System.out.println("");
    }


    //Method to create a Job
    public static void makeJob(String jobName, HashMap<String,Integer> inObj, HashMap<String,Integer> outObj) {
        //create object
        Job job = new Job();

        //init name
        job.name = jobName;

        //init input objects
        for (String s : inObj.keySet()) {
            job.edit('i', s, inObj.get(s));
        }
        //init output objects
        for (String s : outObj.keySet()) {
            job.edit('o', s, outObj.get(s));
        }

        //modify Universe records
        nameToJobMap.put(jobName, job);

    }
    

    //Method to destroy a job
    public static void destroyJob(String objName) {
        nameToJobMap.remove(objName);
    }

    //method to do a job
    public static void doJob(String jobName){
        Job job = getJob(jobName);
        //decrease counts of each input obj
        for (String s : job.inObjMap.keySet()) {
            int reqInpObjCount = job.inObjMap.get(s);
            Universe.changeObjPopulation(s,'-',reqInpObjCount);
        }
        for (String t : job.outObjMap.keySet()) {
            int reqOutObjCount = job.outObjMap.get(t);
            Universe.changeObjPopulation(t,'+',reqOutObjCount);
        }

    }

}


