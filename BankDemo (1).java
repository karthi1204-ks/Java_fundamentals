abstract class BankAccount
{
    protected final String accountNumber;
    protected static double interestRate;

    
    public BankAccount(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }
    
    public static void setInterestRate(double rate) 
    {
        interestRate = rate;
    }

    
    public void displayDetails() 
    {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    
    public abstract void calculateInterest();
}


class SavingsAccount extends BankAccount 
{
    private double balance;

    public SavingsAccount(String accountNumber, double balance)
    {
        super(accountNumber);
        this.balance = balance;
    }

    public void calculateInterest()
    {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    public void displayAccount()
    {
        displayDetails();
        System.out.println("Balance: " + balance);
    }
}


public class BankDemo {
    public static void main(String[] args) 
    {
        BankAccount.setInterestRate(4.0);

        SavingsAccount account = new SavingsAccount("ACC123", 10000);

        System.out.println("Before Interest Calculation:");
        account.displayAccount();

        account.calculateInterest();

        System.out.println("\n After Interest Calculation:");
        account.displayAccount();
    }
} 

