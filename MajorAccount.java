public class MajorAccount extends  Account
{
    MajorAccount(String userName, int userAge, double userBalance)throws InvalidUserNameException, InvalidAgeException, InvalidAmountException
    {
        super(userName, userAge, userBalance);
        if(userAge<18)
        {
            throw new InvalidAgeException("Age must be at least 18 to open a Major Account");
        }
        System.out.println("Your Major Account is Created!");
    }
    @Override
    public void withdrawMoney(double amount)throws InvalidAmountException, InsufficientBalanceException
    {
        if(amount<=0)
        {
            throw new InvalidAmountException("Please Enter Valid Amount");
        }
        if(amount>getUserBalance())
        {
            throw new InsufficientBalanceException("Oops! Insufficient Balance");
        }

        deductBalance(amount);
    }
}
