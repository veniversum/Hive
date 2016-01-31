import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by bhan on 1/30/16.
 */
public class Object implements ObjectInterface{

    //Data structure to store name-to-property mappings
    HashMap<String, String> properties = new HashMap<String, String>();

    //Scanner object to read user input
    Scanner sc = new Scanner(System.in);

    //basic properties that all objects must have
    public Object() {

        System.out.println("Initializing Object.");

        //init name
        System.out.println("Enter Name of Object.");
        edit("name", sc.nextLine());

        //Loop to add any more properties
        while(true) {

            System.out.println("Add any more Properties? n to quit");

            if (sc.nextLine().equals("n")) break;

            String propName;
            String value;

            System.out.println("Enter Name of Property of Object.");
            propName = sc.nextLine();

            System.out.println("Enter Value of Property of Object.");
            value = sc.nextLine();

            edit(propName, value);

        }



        //Finalize init
        System.out.println("Initalization Complete.\n");

        show();

    }


    @Override
    public void show() {

        System.out.println("All " + properties.get("name") + " Properties\n");

        for (String s : properties.keySet()) {

            System.out.println(s + " : " + properties.get(s));

        }

        System.out.println();

    }

    @Override
    public void show(String name) {

        System.out.println("<" + name + "> : " + properties.get("name"));

    }


    //Actual implementation of Hashmap edit without the prompts
    @Override
    public void edit(String name, String value) {

        properties.put(name,value);


    }
/*
    @Override
    public void modify() {

        System.out.println("Enter Name of Property to Modify");
        String name = sc.nextLine();
        modify(name);

    }

    @Override
    public void modify(String name) {

        if (properties.containsKey(name)) {

            System.out.println("Enter associated value of the property");
            String value = sc.nextLine();
            edit(name,value);
            System.out.println("Property Modification is a success.");
            System.out.println("Property <" + name + "> now has Value <" + value + ">\n");


        } else {

            System.out.println("Property not found. Would you like to add a new Property with this name? y/n");

            if (sc.nextLine().equals ("y")) {

                System.out.println("Enter Associated Value of the Property");
                String value = sc.nextLine();
                edit(name,value);


                System.out.println("Property Generation is a success.");
                System.out.println("New Property <" + name + "> has Value <" + value + ">\n");

            } else {

                System.out.println("Terminating Modify function\n");

            }

        }

    }
    */
}
