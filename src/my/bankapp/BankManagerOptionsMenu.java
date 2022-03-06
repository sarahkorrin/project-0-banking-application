package my.bankapp;

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
            int applicationOrCustomerAccount = InputExceptionHandler.nextInt();
            if (applicationOrCustomerAccount == 1)
            {
                // approveOrDenyApplication();
            } else if (applicationOrCustomerAccount == 2)
            {
                System.out.println("Please enter customer's username:");
                Customer customer = checkCustomerAccountIdentifier(InputExceptionHandler.nextString());
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
        HashMap<String, Customer> existingCustomers = loader.loadExistingCustomers("customer_applications.ser");
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

        int employeeCustomerAccountChoice = InputExceptionHandler.nextInt();

        switch (employeeCustomerAccountChoice)
        {


            case 1:

                System.out.println("What account information would you like to access?" +
                        "\n1: Account information" +
                        "\n2: Check balance");

                int employeeCustomerInfoChoice = InputExceptionHandler.nextInt();

                // Employee checks if the customer has an individual or joint account
                if (employeeCustomerInfoChoice == 1)

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
                        employeeCustomerInfoChoice = InputExceptionHandler.nextInt();
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



