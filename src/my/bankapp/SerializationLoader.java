package my.bankapp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SerializationLoader
{
    HashMap<String, Customer> existingCustomers;
    HashMap<String, BankManager> existingBankManagers;
    ArrayList<String> transactionHistory;

    private HashMap<String, Customer> loadExistingCustomer(String fileName)
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            existingCustomers = (HashMap<String, Customer>) objIn.readObject();
            fileIn.close();
            objIn.close();
        } catch (IOException | ClassNotFoundException e)
        {
            if (existingCustomers == null)
                existingCustomers = new HashMap<>();
        }
        return existingCustomers;
    }

    private HashMap<String, BankManager> loadExistingBankManagers()
    {
        try
        {
            FileInputStream fileIn = new FileInputStream("existing_employees.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            existingBankManagers = (HashMap<String, BankManager>) objIn.readObject();
            fileIn.close();
            objIn.close();
        } catch (IOException | ClassNotFoundException e)
        {
            if (existingBankManagers == null)
                existingBankManagers = new HashMap<>();
        }
        return existingBankManagers;
    }

    private ArrayList<String> loadTransactions()
    {
        try
        {
            FileInputStream fileIn = new FileInputStream("transactions_log.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            transactionHistory = (ArrayList<String>) objIn.readObject();
            fileIn.close();
            objIn.close();
        } catch (IOException | ClassNotFoundException e)
        {
            if (transactionHistory == null)
                transactionHistory = new ArrayList<String>();
        }
        return transactionHistory;
    }
}

// Need 1 implementation for applications
// Need 1 hashmap for customers
// Need 1 hashmap for bank managers
