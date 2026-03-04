import exceptions.*;

public class MinorAccount extends Account
{
    final private double withdrawLimit=2000;
    MinorAccount(String userName, int userAge, double userBalance) throws InvalidUserNameException, InvalidAgeException, InvalidAmountException
    {
        super(userName, userAge, userBalance);
        if(userAge>=18)
        {
            throw new InvalidAgeException("Age must be less than 18 to open a Minor Account");
        }
        System.out.println("Your Minor Account is Created!");
    }
    @Override
    public void withdrawMoney(double amount)throws InvalidAmountException, InsufficientBalanceException, WithdrawalLimitException
    {
        if(amount<=0)
        {
            throw new InvalidAmountException("Please Enter Valid Amount");
        }
        if(amount>withdrawLimit){
                throw new WithdrawalLimitException("Withdraw Failed! Limit Exceeded");
        }
        if(amount>getUserBalance())
        {
            throw new InsufficientBalanceException("Oops! Insufficient Balance");
        }
        deductBalance(amount);
    }
}
