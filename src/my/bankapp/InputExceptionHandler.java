package my.bankapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputExceptionHandler
{
    public static int nextInt()
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

    public static String nextString()
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

    public static double nextDouble()
    {
        Scanner sc = new Scanner(System.in);
        double input = 0;
        try
        {
            input = sc.nextDouble();
            Math.round(input * 100);;
        }
        catch (InputMismatchException e)
        {
            System.out.println("No one's around to help: ");
        }
        return input;
    }

    static void threadSleeper()
    {
        try
        {
            Thread.sleep(10);
        }
        catch (InterruptedException e)
        {
            System.out.println("No one's around to help: " + e.getStackTrace());
        }
    }
}
