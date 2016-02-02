package hive;

import java.util.HashMap;

public class Creator {
    public static void main(String[] args) {

        //Create blueprint of objs
        Universe.makeObj("wheel");
        Universe.makeObj("horn");
        Universe.makeObj("windshield");

        //create blueprint of output obj
        Universe.makeObj("car");

        Universe.changeObjPopulation("wheel", 4);
        Universe.changeObjPopulation("horn", 1);
        Universe.changeObjPopulation("windshield", 1);


        //Create blueprint of job
        String jobName = "Make Car";
        HashMap<String,Integer> inputObjects = new HashMap<>();
        HashMap<String,Integer> outputObjects = new HashMap<>();

        inputObjects.put("wheel", 4);
        inputObjects.put("horn", 1);
        inputObjects.put("windshield", 1);

        outputObjects.put("car", 1);

        JobUniverse.makeJob(jobName, inputObjects, outputObjects);
        JobUniverse.show();

        Universe.show();
        JobUniverse.doJob("Make Car");
        Universe.show();

    }
}
