package my.bankapp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class SerializationSaver
{
    public void saveCustomerFile(HashMap<String, Customer> customers, String fileName)
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(customers);
        }
        catch (IOException e)
        {
            System.out.println("No one's around to help: " + e.getMessage());
        }
    }

    public void saveEmployeeFile(HashMap<String, BankManager> employees, String fileName)
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(employees);
        }
        catch (IOException e)
        {
            System.out.println("No one's around to help: " + e.getMessage());
        }
    }

    public void saveTransactionFile(ArrayList<String> transactions, String fileName)
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(transactions);
        }
        catch (IOException e)
        {
            System.out.println("No one's around to help: " + e.getMessage());
        }
    }
}
