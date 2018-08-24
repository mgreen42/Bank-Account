import java.text.DecimalFormat;

//         Name: Madison Green
//    StudentID: 1211017974
//      Lecture: 10:30
//  Description: The Bank Account is the abstract class that holds the framework for the child classes,
//  including savings, checking and credit card bank accounts
public abstract class BankAccount {
    //The balance of the bank account in pennies
    protected int balanceInPennies;
    //The interest rate of the bank account
    protected double interestRate;
    //The number/ID of the bank account
    protected String accountNumber;

    //Default constructor for Bank Account
    public BankAccount(){
        this.balanceInPennies = 0;
        this.interestRate = 0.0;
        this.accountNumber = "";
    }

    //Normal constructor for bank account
    public BankAccount(int balanceInPennies, double interestRate, String accountNumber){
        this.balanceInPennies = balanceInPennies;
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
    }

    //Return account number
    public String getAccountNumber() {
        return accountNumber;
    }

    //Set account number
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //REturn interest rate
    public double getInterestRate() {
        return interestRate;
    }

    //Set interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    //Get balance in pennies
    public int getBalanceInPennies() {
        return balanceInPennies;
    }

    //Add amount to bank account
    public boolean credit(int amountPennies){
        if(amountPennies >= 0){
            balanceInPennies += amountPennies;
            return true;
        }
        return false;
    }

    //Set balance in pennies
    public void setBalanceInPennies(int balanceInPennies) {
        this.balanceInPennies = balanceInPennies;
    }

    //Create abstract method for debit of bank account
    public abstract boolean debit(int amountPennies);

    //Create abstract method to apply interest to bank account
    public abstract void applyInterest();

    //toString method that returns a string of account information
    public String toString(){
        DecimalFormat df = new DecimalFormat("#0.00");
        double balanceInDollars = (double)balanceInPennies/100;
        String toString = "\nAccount ID\t:\t" + accountNumber + "\nBalance\t\t:\t" + String.format("%.2f", balanceInDollars) + "\nInterest rate\t:\t" + df.format(interestRate);
        return toString;
    }
}
