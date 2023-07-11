package com.just.code.dsalgo.common.serialize;

import java.io.*;

public class ObjectSerializer {
    private static final String filename = "./file.ser";

    public static void writeObject(Object object) {

        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("IOException is caught");
        }
    }

    public static <T> T readObject(T t) {
        T object1 = null;

        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (T) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            return t;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("ClassNotFoundException is caught");
        }
        return object1;
    }

}
