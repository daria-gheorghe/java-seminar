public class BankAccount
{
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance)
    {
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public int getAccountNumber(){return accountNumber;}
    public double getBalance(){return balance;}

    public void deposit(double amount) throws InvalidAmountException
    {
        if(amount<=0)
            throw new InvalidAmountException("amount must be >0");
        balance+=amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException
    {
        if(amount<=0)
            throw new InvalidAmountException("amount must be >0");
        if(amount>balance)
            throw new InsufficientFundsException("not enough money");
        balance-=amount;
    }
}
