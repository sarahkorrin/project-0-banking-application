package my.bankapp;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerOptionsMenu
{
    SerializationLoader loader = new SerializationLoader();
    SerializationSaver saver = new SerializationSaver();
    String transactionDetails = "";

    void saveAndLogTransaction(Customer customer, String transaction)
    {
        HashMap<String, Customer> existingCustomers = loader.loadExistingCustomers("customer_applications.ser");
        existingCustomers.put(customer.getCustomerUsername(), customer);
        ArrayList<String> transactions = loader.loadTransactions();
        transactions.add(transaction);
        saver.saveTransactionFile(transactions, "transactions_log.ser");
        saver.saveCustomerFile(existingCustomers, "customer_applications.ser");
    }

    void customerAccountMenu(Customer customer)
    {
        System.out.println("\n" +
                "Welcome to your account. What would you like to do?" +
                "\n" +
                "\n1. Check your balance" +
                "\n2. Deposit funds" +
                "\n3. Withdraw funds" +
                "\n4. Transfer money to another account" +
                "\n5. Log out" +
                "\n");


        int customerAccountOptionsMenu = InputExceptionHandler.nextInt();

        switch (customerAccountOptionsMenu)
        {

            case 1:
                System.out.println("\n" +
                        "Your current balance is: $" + customer.getBalance() + "\n");
                customerAccountMenu(customer);
                break;

            case 2:
                System.out.println("\nHow much money would you like to deposit? Please input a number: \n");

                double depositNumber = InputExceptionHandler.nextDouble();

                if (depositNumber <= 0)
                {
                    System.out.println("Invalid number. You must deposit an amount greater than $0.");
                    customerAccountMenu(customer);
                } else
                {
                    customer.setBalance(customer.getBalance() + depositNumber);
                    System.out.println("\nYou have deposited $" + depositNumber + ".");
                    System.out.println("Your new balance is $" + customer.getBalance() + "." + "\n");

                    transactionDetails = customer.getCustomerUsername() + " deposited: " + String.valueOf(depositNumber);
                    saveAndLogTransaction(customer, transactionDetails);
                    transactionDetails = "";

                    customerAccountMenu(customer);
                    break;
                }

            case 3:

                System.out.println("\nHow much money would you like to withdraw? Please input a number: \n");
                double withdrawNumber = InputExceptionHandler.nextDouble();

                if (withdrawNumber <= 0)
                {
                    System.out.println("Invalid number. You must withdraw an amount greater than $0.");
                    customerAccountMenu(customer);
                } else
                {
                    double testNegative = customer.getBalance() - withdrawNumber;
                    if (testNegative < 0)
                    {
                        System.out.println("Insufficient funds. Withdrawal cannot be greater than balance.");
                        customerAccountMenu(customer);
                    } else
                    {
                        customer.setBalance(customer.getBalance() - withdrawNumber);
                        System.out.println("\nYou have withdrawn $" + withdrawNumber + ".");
                        System.out.println("Your new balance is $" + customer.getBalance() + "." + "\n");

                        transactionDetails = customer.getCustomerUsername() + " withdrew: " + String.valueOf(withdrawNumber);
                        saveAndLogTransaction(customer, transactionDetails);
                        transactionDetails = "";

                        customerAccountMenu(customer);
                        break;
                    }
                }


            case 4:
                // Transfer money between accounts
                System.out.println("Who would you like to transfer the money to? " +
                        "\nPlease input their username: ");
                String targetUsername = InputExceptionHandler.nextString();
                System.out.println("How much money would you like to transfer?");
                double transferNumber = InputExceptionHandler.nextDouble();

                if (transferNumber <= 0)
                {
                    System.out.println("Invalid number. You must transfer an amount greater than $0.");
                    customerAccountMenu(customer);
                }

                else
                {

                    double testNegative = customer.getBalance() - transferNumber;

                    if (testNegative < 0)
                    {
                        System.out.println("Insufficient funds. Transfer amount cannot be greater than balance.");
                        customerAccountMenu(customer);
                    }
                    else
                    {
                        HashMap<String, Customer> customers = loader.loadExistingCustomers
                                ("customer_applications.ser");
                        for (Customer targetCustomer : customers.values())
                        {
                            if (customers.containsKey(targetUsername))
                            {
                                if (targetCustomer.getCustomerUsername().equals(targetUsername))
                                {
                                    customer.setBalance(customer.getBalance() - transferNumber);
                                    targetCustomer.setBalance(targetCustomer.getBalance() + transferNumber);
                                    transactionDetails = customer.getCustomerUsername() + " transferred " +
                                            String.valueOf(transferNumber)
                                            + " to " + targetCustomer.getCustomerUsername();
                                    customers.put(targetCustomer.getCustomerUsername(), targetCustomer);
                                    saver.saveCustomerFile(customers, "customer_applications.ser");
                                    saveAndLogTransaction(customer, transactionDetails);
                                    transactionDetails = "";
                                    System.out.println("\nYou have successfully transferred " + transferNumber
                                            + " to " + targetUsername);
                                    System.out.println("Your new balance is: " + customer.getBalance() +
                                            ".\n");
                                    customerAccountMenu(customer);
                                }
                            }
                            else
                            {
                                System.out.println("Sorry, that user doesn't exist.");
                                customerAccountMenu(customer);
                            }
                        }

                    }
                    break;
                }


            case 5:

                System.out.println("\nYou will now be logged out. Thank you for coming to the bank!" + "\n");
                System.exit(0);


            default:

                System.out.println("Invalid input." + "\n");
                customerAccountMenu(customer);
                break;

        }

    }

}
