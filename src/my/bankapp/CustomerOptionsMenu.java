package my.bankapp;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class CustomerOptionsMenu
{
    Scanner userInput = new Scanner(System.in);
    Customer customer = new Customer();
    void customerAccountMenu()
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


        int customerAccountOptionsMenu = userInput.nextInt();

        switch(customerAccountOptionsMenu)
        {

            case 1:
                System.out.println("\n" +
                        "Your current balance is: $" + customer.getBalance() + "\n");
                customerAccountMenu();
                break;

            case 2:
                System.out.println("\nHow much money would you like to deposit? Please input a number: \n");

                int depositNumber = userInput.nextInt();
                customer.setBalance(customer.getBalance() + depositNumber );
                System.out.println("\nYou have deposited $" + depositNumber + ".");
                System.out.println("Your new balance is $" + customer.getBalance() + "." + "\n");
                customerAccountMenu();


                break;

            case 3:

                System.out.println("\nHow much money would you like to withdraw? Please input a number: \n");

                int withdrawNumber = userInput.nextInt();
                customer.setBalance(customer.getBalance() - withdrawNumber);
                System.out.println("\nYou have withdrawn $" + withdrawNumber + ".");
                System.out.println("Your new balance is $" + customer.getBalance() + "." + "\n");
                customerAccountMenu();


                break;


            case 4:
                // Transfer money between accounts

                break;


            case 5:

                System.out.println("\nYou will now be logged out. Thank you for coming to the bank!" + "\n");
                break;


            default:

                System.out.println("Invalid input." + "\n");
                customerAccountMenu();
                break;
        }
    }
}
