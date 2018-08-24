import java.text.DecimalFormat;

//         Name: Madison Green
//    StudentID: 1211017974
//      Lecture: 10:30
//  Description: The Checking Account class is a child of the Bank Account class, and performs specific
//  functions respective to the nature of the type of bank account
public class CheckingAccount extends BankAccount{

    private int overdraftFeePennies;

    public CheckingAccount(int balance, double interestRate, String accountNumber, int overdraftFeePennies){
        super(balance, interestRate, accountNumber);
        this.overdraftFeePennies = overdraftFeePennies;
    }

    //Overriding the debit abstract method from bank account
    @Override
    public boolean debit(int amountInPennies){
        if(balanceInPennies-amountInPennies >= 0){
            balanceInPennies -= amountInPennies;
            return true;
        }
        else{
            balanceInPennies -= (overdraftFeePennies + amountInPennies);
            return false;
        }
    }

    //Overriding the apply interest abstract method from bank account
    @Override
    public void applyInterest() {
        if(balanceInPennies >= 0){
            balanceInPennies += (int)(balanceInPennies * interestRate);
        }
    }

    //Calling and adding account type toString method of bank account
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        String toString = "\nAccount type\t:\tChecking" + super.toString() + "\nOverdraft fee\t:\t" + String.format("%.2f", (double)overdraftFeePennies/100) + "\n";
        return toString;
    }
}
