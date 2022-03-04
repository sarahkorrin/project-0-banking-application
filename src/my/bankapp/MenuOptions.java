package my.bankapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class MenuOptions
{
    CustomerOptionsMenu redirectsToCustomerAccountMenu = new CustomerOptionsMenu();
    BankManagerOptionsMenu employeeChecksCustomerAccount = new BankManagerOptionsMenu();
    SerializationLoader loader = new SerializationLoader();
    SerializationSaver saver = new SerializationSaver();

    // Welcome menu: asks the user if they are an employee or a customer
    // ADD TRY CATCH BLOCK
    void welcomeMenu()
    {
        System.out.println("Welcome to the bank. Are you an employee or a customer?");
        System.out.println("(TESTING FEATURE) Type 'delete' to remove all accounts and transactions.");

        String employeeOrCustomerChoice = InputExceptionHandler.stringInput();


        // User inputs that they are an employee
        if (employeeOrCustomerChoice.toLowerCase().equals("employee"))
        {
            newOrExistingEmployeeAccount();
        }


        // User inputs that they are a customer
        else if (employeeOrCustomerChoice.toLowerCase().equals("customer"))
        {
            newOrExistingCustomerAccount();
        }

        // TESTING FEATURE. REMOVE AT END!
        else if (employeeOrCustomerChoice.equals("delete")) {
            try
            {
                FileOutputStream customerApplications = new FileOutputStream("customer_applications.ser");
                FileOutputStream customerAccounts = new FileOutputStream("existing_customers.ser");
                FileOutputStream employeeAccounts = new FileOutputStream("existing_employees.ser");
                FileOutputStream transactions = new FileOutputStream("transactions_log.ser");
                customerApplications.flush();
                customerAccounts.flush();
                employeeAccounts.flush();
                transactions.flush();
                System.out.println("All accounts and transactions have been deleted.");
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }


        // Invalid entry
        else
        {
            System.out.println("Invalid entry.");
            welcomeMenu();
        }
    }


    // Asks if they are a new or existing customer
    // ADD TRY CATCH BLOCK
    private void newOrExistingCustomerAccount()
    {
        System.out.println("Would you like to create an account or log in? " +
                "Please input a number for your choice" +
                "\n1. Create an account" +
                "\n2. Login");

        int createOrLogIn = InputExceptionHandler.intInput();

        // Calls the create a customer account method
        if (createOrLogIn == 1)
        {
            customerCreateAnAccount();

        }

        // Calls the customer login method
        else if (createOrLogIn == 2)
        {
            customerLogin();
        }

        // Invalid entry
        else
        {
            System.out.println("Invalid entry.");
        }

    }


    // Asks if they are a new or existing employee
    // ADD TRY CATCH BLOCK
    private void newOrExistingEmployeeAccount()
    {
        System.out.println("Would you like to create an account or log in? " +
                "Please input a number for your choice" +
                "\n1. Create an account" +
                "\n2. Login");

        int createOrLogInEmployee = InputExceptionHandler.intInput();

        // Calls the create an employee account method
        if (createOrLogInEmployee == 1)
        {
            employeeCreateAnAccount();
        }


        // Calls the employee login method
        else if (createOrLogInEmployee == 2)
        {
            employeeLogin();
        }


        // Invalid input
        else
        {
            System.out.println("Invalid entry.");
        }
    }


    // Employee Login method
    // ADD TRY CATCH BLOCK
    private BankManager employeeLogin()
    {
        BankManager employee = null;
        HashMap<String, BankManager> existingBankManagers = loader.loadExistingBankManagers("existing_employees.ser");
        if (existingBankManagers.isEmpty())
        {
            System.out.println("There are no employees.");
            welcomeMenu();
        } else
        {
            System.out.println("Please input your employee username: ");
            String attemptedEmployeeUsername = InputExceptionHandler.stringInput();

            System.out.println("Please in put your employee password: ");
            String attemptedEmployeePassword = InputExceptionHandler.stringInput();


            for (BankManager existingBankManager : existingBankManagers.values())
                if (existingBankManager.getBankManagerUsername().equals(attemptedEmployeeUsername))
                {
                    if (existingBankManager.getBankManagerPassword().equals(attemptedEmployeePassword))
                    {
                        System.out.println("Login successful!");
                        employee = existingBankManager;
                        employeeChecksCustomerAccount.approveApplicationsOrCheckCustomerAccount(employee);
                    } else
                    {
                        System.out.println("Sorry, your username or password is invalid.");
                        welcomeMenu();
                    }
                }
        }
        return employee;
    }


    // Employee create an account menu
    // ADD TRY CATCH BLOCK
    void employeeCreateAnAccount()
    {
        BankManager employee = new BankManager();

        // Employee username
        System.out.println("Please input your desired username: ");
        employee.setBankManagerUsername(InputExceptionHandler.stringInput());

        // Employee password
        System.out.println("Please input your desired password: ");
        employee.setBankManagerPassword(InputExceptionHandler.stringInput());

        // Employee first and last name
        System.out.println("Please input your first name: ");
        employee.setBankManagerFirstName(InputExceptionHandler.stringInput());
        System.out.println("Please input your last name: ");
        employee.setBankManagerLastName(InputExceptionHandler.stringInput());

        HashMap<String, BankManager> existingBankManagers = loader.loadExistingBankManagers("existing_employees.ser");
        existingBankManagers.put(employee.getBankManagerUsername(), employee);
        saver.saveEmployeeFile(existingBankManagers, "existing_employees.ser");

        System.out.println("\nThanks! Your account has been created. You may now log in." +
                "\n");
        // Do they need an employee ID# and address?

        welcomeMenu();

    }


    // Customer Login Method
    // ADD TRY CATCH BLOCK
    void customerLogin()
    {
        System.out.println("Please input your username: ");
        String attemptedUsername = InputExceptionHandler.stringInput();

        System.out.println("Please input your password: ");
        String attemptedPassword = InputExceptionHandler.stringInput();

        HashMap<String, Customer> existingCustomers = loader.loadExistingCustomer("customer_applications.ser");
        for (Customer existingCustomer : existingCustomers.values())
            if (existingCustomer.getCustomerUsername().equals(attemptedUsername))
                if (existingCustomer.getCustomerPassword().equals(attemptedPassword))
                {
                    System.out.println("Login successful!");
                    redirectsToCustomerAccountMenu.customerAccountMenu();
                } else
                {
                    System.out.println("Sorry, your username or password is invalid.");
                    welcomeMenu();
                }
    }


    // Create customer account method
    // ADD TRY CATCH BLOCK
    private void customerCreateAnAccount()
    {
        Customer customer = new Customer();
        System.out.println("Would you like to create a individual or joint account? " +
                "\nPlease type 1 for individual and 2 for joint.");

        int IndOrJoint = InputExceptionHandler.intInput();

        // Create an individual account
        if (IndOrJoint == 1)
        {
            customer.setAccountType("Individual");

            // Username
            System.out.println("Please enter your username: ");
            customer.setCustomerUsername(InputExceptionHandler.stringInput());

            // Password
            System.out.println("Please enter your password: ");
            customer.setCustomerPassword(InputExceptionHandler.stringInput());

            // First and last name
            System.out.println("Please enter your first name: ");
            customer.setPrimaryFirstName(InputExceptionHandler.stringInput());
            System.out.println("Please enter your last name: ");
            customer.setPrimaryLastName(InputExceptionHandler.stringInput());

            HashMap<String, Customer> existingCustomers = loader.loadExistingCustomer("customer_applications.ser");
            existingCustomers.put(customer.getCustomerUsername(), customer);
            saver.saveCustomerFile(existingCustomers, "customer_applications.ser");

            System.out.println("\nThanks! Your account has been created! You may now log in.\n");

            welcomeMenu();
        }


        // Create a joint account
        // ADD TRY CATCH BLOCK
        else if (IndOrJoint == 2)
        {
            customer.setAccountType("Joint");

            // username
            System.out.println("Please create a username for the account: ");
            customer.setCustomerUsername(InputExceptionHandler.stringInput());


            // password
            System.out.println("Please create a password for the account: ");
            customer.setCustomerPassword(InputExceptionHandler.stringInput());


            // Primary holder's first and last name

            System.out.println("Please enter the primary account holder's first name: ");
            customer.setPrimaryFirstName(InputExceptionHandler.stringInput());
            System.out.println("Please enter primary account holder's last name: ");
            customer.setPrimaryLastName(InputExceptionHandler.stringInput());

            // Secondary holder's first and last name

            System.out.println("Please enter the secondary account holder's first name: ");
            customer.setSecondaryFirstName(InputExceptionHandler.stringInput());
            System.out.println("Please enter the secondary account holder's last name: ");
            customer.setSecondaryLastName(InputExceptionHandler.stringInput());

            System.out.println("\nThanks! Your account has been created! You may now log in.\n");

            welcomeMenu();
        }
    }
}