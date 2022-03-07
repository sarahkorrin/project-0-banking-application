package my.bankapp;

public class AdminOptionsMenu
{
    BankManagerOptionsMenu bankManagerOptionsMenu = new BankManagerOptionsMenu();
    BankManager approveOrDenyApplication = new BankManager();
    void AdminOptions()
    {
        System.out.println("Welcome admin. What would you like to do?" +
                "\n1. Approve/deny applications to open accounts" +
                "\n2. Check/edit customer account information and balances" +
                "\n3. Open/close an account" +
                "\n4. Log out");

        int adminMainOptionsMenu = InputExceptionHandler.nextInt();


            switch (adminMainOptionsMenu)
            {

            case 1:

                bankManagerOptionsMenu.approveOrDenyApplication();
                break;

            case 2:

                System.out.println("What customer would you like to check? Please input their username: ");

                String customerUsername = InputExceptionHandler.nextString();

                System.out.println("Would you like to view their account information or edit their balance?");

            case 3:

                System.out.println("What would you like to do? " +
                        "1. Open an account" +
                        "2. Close an account");

                int adminOpenOrCloseAccount = InputExceptionHandler.nextInt();

                if (adminOpenOrCloseAccount == 1 )
                {

                }

                else if (adminOpenOrCloseAccount == 2)
                {

                }

                else
                {
                    System.out.println("Invalid input.");
                    AdminOptions();
                }
            }


    }


    public void closeCustomerAccount()
    {

    }





}
