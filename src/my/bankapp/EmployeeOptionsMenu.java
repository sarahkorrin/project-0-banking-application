package my.bankapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeOptionsMenu
{
    Customer customer = new Customer();
    Scanner employeeInput = new Scanner(System.in);

    void checkCustomerAccountIdentifier()
    {

        EmployeeOptionsMenu employeeChecksCustomerAccount = new EmployeeOptionsMenu();

        System.out.println("What customer are you looking to check? Please input their username: ");

        customer.setCustomerUsername(employeeInput.nextLine());

        System.out.println("What is the customer's password: ");
        customer.setCustomerPassword(employeeInput.nextLine());


        // Scans to see if username and password are matches in the hashset
        boolean customerIDChecker = true;

        while (customerIDChecker)
        {


            if (customerIDChecker = true)
            {
                // employeeChecksCustomerAccount.checkCustomerAccount();
                checkCustomerAccount();
                customerIDChecker = false;

//            if (employeeUsername.equals(foundEmployeeUsername)
//                    && employeePassword.equals(foundEmployeePassword)) {
//                checker = false;
//                employeeMenu();
            } else
            {
                System.out.println("Invalid customer name. Please try again.\n");
                checkCustomerAccountIdentifier();
            }
        }
    }
        void checkCustomerAccount()
        {

            System.out.println("What would you like to check from " + customer.getPrimaryFirstName()
                    + customer.getPrimaryLastName() + "'s account? Type a number to input your choice." +
                    "\n1: Check their account information" + // Whether the account is ind or joint, username
                    "\n2: Check their account balance" + // Balance amount
                    "\n3: Check their personal information" +  // Name, address
                    "\n4: Log out");

            int employeeCustomerAccountChoice = employeeInput.nextInt();

            switch (employeeCustomerAccountChoice)
            {


                case 1:

                    System.out.println("What account information would you like to access?" +
                            "\n1: User account type: individual or joint" +
                            "\n2: Username");

                    int employeeCustomerInfoChoice = employeeInput.nextInt();

                    // Employee checks if the customer has an individual or joint account
                    if (employeeCustomerInfoChoice == 1)

                    {

                        System.out.println(customer.getPrimaryFirstName() + " " +
                                customer.getPrimaryLastName() + "'s account type is: "
                                + customer.getAccountType());
                        checkCustomerAccount();
                    }


                    // Employee checks what the customer's username is
                    else if (employeeCustomerInfoChoice == 2)

                    {

                        System.out.println(customer.getPrimaryFirstName() + " " +
                                customer.getPrimaryLastName() + "'s username is: " +
                                customer.getCustomerUsername());
                        checkCustomerAccount();
                    }

                    // Invalid input
                    else

                    {

                        System.out.println("Invalid input.");
                        checkCustomerAccount();


                        try
                        {
                            employeeCustomerInfoChoice = employeeInput.nextInt();
                        } catch (InputMismatchException errorHandler)
                        {
                            System.out.println("Invalid input.");
                            checkCustomerAccount();
                        }

                    }


                case 2:
                    Customer getBalance = new Customer();
                    System.out.println("\nThe account balance is: $" + customer.getBalance());

                case 3:
                    System.out.println("What personal information would you like to access? " +
                            "Type a number for the following choice" +
                            "\n1. Name" +
                            "\n2. Address");

                    int nameOrAddress = employeeInput.nextInt();

                    if (nameOrAddress == 1)
                    {
                        System.out.println("The primary account holder is: " +
                                customer.getPrimaryFirstName() + customer.getPrimaryLastName());
                                checkCustomerAccount();
                    }

                    else if (nameOrAddress == 2)
                    {
                        System.out.println("Address: " +
                            customer.getCustomerAddress());
                            checkCustomerAccount();
                    }

                    else
                    {
                        System.out.println("Invalid entry. Please try again.");
                        checkCustomerAccount();
                    }

                case 4:
                    System.out.println("You will be logged out now.");

                default:
                    System.out.println("Invalid entry. Please try again.");
                    checkCustomerAccount();

            }
        }
    }



