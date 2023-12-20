package com.balodza.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeserializationIssueDemo {
    public static final String FILE_NAME = "singleton.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Singleton instance1 = Singleton.getInstance();
        final Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2: " + (instance1 == instance2));

        final Singleton deserialized = getDeserialized(instance1);

        // check Singleton.readResolve() method
        System.out.println("instance1 == deserialized: " + (instance1 == deserialized));
    }

    private static Singleton getDeserialized(Singleton instance1) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(instance1);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Singleton deserialized = (Singleton) objectInputStream.readObject();
        objectInputStream.close();
        return deserialized;
    }
}
