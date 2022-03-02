package my.bankapp;

import java.util.Scanner;

public class MenuOptions
{
    Scanner userInput = new Scanner(System.in);
    CustomerOptionsMenu redirectsToCustomerAccountMenu = new CustomerOptionsMenu();
    EmployeeOptionsMenu employeeChecksCustomerAccount = new EmployeeOptionsMenu();

    // Welcome menu: asks the user if they are an employee or a customer
    // ADD TRY CATCH BLOCK
    void welcomeMenu()
    {
        System.out.println("Welcome to the bank. Are you an employee or a customer?");

        String employeeOrCustomerChoice = userInput.next();


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


        // Invalid entry
        else
        {
            System.out.println("Invalid entry.");
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

        int createOrLogIn = userInput.nextInt();

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

        int createOrLogInEmployee = userInput.nextInt();

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
    void employeeLogin()
    {

        System.out.println("Please input your employee username: ");
        String employeeUsername = userInput.next();

        System.out.println("Please in put your employee password: ");
        String employeePassword = userInput.next();

        // Scans to see if username and password are matches in the hashset
        boolean checker = true;

        while (checker)
        {
            if (checker = true)
            {
                employeeChecksCustomerAccount.checkCustomerAccountIdentifier();
                checker = false;
            }
//            if (employeeUsername.equals(foundEmployeeUsername)
//                    && employeePassword.equals(foundEmployeePassword)) {
//                checker = false;
//                employeeMenu();
            else
            {
                System.out.println("Invalid username or password. Please try again.");
            }
        }


    }



    // Employee create an account menu
    // ADD TRY CATCH BLOCK
    void employeeCreateAnAccount()
    {
        Employee employee = new Employee();

        // Employee username
        System.out.println("Please input your desired username: ");
        employee.setEmployeeUsername(userInput.next());

        // Employee password
        System.out.println("Please input your desired password: ");
        employee.setEmployeePassword(userInput.next());

        // Employee first and last name
        System.out.println("Please input your first name: ");
        employee.setEmployeeFirstName(userInput.next());
        System.out.println("Please input your last name: ");
        employee.setEmployeeLastName(userInput.next());

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
        String customerUsername = userInput.next();

        System.out.println("Please input your password: ");
        String customerPassword = userInput.next();

        // Scans to see if username and password are matches in the hashset
        boolean checker = true;

        while (checker)
        {
            if (checker = true)
            {

                redirectsToCustomerAccountMenu.customerAccountMenu();
                checker = false;
            }
//            if (customerUsername.equals(foundCustomerUsername)
//                    && customerPassword.equals(foundCustomerPassword)) {
//                checker = false;
//                customerMenu();
            else
            {
                System.out.println("Invalid username or password. Please try again.\n");
                customerLogin();
            }
        }
    }



    // Create customer account method
    // ADD TRY CATCH BLOCK
    private void customerCreateAnAccount()
    {
        Customer customer = new Customer();
        System.out.println("Would you like to create a individual or joint account? " +
                "\nPlease type 1 for individual and 2 for joint.");

        int IndOrJoint = userInput.nextInt();


        // Create an individual account
        if (IndOrJoint == 1)
        {
            customer.setAccountType("Individual");

            // Username
            System.out.println("Please enter your username: ");
            customer.setCustomerUsername(userInput.next());

            // Password
            System.out.println("Please enter your password: ");
            customer.setCustomerPassword(userInput.next());

            // First and last name
            System.out.println("Please enter your first name: ");
            customer.setPrimaryFirstName(userInput.next());
            System.out.println("Please enter your last name: ");
            customer.setPrimaryLastName(userInput.next());

            // SSN
            System.out.println("Please enter your social security number: ");
            customer.setPrimarySocialSecurity(userInput.nextInt());

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
            customer.setCustomerUsername(userInput.next());


            // password
            System.out.println("Please create a password for the account: ");
            customer.setCustomerPassword(userInput.next());


            // Primary holder's first and last name

            System.out.println("Please enter the primary account holder's first name: ");
            customer.setPrimaryFirstName(userInput.next());
            System.out.println("Please enter primary account holder's last name: ");
            customer.setPrimaryLastName(userInput.next());

            // Primary's SSN
            System.out.println("Please enter primary account holder's SSN");
            customer.setPrimarySocialSecurity(userInput.nextInt());

            // Secondary holder's first and last name

            System.out.println("Please enter the secondary account holder's first name: ");
            customer.setSecondaryFirstName(userInput.next());
            System.out.println("Please enter the secondary account holder's last name: ");
            customer.setSecondaryLastName(userInput.next());

            // Secondary's SSN
            System.out.println("Please enter the secondary account holder's SSN");
            customer.setSecondarySocialSecurity(userInput.nextInt());

            System.out.println("\nThanks! Your account has been created! You may now log in.\n");

            welcomeMenu();
        }
    }
}