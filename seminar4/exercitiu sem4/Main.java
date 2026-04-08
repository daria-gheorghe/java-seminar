//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        BankAccount acc1=new BankAccount(1, 1000);
        SavingsAccount acc2=new SavingsAccount(2,2000,0.05);

        try{
            acc1.deposit(500);
            acc1.deposit(-100);
        }
        catch(InvalidAmountException e)
        {
            System.out.println("deposit error: "+ e.getMessage());
        }

        try{
            acc1.withdraw(300);
            acc1.withdraw(5000);
        }
        catch(InvalidAmountException e)
        {
            System.out.println("withdraw error: "+ e.getMessage());
        }
        catch(InsufficientFundsException e)
        {
            System.out.println("withdraw error: " +e.getMessage());
        }

        acc2.addInterest();
        System.out.println("Final balance acc1: " + acc1.getBalance());
        System.out.println("Final balance acc2: " + acc2.getBalance());
    }
}