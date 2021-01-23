package com.apeshko.serialization.model;

import java.io.*;

public class SerializationTest implements Serializator {
    public void serialize(Object obj) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("serialization.txt")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(obj);
        }
    }

    public Object deserialize() throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("serialization.txt")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object result = objectInputStream.readObject();

            return result;
        }
    }
}
