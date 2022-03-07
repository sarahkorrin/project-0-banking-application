package my.bankapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.concurrent.ConcurrentHashMap;

public class BankManagerOptionsMenu
{
    Customer customer;
    SerializationLoader loader = new SerializationLoader();
    SerializationSaver saver = new SerializationSaver();
    InputExceptionHandler inputHandler = new InputExceptionHandler();
    boolean canContinue = true;
    BankManager bankManager = new BankManager();

    void approveApplicationsOrCheckCustomerAccount(BankManager employee)
    {
        while (canContinue)
        {
            System.out.println("Welcome, " + employee.getBankManagerFirstName() +
                    "! What would you like to do? Please input a number: " +
                    "\n1. Approve open applications" +
                    "\n2. Check customer account" +
                    "\n3. View Transactions Log" +
                    "\n4. Log out");

            int applicationOrCustomerAccount = InputExceptionHandler.nextInt();

            if (applicationOrCustomerAccount == 1)
            {
               approveOrDenyApplication();
            }
            else if (applicationOrCustomerAccount == 2)
            {
                System.out.println("Please enter customer's username:");
                Customer customer = checkCustomerAccountIdentifier(InputExceptionHandler.nextString());
                try
                {
                    checkCustomerAccount(customer);
                } catch (NullPointerException e)
                {
                    System.out.println("Sorry, that customer does not exist.\n");
                }

            }
            else if (applicationOrCustomerAccount == 3)
            {
                ArrayList<String> transactionsLog = loader.loadTransactions();
                System.out.println("\n--------------------------------------------------");
                for (String transaction : transactionsLog)
                {
                    if (transactionsLog.isEmpty() || transactionsLog == null)
                    {
                        System.out.println("There are no transactions.");
                    }
                    else
                    {
                        System.out.println(transaction);
                    }
                }
                System.out.println("--------------------------------------------------\n");
            }
            else if (applicationOrCustomerAccount == 4)
            {
                System.out.println("You will now be logged out.");
                System.exit(0);
            }

            else
            {
                System.out.println("Invalid. Try again.\n");
            }
        }
    }

    Customer checkCustomerAccountIdentifier(String customerUsername)
    {
        HashMap<String, Customer> existingCustomers = loader.loadExistingCustomers
                ("existing_customers.ser");
        for (Customer existingCustomer : existingCustomers.values())
            if (customerUsername.equals(existingCustomer.getCustomerUsername()))
                customer = existingCustomer;
        return customer;
    }

    void checkCustomerAccount(Customer customer)
    {
        System.out.println("\nWhat would you like to check from " + customer.getPrimaryFirstName() + " "
                + customer.getPrimaryLastName() + "'s account? Type a number to input your choice." +
                "\n1: Check their account information" + // Whether the account is ind or joint, username
                "\n2: Check their account balance" + // Balance amount
//                "\n3: View their transaction history" +
                "\n3: Log out");

        int employeeCustomerAccountChoice = InputExceptionHandler.nextInt();

        switch (employeeCustomerAccountChoice)
        {

            case 1:


                if (employeeCustomerAccountChoice == 1)
                {
                    System.out.println("\nUser's account type: " + customer.getAccountType());
                    System.out.println("The username of this account is: " + customer.getCustomerUsername());
                    System.out.println("Primary account holder's first and last name is: "
                            + customer.getPrimaryFirstName() + " " + customer.getPrimaryLastName());
                    if (customer.getAccountType().equals("Joint"))
                    {
                        System.out.println("Secondary account holder's first and last name is: "
                                + customer.getSecondaryFirstName() + " " + customer.getSecondaryLastName());
                    }
                    checkCustomerAccount(customer);
                }
                // Invalid input
                else

                {
                    System.out.println("Invalid input.");
                    checkCustomerAccount(customer);


                    try
                    {
                        employeeCustomerAccountChoice = InputExceptionHandler.nextInt();
                    } catch (InputMismatchException errorHandler)
                    {
                        System.out.println("Invalid input.");
                        checkCustomerAccount(customer);
                    }

                }


            case 2:
                Customer getBalance = new Customer();
                System.out.println("\nThe account balance is: $" + customer.getBalance());
                checkCustomerAccount(customer);
                break;

//            case 3:
//
//                if (customer has a transaction history)
//            {
//                System.out.println("The account transaction history is as follows: ");
//                prints out table of transaction history
//                checkCustomerAccount(customer);
//            }
//                else
//            {
//                System.out.println("This account has no transaction history.");
//                checkCustomerAccount(customer);
//            }

            case 3:
                System.out.println("You will be logged out now.");
                canContinue = false;
                System.exit(0);

            default:
                System.out.println("Invalid entry. Please try again.");
                checkCustomerAccount(customer);
                break;
        }
    }

