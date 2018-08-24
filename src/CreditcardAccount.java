//         Name: Madison Green
//    StudentID: 1211017974
//      Lecture: 10:30
//  Description: The Creditcard Account class is a child of the Bank Account class, and performs specific
//  functions respective to the nature of the type of bank account
public class CreditcardAccount extends BankAccount{

    private int creditLimitPennies;

    //Constructor for credit card account
    public CreditcardAccount(int balance, double interestRate, String accountNumber, int creditCardLimit){
        super(balance, interestRate, accountNumber);
        creditLimitPennies = creditCardLimit;
    }

    //Overriding the debit abstract method from bank account
    @Override
    public boolean debit(int amountInPennies){
        if((balanceInPennies-amountInPennies) >= (creditLimitPennies*-1)){
            balanceInPennies -= amountInPennies;
            return true;
        }
        return false;
    }

    //Overriding the apply interest abstract method from bank account
    @Override
    public void applyInterest() {
        if(balanceInPennies < 0){
            balanceInPennies += (int)(balanceInPennies * interestRate);
        }
    }

    //Calling and adding account type toString method of bank account
    public String toString(){
        String toString = "\nAccount type\t:\tCreditcard" + super.toString() + "\nCredit limit\t:\t" + String.format("%.2f", (double)creditLimitPennies/100) + "\n";
        return toString;
    }
}
