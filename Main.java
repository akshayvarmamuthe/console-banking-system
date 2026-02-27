
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Create your Account");
        Scanner s=new Scanner(System.in);
        System.out.print("enter your name: ");
        String userName=s.nextLine();
        System.out.print("enter your age: ");
        int userAge=s.nextInt();
        System.out.print("enter your opening balance: ");
        double userBalance=s.nextDouble();
        Account ac;
        if(userAge>=18)
           ac=new MajorAccount(userName, userAge, userBalance);
        else
            ac=new MinorAccount(userName, userAge, userBalance);
        
        ac.displayAccountDetails();
        s.close();
    }
}
class Account
{
    private static final String BANK_CODE="AK-26-";
    private static final Random random=new Random();
    private final int id= 1000+random.nextInt(9000); 
    final String userAcNO=BANK_CODE+id;
    String userName;
    int userAge;
    double userBalance;
    public void displayAccountDetails()
    {
        System.out.println("Account Number: "+userAcNO);
        System.out.println("Account Holder: "+userName);
        System.out.println("Account Holder Age: "+userAge);
        System.out.println("Account Balance: "+userBalance);
    }
}
class MajorAccount extends Account
{
    MajorAccount(String userName, int userAge, double userBalance)
    {
        this.userName=userName;
        this.userAge=userAge;
        this.userBalance=userBalance;
        System.out.println("Your Major Account is Created!");
    }
}
class MinorAccount extends Account
{
    MinorAccount(String userName, int userAge, double userBalance)
    {
        this.userName=userName;
        this.userAge=userAge;
        this.userBalance=userBalance;
        System.out.println("Your Minor Account is Created!");

    }
}