package my.bankapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    /**
     * Defined customer variables
     */
    private String customerUsername;
    private String customerPassword;

    private String primaryFirstName;
    private String secondaryFirstName;

    private String primaryLastName;
    private String secondaryLastName;

    private String accountType;

    private double balance = 0;

    public ArrayList<String> transactions = new ArrayList<>();

    public String getCustomerUsername()
    {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername)
    {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword()
    {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword)
    {
        this.customerPassword = customerPassword;
    }

    public String getPrimaryFirstName()
    {
        return primaryFirstName;
    }

    public void setPrimaryFirstName(String primaryFirstName)
    {
        this.primaryFirstName = primaryFirstName;
    }

    public String getSecondaryFirstName()
    {
        return secondaryFirstName;
    }

    public void setSecondaryFirstName(String secondaryFirstName)
    {
        this.secondaryFirstName = secondaryFirstName;
    }

    public String getPrimaryLastName()
    {
        return primaryLastName;
    }

    public void setPrimaryLastName(String primaryLastName)
    {
        this.primaryLastName = primaryLastName;
    }

    public String getSecondaryLastName()
    {
        return secondaryLastName;
    }

    public void setSecondaryLastName(String secondaryLastName)
    {
        this.secondaryLastName = secondaryLastName;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}


