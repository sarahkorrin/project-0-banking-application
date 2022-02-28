package my.bankapp;

import org.w3c.dom.ls.LSOutput;

import java.util.Locale;
import java.util.Scanner; // Imports user input Scanner

public class Main { // Main class


    public static void main(String[] args) {  // Main method


        Scanner userInput = new Scanner(System.in); // Declaring scanner to an object


        System.out.println("Welcome to the bank. Are you an employee or a customer?");

        String employeeOrCustomerChoice = userInput.next();

        if (employeeOrCustomerChoice.toLowerCase().equals("employee"))

        {
            System.out.println("Please input your employee login information: ");
        }

        else if (employeeOrCustomerChoice.toLowerCase().equals("customer"))

        {
            System.out.println("Would you like to create an account or log in? Please input a number for your choice" +
                    "\n1. Create an account" +
                    "\n2. Login");

            int createAnAccountOrLogin = userInput.nextInt();

            if (createAnAccountOrLogin == 1)
            {


                /**
                 *  Would you like to create an account OPTION: yes
                 */

                System.out.println("Would you like to create a individual or joint account? " +
                        "\nPlease type 1 for individual and 2 for joint.");

                int IndOrJoint = userInput.nextInt();

                if (IndOrJoint == 1) {

                    /**
                     * Individual or joint account option: 1
                     * Individual Account
                     */

                    Customer customer1 = new Customer(); // creates a new customer object

                    System.out.println("Please enter your username: "); // Asks the user to input a username
                    customer1.customerUserName = userInput.next(); // Creates a variable for the user's username
                    System.out.println("\nYour username has been set as: " + customer1.customerUserName);


                    System.out.println("\nPlease enter your password: "); // Asks the user to input a password
                    customer1.customerPassWord = userInput.next(); // Creates a variable for the user's password
                    System.out.println("Thanks! Your password has been set.");

                    System.out.println("Please enter your first name: "); // Asks the user to input their first name
                    customer1.customerFirstName = userInput.next(); // Creates a variable for the user's first name
                    System.out.println("Please enter your last name: "); // Asks the user to input their last name
                    customer1.customerLastName = userInput.next(); // Creates a variable for the user's last name

                    System.out.println("Your name has been register as " + customer1.customerFirstName + " " + customer1.customerLastName + "." +
                            "\nPlease enter your social security number: "); // Asks the user to input their social security #
                    customer1.customerSocialSecurity = userInput.nextInt(); // Creates a variable for the user's social security #
                    System.out.println("Thanks, your social security number has been saved.");

                    System.out.println("Would you like to log in?"); // Asks the user if they want to log in
                    String logIn = userInput.next(); // Creates a variable for the user's log in option


                    if

                    (logIn.toLowerCase().equals("yes"))

                    // The user wants to log in. (Individual Account)
                    {
                        boolean bankingInfoLoopInd = true;

                        System.out.println("Welcome to your account, " + customer1.customerFirstName + " " + customer1.customerLastName + ".");

                        System.out.println("Would you like to check your banking information? Please type yes or no.");


                        while(bankingInfoLoopInd){  // while loop for checking your bank info responses
                            String bankingInfoInd = userInput.next();

                            if (bankingInfoInd.toLowerCase().equals("yes"))

                            {
                                System.out.println("What would you like to access?");
                                bankingInfoLoopInd = false;
                            }

                            else if (bankingInfoInd.toLowerCase().equals("no")) {
                                System.out.println("Okay. You will be logged out now. Thank you for your business!");
                                bankingInfoLoopInd = false;
                            }

                            else
                            {
                                System.out.println("Invalid response." +
                                        "\nWould you like to check your banking information? Please type yes or no.");
                            }
                        }
                    }

                    else if

                    (logIn.toLowerCase().equals("no"))

                    // The user does not want to log in. (Individual Account)
                    {
                        System.out.println("Thank you for visiting the bank. Enjoy your day!");
                    }

                    else

                    // Invalid bank login entry (Individual Account)
                    {
                        System.out.println("Invalid entry. Please enter yes or no.");
                    }
                }

                else if (IndOrJoint == 2)

                /**
                 * Individual or joint account option: 2
                 * Joint Account
                 */

                {
                    Customer customer1 = new Customer();

                    System.out.println("You have chosen to make a joint account.");

                    System.out.println("Please enter your username: "); // Asks the user to input a username
                    customer1.customerUserName = userInput.next(); // Creates a variable for the user's username
                    System.out.println("Thank you! Your username is: " + customer1.customerUserName);

                    System.out.println("Please enter your password: "); // Asks the user to input a password
                    customer1.customerPassWord = userInput.next();
                    System.out.println("Thanks! Your password has been set.");

                    System.out.println("Please enter your first name: "); // Asks the user to input their first name
                    customer1.customerFirstName = userInput.next(); // Creates a variable for the user's first name
                    System.out.println("Please enter your last name: "); // Asks the user to input their last name
                    customer1.customerLastName = userInput.next(); // Creates a variable for the user's last name
                    System.out.println("Your name has been registered as " + customer1.customerFirstName + " " + customer1.customerLastName + ".");

                    System.out.println("Please enter your social security number: "); // Asks the user to input their social security #
                    customer1.customerSocialSecurity = userInput.nextInt(); // Creates a variable for the user's social security #
                    System.out.println("Thanks, your social security number has been saved.");


                    System.out.println("Would you like to log in?"); // Asks the user if they want to log in
                    String logIn = userInput.next(); // Creates a variable for the user's log in option

                    if
                    (logIn.toLowerCase().equals("yes"))

                    // The user wants to log in. (Joint Account)
                    {

                        boolean bankingInfoLoopJoint = true;

                        System.out.println("Welcome to your account, " + customer1.customerFirstName + " " + customer1.customerLastName + ".");
                        System.out.println("Would you like to check your banking information? Please type yes or no.");



                        while(bankingInfoLoopJoint) // while loop for checking banking info responses

                        {String bankingInfoJoint = userInput.next();

                            if (bankingInfoJoint.toLowerCase().equals("yes"))

                            {
                                System.out.println("What would you like to access?");
                                bankingInfoLoopJoint = false;
                            }

                            else if (bankingInfoJoint.toLowerCase().equals("no"))

                            {
                                System.out.println("Okay. You will be logged out now. Thank you for your business!");
                                bankingInfoLoopJoint = false;
                            }

                            else

                            {
                                System.out.println("Invalid response." +
                                        "\nWould you like to check your banking information? Please type yes or no.");
                            }
                        }
                    }

                    else if

                    (logIn.toLowerCase().equals("no"))
                    // The user does not want to log in. (Joint Account)
                    {
                        System.out.println("Thank you for visiting the bank. Enjoy your day!");
                    }

                    else

                    // Invalid log in entry (Joint Account)
                    {
                        System.out.println("Invalid entry. Please enter yes or no.");
                    }


                }

                else if (createAnAccountOrLogin == 2)

                /**
                 **  Would you like to create an account OPTION: no
                 */

                {
                    System.out.print("Please input your login information");
                }

                else

                /**
                 *  Would you like to create an account INVALID ENTRY.
                 */
                {
                    System.out.println("Invalid entry. Please type 1 to create an account and 2 to log in.");
                }
            }


        }

        else
        {
            System.out.println("Invalid entry.");
        }



        String choice = userInput.next(); // Creates a variable for whether the user wants to create an account or not

        // choice.toLowerCase(Locale.ROOT);


    }
}