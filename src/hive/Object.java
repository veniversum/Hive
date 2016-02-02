package hive;

import java.util.HashMap;
import java.util.Scanner;

public class  Object implements ObjectInterface {
    //Data structure to store name-to-property mappings
    HashMap<String, String> properties = new HashMap<String, String>();

    //Print out all of an objects properties
    @Override
    public void show() {
        System.out.println("All " + properties.get("name") + " Properties\n");
        for (String s : properties.keySet()) {

            if (s.equals("name")) continue;
            System.out.println(s + " : " + properties.get(s));
        }
        System.out.println();
    }

    //print out a specific property of object
    @Override
    public void show(String name) {
        System.out.println("<" + name + "> : " + properties.get("name"));
    }

    //edits a specific property of object
    @Override
    public void edit(String name, String value) {
        if (value == null) properties.remove(name);
        else properties.put(name, value);
    }

    //multiple edits
    public void edit(HashMap<String, String> propertyMap) {
        for (String s : propertyMap.keySet()) {
            edit(s, propertyMap.get(s));
        }
    }

}
