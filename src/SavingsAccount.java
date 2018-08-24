//         Name: Madison Green
//    StudentID: 1211017974
//      Lecture: 10:30
//  Description: The Savings Account class is a child of the Bank Account class, and performs specific
//  functions respective to the nature of the type of bank account
public class SavingsAccount extends BankAccount{

    //Constructor
    public SavingsAccount(int balance, double interestRate, String accountNumber){
        super(balance, interestRate, accountNumber);
    }

    //Overriding the debit abstract method from bank account
    @Override
    public boolean debit(int amountInPennies){
        if(balanceInPennies-amountInPennies >= 0){
            balanceInPennies -= amountInPennies;
            return true;
        }
        return false;
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
        String toString = "\nAccount type\t:\tSavings" + super.toString() + "\n";
        return toString;
    }
}
