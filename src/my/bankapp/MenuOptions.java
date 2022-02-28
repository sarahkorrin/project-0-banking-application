package my.bankapp;

import java.util.Scanner;

public class MenuOptions
{
    Scanner userInput = new Scanner(System.in);

    void welcomeMenu()
    {
        System.out.println("Welcome to the bank. Are you an employee or a customer?");

        String employeeOrCustomerChoice = userInput.next();

        if (employeeOrCustomerChoice.toLowerCase().equals("employee")) {
            employeeLogin();
        } else if (employeeOrCustomerChoice.toLowerCase().equals("customer"))

        {
           customerLogin();
        }

        else
        {
            System.out.println("Invalid entry.");
        }


        String choice = userInput.next(); // Creates a variable for whether the user wants to create an account or not

        // choice.toLowerCase(Locale.ROOT);


    }

    void employeeLogin()
    {
        System.out.println("Please input your employee login information: ");
    }

    void customerLogin()
    {
        System.out.println("Please input your customer login information: ");
    }
}