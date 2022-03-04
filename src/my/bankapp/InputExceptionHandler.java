package my.bankapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputExceptionHandler
{
    public static int intInput()
    {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        try
        {
            input = sc.nextInt();
        } catch (InputMismatchException e)
        {
            System.out.println("No one's around to help: ");
        }
        return input;
    }

    public static String stringInput()
    {
        Scanner sc = new Scanner(System.in);
        String input = null;
        try
        {
            input = sc.next();
        } catch (InputMismatchException e)
        {
            System.out.println("Please enter a valid string.");
        }
        return input;
    }
}
