package hive;

public interface ObjectInterface {
    //Prints out all the properties of an object, or just one property if name is specified
    void show();

    void show(String name);

    //Modifies property of an object
    void edit(String name, String value);
}
