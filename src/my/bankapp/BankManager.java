package my.bankapp;

import java.io.Serializable;

public class BankManager implements Serializable {
    /**
     * Defined employee variables
     */
    private String bankManagerUsername;
    private String bankManagerPassword;
    private String bankManagerFirstName;
    private String bankManagerLastName;
    private String bankManagerAccountType;

    // Employee variable getters and setters

    public String getBankManagerUsername()
    {
        return bankManagerUsername;
    }

    public void setBankManagerUsername(String bankManagerUsername)
    {
        this.bankManagerUsername = bankManagerUsername;
    }

    public String getBankManagerPassword()
    {
        return bankManagerPassword;
    }

    public void setBankManagerPassword(String bankManagerPassword)
    {
        this.bankManagerPassword = bankManagerPassword;
    }

    public String getBankManagerFirstName()
    {
        return bankManagerFirstName;
    }

    public void setBankManagerFirstName(String bankManagerFirstName)
    {
        this.bankManagerFirstName = bankManagerFirstName;
    }

    public String getBankManagerLastName()
    {
        return bankManagerLastName;
    }

    public void setBankManagerLastName(String bankManagerLastName)
    {
        this.bankManagerLastName = bankManagerLastName;
    }
}