import exceptions.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Account ac=null;
        System.out.println("Create your Account");
        Scanner s=new Scanner(System.in);
        while(ac==null)
        {
            System.out.print("enter your name: ");
            String userName=s.nextLine();
            System.out.print("enter your age: ");
            int userAge=s.nextInt();
            s.nextLine();
            System.out.print("enter your opening balance: ");
            double userBalance=s.nextDouble();
            s.nextLine();
            if(userAge>=18)
                try{
                    ac=new MajorAccount(userName, userAge, userBalance);
                } catch (InvalidUserNameException | InvalidAgeException | InvalidAmountException maje) {
                    System.out.println(maje.getMessage());
                }
            else
                try {
                    ac=new MinorAccount(userName, userAge, userBalance);
                } catch (InvalidUserNameException | InvalidAgeException | InvalidAmountException mine) {
                    System.out.println(mine.getMessage());
                }
        }
        int userChoice;
        boolean flag=true;
        while(flag)
        {
            System.out.println("1. Get Account Details\n2. Deposit Amount\n3. Withdraw Money\n4. Check Balance\n 5. Edit Name\n6. Exit");
            System.out.println("Enter Your Choice: ");
            userChoice=s.nextInt();
            switch(userChoice)
            {
                case 1 -> ac.displayAccountDetails();
                case 2 ->{
                    System.out.print("Enter Amount to Deposit: ");
                    double amount=s.nextDouble();
                    s.nextLine();
                    try {
                        ac.depositMoney(amount);
                    } catch (InvalidAmountException iae) {
                        System.out.println(iae.getMessage());
                    }
                } 
                case 3 ->{
                    System.out.print("Enter Amount to Withdraw: ");
                    double amount=s.nextDouble();
                    s.nextLine();
                    try {
                        ac.withdrawMoney(amount);
                    } catch (InvalidAmountException | InsufficientBalanceException | WithdrawalLimitException we) {
                        System.out.println(we.getMessage());
                    }
                }
                case 4 -> System.out.println("Your Current Balance: "+ac.getUserBalance());
                case 5 -> {
                    System.out.print("Enter New Name: ");
                    String newName=s.nextLine();
                    try {
                        ac.setUserName(newName);
                    } catch (InvalidUserNameException ine) {
                        System.out.println(ine.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("Thanks! Exiting");
                    flag=false;
                }
                default -> System.out.println("Enter Valid Option");
            }
        }
        s.close();
    }
}

