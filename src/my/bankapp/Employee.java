package my.bankapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
    /**
     * Defined employee variables
     */
    String employeeFirstName;
    String employeeLastName;
    int employeeIDNumber;
    String employeeAddress;

    void checkCustomerAccountBalance() {
        Scanner employeeInput = new Scanner(System.in);

        System.out.println("What customer are you looking to check? Please input their first name: ");

        Customer customer = new Customer(); // Creates a customer object called from the customer class
        customer.customerFirstName = employeeInput.nextLine();

        System.out.println("What is the customer's last name: ");
        customer.customerLastName = employeeInput.nextLine();

        System.out.println("What would you like to check from " + customer.customerFirstName + customer.customerLastName +
                "'s account? Type a number to input your choice. Would you like to" +
                "\n1: Check their account information" + // Whether the account is ind or joint, username
                "\n2: Check their account balances" + // Balance amount
                "\n3: Check their personal information"); // Name, address


        int employeeCustomerAccountChoice = employeeInput.nextInt();

        switch (employeeCustomerAccountChoice) {
            case 1:
                System.out.println("What account information would you like to access?" +
                        "\n1: User account type: individual or joint" +
                        "\n2: Username");
                int employeeCustomerInfoChoice = employeeInput.nextInt();

                if (employeeCustomerInfoChoice == 1) {
                    System.out.println(customer.customerFirstName + " " + customer.customerLastName + " has an account.");
                } else if (employeeCustomerInfoChoice == 2) {
                    System.out.println("customer.customerFirstName" + " " + customer.customerLastName + "'s username is " + customer.customerUserName);
                } else {
                    System.out.println("Invalid input.");
                    try {
                        employeeCustomerInfoChoice = employeeInput.nextInt();
                    } catch (InputMismatchException errorHandler) {
                        System.out.println("Invalid input.");
                    }
                }
                    case 2:
                        System.out.println("What account balances would you like to access?");

                    case 3:
                        System.out.println("What personal information would you like to access?");

                    default:
                        System.out.println("Invalid entry.");

                }
        }
//
//
//
//    }
//
//    checkCustomerAccountInfo()
//    {
//
//    }
//
//    checkCustomerPersonalInfo
//    {
//
//    }

        }