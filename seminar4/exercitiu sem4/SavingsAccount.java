public class SavingsAccount extends BankAccount
{
    private double interestRate;    //rata dobanzii
    public SavingsAccount(int accountNumber,double balance, double interestRate)
    {
        super(accountNumber,balance);
        this.interestRate=interestRate;
    }
    public double getInterestRate(){return interestRate;}
    public void addInterest()
    {
        double interest = getBalance() * interestRate;
    }
}