    void approveOrDenyApplication() // Approve or deny applications by bank managers method
    {
        HashMap<String, Customer> openApplications = loader.loadExistingCustomers("customer_applications.ser");
        if(openApplications.isEmpty() || openApplications == null)
        {
            System.out.println("There are no open applications at this time.\n");
        }
        else
        {
            System.out.println("\nHere is the list of open applications: ");
            for (Customer customerApplication : openApplications.values())
            {
                System.out.println("-------------------------" +
                        "\nUsername: " + customerApplication.getCustomerUsername() +
                        "\nAccount Type: " + customerApplication.getAccountType() +
                        "\nPrimary Full Name: " + customerApplication.getPrimaryFirstName() +
                        " " + customerApplication.getPrimaryLastName());
                if (customerApplication.getAccountType().equals("Joint"))
                {
                    System.out.println("Secondary Full Name: " + customerApplication.getSecondaryFirstName() +
                            " " + customerApplication.getSecondaryLastName());
                }
                System.out.println("-------------------------\n");
            }
            System.out.println("\nWhich application would you like to address? Please input their username: ");
            //check if username is in database
            String checkOpenApplicationForUsername = InputExceptionHandler.nextString();

            if (openApplications.containsKey(checkOpenApplicationForUsername))
            {
                System.out.println("Please select an option: " +
                        "\n1. Approve Application" +
                        "\n2. Deny Application");
                int approveOrDeny = InputExceptionHandler.nextInt();
                switch (approveOrDeny)
                {
                    case 1:
                        for (Customer selectedCustomer : openApplications.values())
                        {
                            if (selectedCustomer.getCustomerUsername().equals(checkOpenApplicationForUsername))
                            {
                                HashMap<String, Customer> existingCustomers = loader.loadExistingCustomers("existing_customers.ser");
                                existingCustomers.put(selectedCustomer.getCustomerUsername(), selectedCustomer);
                                String primaryCustomerFullName = selectedCustomer.getPrimaryFirstName() + " " +
                                        selectedCustomer.getPrimaryLastName();
                                String secondaryCustomerFullName = selectedCustomer.getSecondaryFirstName() + " " +
                                        selectedCustomer.getSecondaryLastName();

                                saver.saveCustomerFile(existingCustomers, "existing_customers.ser");
                                InputExceptionHandler.threadSleeper();
                                openApplications.remove(selectedCustomer.getCustomerUsername());
                                InputExceptionHandler.threadSleeper();
                                saver.saveCustomerFile(openApplications, "customer_applications.ser");

                                if (selectedCustomer.getAccountType().equals("Joint"))
                                {
                                    System.out.println("Thank you. " + primaryCustomerFullName + " and " + secondaryCustomerFullName +
                                            "'s application for a bank account has been approved. They may now login.");
                                }
                                else if (selectedCustomer.getAccountType().equals("Individual"))
                                {
                                    System.out.println("Thank you. " + primaryCustomerFullName +
                                        "'s application for a bank account has been approved. They may now login.");
                                }
                                else
                                {
                                    System.out.println("Invalid input.");
                                }

                            }
                        }


                    case 2:
                        for (Customer selectedCustomer : openApplications.values())
                        {
                            if (selectedCustomer.getCustomerUsername().equals(checkOpenApplicationForUsername))
                            {
                                String primaryCustomerFullName = selectedCustomer.getPrimaryFirstName() + " " +
                                        selectedCustomer.getPrimaryLastName();
                                String secondaryCustomerFullName = selectedCustomer.getSecondaryFirstName() + " " +
                                        selectedCustomer.getSecondaryLastName();

                                openApplications.remove(selectedCustomer.getCustomerUsername());
                                if (selectedCustomer.getAccountType().equals("Joint"))
                                {
                                    saver.saveCustomerFile(openApplications, "customer_applications.ser");
                                    System.out.println(primaryCustomerFullName + " and " + secondaryCustomerFullName +
                                            "'s application for a bank account has been denied.");
                                }
                                else if (selectedCustomer.getAccountType().equals("Individual"))
                                {
                                    saver.saveCustomerFile(openApplications, "customer_applications.ser");
                                    System.out.println(primaryCustomerFullName +
                                            "'s application for a bank account has been denied.");
                                }
                                else
                                {
                                    System.out.println("Invalid input.");
                                }

                            }
                        }

                    default:
                        System.out.println("Invalid selection.");
                }
            }
            else
            {
                System.out.println("Sorry, that customer does not exist.");
            }
        }

    }

}



