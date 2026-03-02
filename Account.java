
import java.util.Random;

public abstract class Account
{
    private static final String BANK_CODE="AK-26-";
    private static final Random random=new Random();
    private final int id= 1000+random.nextInt(9000); 
    private final String userAccountNumber=BANK_CODE+id;
    private String userName;
    private int userAge;
    private double userBalance;

    public Account(String userName, int userAge, double userBalance)throws InvalidUserNameException,InvalidAgeException, InvalidAmountException
    {
        if(userName==null || userName.trim().isEmpty())
        {
            throw new InvalidUserNameException("Name cannot be empty");
        }
        this.userName=userName;
        if(userAge<0)
        {
            throw new InvalidAgeException("Age cannot be negative");
        }
        this.userAge=userAge;
        if(userBalance<=0)
        {
            throw new InvalidAmountException("Minimum Opening Balance should be greater than 0");
        }
        this.userBalance=userBalance;
    }
    public String getUserAccountNumber()
    {
        return userAccountNumber;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String newName)throws InvalidUserNameException
    {
        if(newName==null || newName.trim().isEmpty())
        {
            throw new InvalidUserNameException("Name cannot be empty");
        }
        this.userName=newName;
    }
    public int getUserAge()
    {
        return userAge;
    }
    public double getUserBalance()
    {
        return userBalance;
    }
    protected void deductBalance(double amount)
    {
        userBalance-=amount;
    }
    public void displayAccountDetails()
    {
        System.out.println("Account Number: "+userAccountNumber);
        System.out.println("Account Holder: "+userName);
        System.out.println("Account Holder Age: "+userAge);
        System.out.println("Account Balance: "+userBalance);
    }
    public void depositMoney(double amount)throws InvalidAmountException
    {
        if(amount<=0)
        {
            throw new InvalidAmountException("Please Deposit Valid Amount");
        }
        userBalance+=amount;
    }
    abstract void withdrawMoney(double amount)throws InvalidAmountException, InsufficientBalanceException, WithdrawalLimitException;
}