import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }
        while (retString.length() == 0);
        return retString;
    }
    public static int getInt(Scanner pipe, String prompt)
    {
        int userInt = 0;
        boolean gotInt = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                userInt = pipe.nextInt();
                pipe.nextLine();
                gotInt = true;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid integer. Not: " + trash);
            }
        }
        while (!gotInt);
        return userInt;
    }
    public static double getDouble(Scanner pipe, String prompt)
    {
        double userDouble = 0.0;
        boolean gotDouble = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                userDouble = pipe.nextDouble();
                pipe.nextLine();
                gotDouble = true;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid double. Not: " + trash);
            }
        }
        while (!gotDouble);
        return userDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int userInt = 0;
        boolean gotInt = false;
        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                userInt = pipe.nextInt();
                pipe.nextLine();
                if (userInt >= low && userInt <= high)
                {
                    gotInt = true;
                }
                else
                {
                    System.out.println("Number out of range [" + low + " - " + high + "]: " + userInt);
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid integer. Not: " + trash);
            }
        }
        while (!gotInt);
        return userInt;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double userDouble = 0.0;
        boolean gotDouble = false;
        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                userDouble = pipe.nextDouble();
                pipe.nextLine();
                if (userDouble >= low && userDouble <= high)
                {
                    gotDouble = true;
                }
                else
                {
                    System.out.println("Number out of range [" + low + " - " + high + "]: " + userDouble);
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid double. Not: " + trash);
            }
        }
        while (!gotDouble);
        return userDouble;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";
        boolean retVal = false;
        boolean gotVal = false;
        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y"))
            {
                retVal = true;
                gotVal = true;
            }
            else if (response.equalsIgnoreCase("N"))
            {
                retVal = false;
                gotVal = true;
            }
            else
            {
                System.out.println("You must enter [Y/N]: " + response);
            }
        }
        while (!gotVal);
        return retVal;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response = "";
        boolean gotMatch = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx))
            {
                gotMatch = true;
            }
            else
            {
                System.out.println("Invalid input match [" + regEx + "]: " + response);
            }
        }
        while (!gotMatch);
        return response;
    }
}