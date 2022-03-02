package my.bankapp;

import java.io.Serializable;

public class Employee implements Serializable {
    /**
     * Defined employee variables
     */
    private String employeeUsername;
    private String employeePassword;
    private String employeeFirstName;
    private String employeeLastName;
    private int employeeIDNumber;
    private String employeeAddress;

    // Employee variable getters and setters

    public String getEmployeeUsername()
    {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername)
    {
        this.employeeUsername = employeeUsername;
    }

    public String getEmployeePassword()
    {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword)
    {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeFirstName()
    {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName)
    {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName()
    {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName)
    {
        this.employeeLastName = employeeLastName;
    }

    public int getEmployeeIDNumber()
    {
        return employeeIDNumber;
    }

    public void setEmployeeIDNumber(int employeeIDNumber)
    {
        this.employeeIDNumber = employeeIDNumber;
    }

    public String getEmployeeAddress()
    {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress)
    {
        this.employeeAddress = employeeAddress;
    }
}