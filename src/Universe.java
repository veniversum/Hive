import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhan on 1/30/16.
 */
public class Universe{

    //Data structure that maps the name of an object to its instantiation
    static HashMap<String,Object> nameToObjMap = new HashMap<String,Object>();



    //Data structure to map the Name of an Object to the number of Objects there are in the universe
    static HashMap<String,Integer> objectCountMap = new HashMap<String,Integer>();



    //Data structure to map the Name of a Process to its instantiation
    static HashMap<String,Process> titleToProccessMap = new HashMap<String, Process>();




    //Method to show an overview of objects in the universe and their counts
    public static void showAllObjects() {

        System.out.println("All Objects and Counts\n");

        for (String s : objectCountMap.keySet()) {

            System.out.println(s + " : " + objectCountMap.get(s));

        }

        System.out.println();

    }

   //Method to show an overview of processes in the universe and their Flags
    public static void showAllProcesses() {

        System.out.println("Name : \t Startable \t Completed");

        for (String s : titleToProccessMap.keySet()) {

            Process foo = titleToProccessMap.get(s);
            System.out.println(s + " : \t\t" + foo.isStartable() + " \t\t" + foo.isCompleteFlag );

        }

        System.out.println();

    }


    //Method to get an object reference by name
    public static Object getObjByName(String name) {

        return Universe.nameToObjMap.get(name);

    }


    //Method to model the creation of a blueprint for objects. Count of object is set to zero
    public static void creationEffect() {

        //create object
        Object foo = new Object();

        //modify Universe records
        Universe.nameToObjMap.put(foo.properties.get("name"), foo);
        Universe.objectCountMap.put(foo.properties.get("name"), 0);

    }

    //Method to model the change of count of a certain object without dependency on previous value
    public static void populationEffect(String objName, int count) {

        Universe.objectCountMap.put(objName, count);

    }


    //Method to model the change of count of a certain object with dependency on previous value
    public static void populationEffect(String objName, char change, int count) {

        int oldcount = Universe.objectCountMap.get(objName);

        switch(change) {

            case '+': Universe.objectCountMap.put(objName, oldcount + count);
                break;
            case '-': Universe.objectCountMap.put(objName, oldcount - count);
                break;


        }


    }

    //Method to change a property of a given object
    public static void propertyEffect(String objName, String property, String newvalue) {

        Object foo = Universe.getObjByName(objName);
        int count = Universe.objectCountMap.get(objName);

        foo.edit(property, newvalue);

        if(property.equals("name")) {

            //add new reference for new name
            Universe.nameToObjMap.put(newvalue, foo);
            Universe.objectCountMap.put(newvalue, count);

            //delete old reference for old name
            Universe.nameToObjMap.remove(objName);
            Universe.objectCountMap.remove(objName);


        }

    }

    public static void IdeationEffect() {

        //create object
        Process bar = new Process();

        //modify Universe records
        Universe.titleToProccessMap.put(bar.title, bar);

    }


}



