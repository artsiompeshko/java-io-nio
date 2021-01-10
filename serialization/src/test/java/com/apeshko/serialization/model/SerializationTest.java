package com.apeshko.serialization.model;

import java.io.*;

public class SerializationTest implements Serializator {
    public void serialize(Object obj) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("serialization.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("serialization.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object result = objectInputStream.readObject();

        objectInputStream.close();

        return result;
    }
}
