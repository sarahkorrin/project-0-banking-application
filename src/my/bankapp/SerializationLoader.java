package my.bankapp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SerializationLoader
{
    private HashMap<String, Customer> existingCustomers;    // Hashmap for serializing customers
    private HashMap<String, BankManager> existingBankManagers;  // Hashmap for serializing bank manager
    private ArrayList<String> transactionHistory;   // ArrayList for serializing transaction history

    public HashMap<String, Customer> loadExistingCustomers(String fileName)  // Method that loads customer serialization
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(fileName); // Creates the fileIn object for file reading
            ObjectInputStream objIn = new ObjectInputStream(fileIn); // Creates the objIn object that takes in the fileIn value and rebuilds it in the Hashmap
            existingCustomers = (HashMap<String, Customer>) objIn.readObject(); // Creates Hashmap for existing customers
            fileIn.close(); // Closes the streams
            objIn.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            if (existingCustomers == null)   // If no user has registered yet, it creates a new HashMap to avoid errors
                existingCustomers = new HashMap<>();
        }
        return existingCustomers;
    }

    public HashMap<String, BankManager> loadExistingBankManagers(String fileName)  // Method that loads bank manager serialization
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(fileName); // Creates the fileIn object for file reading
            ObjectInputStream objIn = new ObjectInputStream(fileIn);  // Creates the objIn object that takes in the fileIn value and rebuilds it in the Hashmap
            existingBankManagers = (HashMap<String, BankManager>) objIn.readObject();  // Creates Hashmap for existing bank managers
            fileIn.close(); // Closes the streams
            objIn.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            if (existingBankManagers == null)  // If no bank manager has registered yet, it creates a new HashMap to avoid errors
                existingBankManagers = new HashMap<>();
        }
        return existingBankManagers;
    }

    public ArrayList<String> loadTransactions()  // Method that loads transaction history
    {
        try
        {
            FileInputStream fileIn = new FileInputStream("transactions_log.ser"); // Creates the fileIn object for file reading
            ObjectInputStream objIn = new ObjectInputStream(fileIn);  // Creates the objIn object that takes in the fileIn value and rebuilds it in the Hashmap
            transactionHistory = (ArrayList<String>) objIn.readObject();  // Creates an ArrayList for transaction history
            fileIn.close();
            objIn.close();
        } catch (IOException | ClassNotFoundException e)
        {
            if (transactionHistory == null)  // If no transaction history exists, it creates a new ArrayList to avoid errors
                transactionHistory = new ArrayList<String>();
        }
        return transactionHistory;
    }
}

// Need 1 implementation for applications
// Need 1 hashmap for customers
// Need 1 hashmap for bank managers
