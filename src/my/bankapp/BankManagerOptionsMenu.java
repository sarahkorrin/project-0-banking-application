package my.bankapp;

import javax.sound.midi.Soundbank;
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
            System.out.println("\nWelcome, " + employee.getBankManagerFirstName() +
                    "! What would you like to do? Please input a number: " +
                    "\n1. Approve open applications" +
                    "\n2. Check customer account" +
                    "\n3. View Transactions Log" +
                    "\n4. Gain Admin Access" +
                    "\n5. Log out");
            if (bankManager.getBankManagerAccountType().equals("Admin"))
            {
                System.out.println("\nAdmin Menu:" +
                        "\n6. Open Customer Account" +
                        "\n7. Close Customer Account" +
                        "\n8. Deposit to Customer Account" +
                        "\n9. Withdraw from Customer Account" +
                        "\n10. Transfer between Customer Accounts");
            }

            int applicationOrCustomerAccount = InputExceptionHandler.nextInt();

            if (applicationOrCustomerAccount == 1)
            {
                approveOrDenyApplication();
            } else if (applicationOrCustomerAccount == 2)
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

            } else if (applicationOrCustomerAccount == 3)
            {
                ArrayList<String> transactionsLog = loader.loadTransactions();
                System.out.println("\n-----------------------------------------------------------------");
                for (String transaction : transactionsLog)
                {
                    if (transactionsLog.isEmpty() || transactionsLog == null)
                    {
                        System.out.println("There are no transactions.");
                    } else
                    {
                        System.out.println(transaction);
                    }
                }
                System.out.println("-----------------------------------------------------------------\n");
            } else if (applicationOrCustomerAccount == 4)
            {
                System.out.println("Please enter security code for admin rights: ");
                int adminAccess = InputExceptionHandler.nextInt();
                if (adminAccess == 7524)
                {
                    bankManager.setBankManagerAccountType("Admin");
                    System.out.println("Access granted.");
                } else
                {
                    System.out.println("Access denied.");
                }
            }
            else if (applicationOrCustomerAccount == 5)
            {
                System.out.println("You will now be logged out.");
                System.exit(0);
            }
            else if (applicationOrCustomerAccount == 6)
            {
                if (bankManager.getBankManagerAccountType().equals("Admin"))
                    adminOpenCustomerAccount();
                else
                    System.out.println("Invalid selection.\n");
            } else if (applicationOrCustomerAccount == 7)
            {
                if (bankManager.getBankManagerAccountType().equals("Admin"))
                    closeCustomerAccount();

                else
                    System.out.println("Invalid selection.\n");
            } else if (applicationOrCustomerAccount == 8)
            {
                if (bankManager.getBankManagerAccountType().equals("Admin"))

                    adminCustomerDeposit();
                else
                    System.out.println("Invalid selection.\n");

            } else if (applicationOrCustomerAccount == 9)
            {
                if (bankManager.getBankManagerAccountType().equals("Admin"))
                    adminCustomerWithdrawal();
                else
                    System.out.println("Invalid selection.\n");
            } else if (applicationOrCustomerAccount == 10)
            {
                if (bankManager.getBankManagerAccountType().equals("Admin"))
                    adminCustomerTransfer();
                else
                    System.out.println("Invalid selection.\n");
            } else
            {
                System.out.println("Invalid selection.\n");
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
        if (openApplications.isEmpty() || openApplications == null)
        {
            System.out.println("There are no open applications at this time.\n");
        } else
        {
            System.out.println("\nHere is the list of open applications: ");
            for (Customer customerApplication : openApplications.values())
            {
                System.out.println("----------------------------------------" +
                        "\nUsername: " + customerApplication.getCustomerUsername() +
                        "\nAccount Type: " + customerApplication.getAccountType() +
                        "\nPrimary Full Name: " + customerApplication.getPrimaryFirstName() +
                        " " + customerApplication.getPrimaryLastName());
                if (customerApplication.getAccountType().equals("Joint"))
                {
                    System.out.println("Secondary Full Name: " + customerApplication.getSecondaryFirstName() +
                            " " + customerApplication.getSecondaryLastName());
                }
                System.out.println("----------------------------------------\n");
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
                        String buffer = "";
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
                                buffer = selectedCustomer.getCustomerUsername();

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
                        openApplications.remove(buffer);
                        InputExceptionHandler.threadSleeper();
                        saver.saveCustomerFile(openApplications, "customer_applications.ser");
                        break;


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

                        break;

                    default:
                        System.out.println("Invalid selection.");

                        break;
                }
            }
            else
            {
                System.out.println("Sorry, that customer does not exist.");

            }

        }

    }

    private void adminOpenCustomerAccount()
    {
        Customer newCustomer = new Customer();
        System.out.println("Please enter the desired username for the account: ");
        String customerUsername = InputExceptionHandler.nextString();
        newCustomer.setCustomerUsername(customerUsername);

        System.out.println("Please enter the desired password for the account: ");
        String customerPassword = InputExceptionHandler.nextString();
        newCustomer.setCustomerPassword(customerPassword);

        System.out.println("What account type will they have. Please type a number." +
                "\n1. Individual" +
                "\n2. Joint");

        int indOrJoint = InputExceptionHandler.nextInt();

        if (indOrJoint == 1)
        {
            newCustomer.setAccountType("Individual");

            System.out.println("Please enter the customer's first name: ");
            String primaryFirstName = InputExceptionHandler.nextString();
            newCustomer.setPrimaryFirstName(primaryFirstName);

            System.out.println("Please enter the customer's last name: ");
            String primaryLastName = InputExceptionHandler.nextString();
            newCustomer.setPrimaryLastName(primaryLastName);

            HashMap<String, Customer> existingCustomers = loader.loadExistingCustomers("existing_customers.ser");
            existingCustomers.put(newCustomer.getCustomerUsername(), newCustomer);
            saver.saveCustomerFile(existingCustomers, "existing_customers.ser");

            System.out.println("Thank you. " + primaryFirstName + " " + primaryLastName + "'s " +
                    "account has been created. They may now log in.");
        }

        else if (indOrJoint == 2)
        {
            newCustomer.setAccountType("Joint");
            System.out.println("Please enter the primary account holder's first name: ");
            String primaryFirstName = InputExceptionHandler.nextString();
            newCustomer.setPrimaryFirstName(primaryFirstName);

            System.out.println("Please enter the primary account holder's last name: ");
            String primaryLastName = InputExceptionHandler.nextString();
            newCustomer.setPrimaryLastName(primaryLastName);

            System.out.println("Please enter the secondary account holder's first name: ");
            String secondaryFirstName = InputExceptionHandler.nextString();
            newCustomer.setSecondaryFirstName(secondaryFirstName);

            System.out.println("Please enter the secondary account holder's last name: ");
            String secondaryLastName = InputExceptionHandler.nextString();
            newCustomer.setSecondaryLastName(secondaryLastName);

            HashMap<String, Customer> existingCustomers = loader.loadExistingCustomers("existing_customers.ser");
            existingCustomers.put(newCustomer.getCustomerUsername(), newCustomer);
            saver.saveCustomerFile(existingCustomers, "existing_customers.ser");

            System.out.println("Thank you. " + primaryFirstName + " " + primaryLastName + " and " +
                    secondaryFirstName + " " + secondaryLastName + "'s " +
                    "account has been created. They may now log in.");
        }
    }

    private void closeCustomerAccount()
    {
        System.out.println("\nThese are the existing customers at the bank. ");
        HashMap<String, Customer> existingCustomers = loader.loadExistingCustomers("existing_customers.ser");
        for (Customer existingCustomer : existingCustomers.values())
        {
            System.out.print("\n-------------------------------------------------------" +
                    "\nUsername: " + existingCustomer.getCustomerUsername() +
                    "\nFull Name(s): " + existingCustomer.getPrimaryFirstName() + " " +
                    existingCustomer.getPrimaryLastName());
            if (existingCustomer.getAccountType().equals("Joint"))
            {
                System.out.print(", " + existingCustomer.getSecondaryFirstName() + " " +
                        existingCustomer.getSecondaryLastName());
            }
            System.out.println("\n-------------------------------------------------------\n");
        }
        // print out table of existing customers with their first + last names and username

        System.out.println("Which account would you like to close? Please input their username: ");
        String closeAccountMember = InputExceptionHandler.nextString();

        if (existingCustomers.containsKey(closeAccountMember))
        {
            existingCustomers.remove(closeAccountMember);
            saver.saveCustomerFile(existingCustomers, "existing_customers.ser");

            System.out.println("Thank you. The account for " + closeAccountMember + " has been terminated.");
        } else
        {
            System.out.println("Sorry, that account does not exist.");
        }

    }

    private void adminCustomerDeposit()
    {
        CustomerOptionsMenu custOptions = new CustomerOptionsMenu();
        System.out.println("Please enter the username of the customer:");
        String adminInputForCustName = InputExceptionHandler.nextString();
        Customer customer = checkCustomerAccountIdentifier(adminInputForCustName);
        System.out.println("\nHow much money would you like to deposit? Please input a number: \n");

        double depositNumber = InputExceptionHandler.nextDouble();

        if (depositNumber <= 0)
        {
            System.out.println("Invalid number. You must deposit an amount greater than $0.");
        } else
        {
            customer.setBalance(customer.getBalance() + depositNumber);
            System.out.println("\nYou have deposited $" + depositNumber + " into the account.");
            System.out.println("The new balance is $" + customer.getBalance() + "." + "\n");

            String transactionDetails = "An admin deposited " + String.valueOf(depositNumber) + " to " +
                    customer.getCustomerUsername();
            customer.transactions.add(transactionDetails);
            custOptions.saveAndLogTransaction(customer, transactionDetails);
            transactionDetails = "";
        }
    }

    private void adminCustomerWithdrawal()
    {
        CustomerOptionsMenu custOptions = new CustomerOptionsMenu();
        System.out.println("Whose account would you like to withdraw from? Please input their username: ");
        String adminCustomerWithdraw = InputExceptionHandler.nextString();

        Customer customer = checkCustomerAccountIdentifier(adminCustomerWithdraw);

        System.out.println("\nHow much money would you like to withdraw? Please input a number: \n");
        double withdrawNumber = InputExceptionHandler.nextDouble();

        if (withdrawNumber <= 0)
        {
            System.out.println("Invalid number. You must withdraw an amount greater than $0.");
        }
        else
        {
            double testNegative = customer.getBalance() - withdrawNumber;
            if (testNegative < 0)
            {
                System.out.println("Insufficient funds. Withdrawal cannot be greater than balance.");
            } else
            {
                customer.setBalance(customer.getBalance() - withdrawNumber);
                System.out.println("\nYou have withdrawn $" + withdrawNumber + " from the account.");
                System.out.println("The new balance is $" + customer.getBalance() + "." + "\n");

                String transactionDetails = "An admin withdrew " + String.valueOf(withdrawNumber + " from " + customer.getCustomerUsername());
                customer.transactions.add(transactionDetails);
                custOptions.saveAndLogTransaction(customer, transactionDetails);
                transactionDetails = "";
            }
        }
    }

    private void adminCustomerTransfer()
    {
        CustomerOptionsMenu custOptions = new CustomerOptionsMenu();
        System.out.println("Please input the username of the account that you are transferring from: ");
        String adminTransferCustomerUsername = InputExceptionHandler.nextString();
        Customer customer = checkCustomerAccountIdentifier(adminTransferCustomerUsername);


        System.out.println("Who would you like to transfer the money to? " +
                "\nPlease input their username: ");
        String targetUsername = InputExceptionHandler.nextString();

        System.out.println("How much money would you like to transfer?");
        double transferNumber = InputExceptionHandler.nextDouble();

        if (transferNumber <= 0)
        {
            System.out.println("Invalid number. You must transfer an amount greater than $0.");
        } else
        {

            double testNegative = customer.getBalance() - transferNumber;

            if (testNegative < 0)
            {
                System.out.println("Insufficient funds. Transfer amount cannot be greater than balance.");
            }
            else
            {
                HashMap<String, Customer> customers = loader.loadExistingCustomers
                        ("existing_customers.ser");
                for (Customer targetCustomer : customers.values())
                {
                    if (customers.containsKey(targetUsername))
                    {
                        if (targetCustomer.getCustomerUsername().equals(targetUsername))
                        {
                            customer.setBalance(customer.getBalance() - transferNumber);
                            targetCustomer.setBalance(targetCustomer.getBalance() + transferNumber);

                            String transactionDetails = "An admin transferred " + String.valueOf(transferNumber) + " from "
                                    + customer.getCustomerUsername() + " to: " + targetCustomer.getCustomerUsername();

                            customer.transactions.add(transactionDetails);
                            customers.put(targetCustomer.getCustomerUsername(), targetCustomer);
                            saver.saveCustomerFile(customers, "existing_customers.ser");
                            custOptions.saveAndLogTransaction(customer, transactionDetails);
                            transactionDetails = "";

                            System.out.println("\nYou have successfully transferred " + transferNumber
                                    + " to: " + targetUsername);
                            System.out.println("This customer's new balance is: " + customer.getBalance() +
                                    ".\n");
                        }
                    } else
                    {
                        System.out.println("Sorry, that user doesn't exist.");
                    }
                }
            }
        }
    }
}
