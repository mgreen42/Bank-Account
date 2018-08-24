//         Name: Madison Green
//    StudentID: 1211017974
//      Lecture: 10:30
//  Description: The Bank Parser class takes a line of input form the user, determines the type of bank account, and
//    creates a new bank account of the correct class to add to the accountList in the main class
import java.util.Scanner;

public class BankAccountParser {


    //This method takes a string of information and turns it into a bank account of the correct type, then return it to the main method
    public static BankAccount parseStringToBankAccount(String line){
        BankAccount nextAccount = null;
        Scanner scan = new Scanner(line).useDelimiter("/");
        String type = scan.next();
        String accNumber = scan.next();
        double interestNumber = Double.parseDouble(scan.next());
        int balanceInPennies = Integer.parseInt(scan.next());
        //Create an account of the correct type
        switch (type){
            case "SA":
                nextAccount = new SavingsAccount(balanceInPennies, interestNumber, accNumber);
                break;
            case "CH":
                int overDraftFee = Integer.parseInt(scan.next());
                nextAccount = new CheckingAccount(balanceInPennies, interestNumber, accNumber, overDraftFee);
                break;
            case "CR":
                int creditLimit = Integer.parseInt(scan.next());
                nextAccount = new CreditcardAccount(balanceInPennies, interestNumber, accNumber, creditLimit);
                break;
        }
        return nextAccount;
    }
}
