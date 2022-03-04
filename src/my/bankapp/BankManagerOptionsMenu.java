package my.bankapp;

import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;

public class BankManagerOptionsMenu
{
    Customer customer;
    SerializationLoader loader = new SerializationLoader();
    SerializationSaver saver = new SerializationSaver();
    InputExceptionHandler inputHandler = new InputExceptionHandler();
    boolean canContinue = true;

    void approveApplicationsOrCheckCustomerAccount(BankManager employee)
    {
        while (canContinue)
        {
            System.out.println("Welcome, " + employee.getBankManagerFirstName() + "! What would you like to do? Please input a number:" +
                    "\n1. Approve open applications" +
                    "\n2. Check customer account");
            int applicationOrCustomerAccount = InputExceptionHandler.intInput();
            if (applicationOrCustomerAccount == 1)
            {
                // approveOrDenyApplication();
            } else if (applicationOrCustomerAccount == 2)
            {
                System.out.println("Please enter customer's username:");
                Customer customer = checkCustomerAccountIdentifier(InputExceptionHandler.stringInput());
                checkCustomerAccount(customer);
            }
            else
            {
                System.out.println("Invalid. Try again.");
            }
        }
    }

    Customer checkCustomerAccountIdentifier(String customerUsername)
    {
        HashMap<String, Customer> existingCustomers = loader.loadExistingCustomer("customer_applications.ser");
        for (Customer existingCustomer : existingCustomers.values())
            if (customerUsername.equals(existingCustomer.getCustomerUsername()))
                customer = existingCustomer;
        return customer;
    }

    void checkCustomerAccount(Customer customer)
    {
        System.out.println("What would you like to check from " + customer.getPrimaryFirstName()
                + customer.getPrimaryLastName() + "'s account? Type a number to input your choice." +
                "\n1: Check their account information" + // Whether the account is ind or joint, username
                "\n2: Check their account balance" + // Balance amount
                "\n3: Log out");

        int employeeCustomerAccountChoice = InputExceptionHandler.intInput();

        switch (employeeCustomerAccountChoice)
        {


            case 1:

                System.out.println("What account information would you like to access?" +
                        "\n1: User account type: individual or joint" +
                        "\n2: Username" +
                        "\n3: First and last name of user(s)");

                int employeeCustomerInfoChoice = InputExceptionHandler.intInput();

                // Employee checks if the customer has an individual or joint account
                if (employeeCustomerInfoChoice == 1)

                {

                    System.out.println(customer.getPrimaryFirstName() + " " +
                            customer.getPrimaryLastName() + "'s account type is: "
                            + customer.getAccountType());
                }


                // Employee checks what the customer's username is
                else if (employeeCustomerInfoChoice == 2)

                {

                    System.out.println(customer.getPrimaryFirstName() + " " +
                            customer.getPrimaryLastName() + "'s username is: " +
                            customer.getCustomerUsername());
                } else if (employeeCustomerInfoChoice == 3)
                {
                    System.out.println("Primary first name: " + customer.getPrimaryFirstName());
                    System.out.println("Primary last name: " + customer.getPrimaryLastName());
                    if (customer.getAccountType().equals("Joint"))
                    {
                        System.out.println("Secondary first name: " + customer.getSecondaryFirstName());
                        System.out.println("Secondary last name: " + customer.getSecondaryLastName());
                    }
                }
                // Invalid input
                else

                {
                    System.out.println("Invalid input.");


                    try
                    {
                        employeeCustomerInfoChoice = InputExceptionHandler.intInput();
                    } catch (InputMismatchException errorHandler)
                    {
                        System.out.println("Invalid input.");
                    }

                }


            case 2:
                Customer getBalance = new Customer();
                System.out.println("\nThe account balance is: $" + customer.getBalance());


            case 3:
                System.out.println("You will be logged out now.");
                canContinue = false;

            default:
                System.out.println("Invalid entry. Please try again.");
        }
    }
}



