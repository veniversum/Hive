package hive;

public interface ObjectInterface {

    //Prints out all the properties of an object, or just one property if name is specified
    void show();

    void show(String name);

    //modifies an object property. If no input, user is prompted for name of property. Use this to alter any properties
    //void modify();
    //void modify(String name);

    //Actual modifying function without prompts
    void edit(String name, String value);


}
