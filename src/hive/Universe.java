package hive;

import java.util.HashMap;

public class Universe {


    //Data structure that maps the name of an object to its instantiation
    static HashMap<String, Object> nameToObjMap = new HashMap<>();


    //Data structure to map the Name of an Object to the number of Objects there are in the universe
    static HashMap<String, Integer> objCountMap = new HashMap<>();


    //Method to show an overview of objects in the universe and their counts
    public static void show() {
        System.out.println("All Objects and Counts\n");

        for (String s : objCountMap.keySet()) {
            System.out.println(s + " : " + objCountMap.get(s));
        }

        System.out.println();
    }


    //Method to get an object reference by name
    public static Object getObj(String objName) {
        return nameToObjMap.get(objName);
    }

    //Method to model the creation of a blueprint for property-less objects. Count of object is set to zero
    public static void makeObj(String objName) {
        //create object
        Object obj = new Object();

        //init name
        obj.edit("name", objName);

        //modify Universe records
        nameToObjMap.put(obj.properties.get("name"), obj);
        objCountMap.put(obj.properties.get("name"), 0);
    }


    //Method to model the creation of a blueprint for objects. Count of object is set to zero
    public static void makeObj(String objName, HashMap<String,String> properties) {
        //create object
        Object obj = new Object();

        //init name
        obj.edit("name", objName);

        //init properties of object
        obj.edit(properties);

        //modify Universe records
        nameToObjMap.put(obj.properties.get("name"), obj);
        objCountMap.put(obj.properties.get("name"), 0);
    }

    //Method to model the change of count of a certain object without dependency on previous value
    public static void changeObjPopulation(String objName, int count) {
        objCountMap.put(objName, count);
    }


    //Method to model the change of count of a certain object with dependency on previous value
    public static void changeObjPopulation(String objName, char change, int count) {
        int oldcount = objCountMap.get(objName);

        switch (change) {
            case '+':
                objCountMap.put(objName, oldcount + count);
                break;
            case '-':
                objCountMap.put(objName, oldcount - count);
                break;
        }
    }

    //Method to change a property of a given object
    public static void changeObjProperty(String objName, String property, String newvalue) {
        Object obj = getObj(objName);
        int count = objCountMap.get(objName);

        obj.edit(property, newvalue);

        if (property.equals("name")) {
            //add new reference for new name
            nameToObjMap.put(newvalue, obj);
            objCountMap.put(newvalue, count);

            //delete old reference for old name
            nameToObjMap.remove(objName);
            objCountMap.remove(objName);
        }
    }

    //Method to destroy an object
    public static void destroyObj(String objName) {
        nameToObjMap.remove(objName);
        objCountMap.remove(objName);
    }

}



