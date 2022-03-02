package my.bankapp;

import java.io.*;
import java.util.HashSet;

public class SerializationTest
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream loader = new FileInputStream("customerInfoSerialization.ser");
        ObjectInputStream infoInputReader = new ObjectInputStream(loader);

        HashSet<Object> importantInfo = (HashSet<Object>) infoInputReader.readObject();

        System.out.println(importantInfo);
    }
}
