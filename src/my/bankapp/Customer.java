package my.bankapp;

public class Customer {
    /**
     * Defined customer variables
     */
    String customerUserName;
    String customerPassWord;
    String customerFirstName;
    String customerLastName;
    int customerSocialSecurity;
    double balance;


    /**
     * Method that allows a customer to withdraw money
     */

    void withdraw(double withdrawBalance) {
        withdrawBalance = withdrawBalance - balance;
    }

    void deposit(double depositBalance) {
        depositBalance = balance + depositBalance;
    }
}
//    transfer()
//    {
//
//    }
//}


