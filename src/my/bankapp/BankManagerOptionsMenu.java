package my.bankapp;

import java.util.InputMismatchException;

public class BankManagerOptionsMenu
{
    Customer customer = new Customer();


    void checkCustomerAccountIdentifier()
    {

        BankManagerOptionsMenu employeeChecksCustomerAccount = new BankManagerOptionsMenu();

        System.out.println("What customer are you looking to check? Please input their username: ");

        customer.setCustomerUsername(InputHandler.stringInput());

        System.out.println("What is the customer's password: ");
        customer.setCustomerPassword(InputHandler.stringInput());


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
                    "\n3: Log out");

            int employeeCustomerAccountChoice = InputHandler.intInput();

            switch (employeeCustomerAccountChoice)
            {


                case 1:

                    System.out.println("What account information would you like to access?" +
                            "\n1: User account type: individual or joint" +
                            "\n2: Username" +
                            "\n3: First and last name of user(s)");

                    int employeeCustomerInfoChoice = InputHandler.intInput();

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

                    else if (employeeCustomerInfoChoice == 3)
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
                        checkCustomerAccount();


                        try
                        {
                            employeeCustomerInfoChoice = InputHandler.intInput();
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
                    System.out.println("You will be logged out now.");

                default:
                    System.out.println("Invalid entry. Please try again.");
                    checkCustomerAccount();

            }
        }
    }



