abstract class BankAccount {

    private String accountNumber;
    protected double balance; 
    protected static double interestRate;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calculateInterest() {
        return (super.balance * interestRate) / 100;
    }
}

public class BankSystem {
    public static void main(String[] args) {

        
        BankAccount.setInterestRate(5.0);

        
        SavingsAccount savingsAccount = new SavingsAccount("12345", 1000.0);

        
        savingsAccount.displayAccountDetails();

        
        double interest = savingsAccount.calculateInterest();
        System.out.println("Calculated Interest: $" + interest);
    }
}
