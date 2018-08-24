import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment5 {
    // Assignment #: 5
//         Name: Madison Green
//    StudentID: 1211017974
//      Lecture: 10:30
//  Description: The Assignment 5 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.
    public static void main (String[] args)
    {
        // ArrayList object is used to store account objects
        ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
        try
        {
            printMenu();     // print out menu

            // create a BufferedReader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader (System.in);
            BufferedReader stdin = new BufferedReader (isr);

            String line, inputInfo;
            boolean operation = false;
            char input1;
            do
            {
                System.out.println("What action would you like to perform?");
                line = stdin.readLine().trim();
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);

                if (line.length() == 1)
                {
                    switch (input1)
                    {
                        case 'A':   //Add BankAccount
                            System.out.print("Please enter some account information to add:\n");
                            inputInfo = stdin.readLine().trim();
                            accountList.add(BankAccountParser.parseStringToBankAccount(inputInfo));
                            break;
                        case 'C':   //Make Credit
                            System.out.print("Account number to make credit:\n");
                            String accountNumber = stdin.readLine().trim();
                            System.out.print("Amount (in pennies) to make credit:\n");
                            int amount = Integer.parseInt(stdin.readLine().trim());
                            //Getting the account based on the account number
                            BankAccount inUse = null;
                            for(BankAccount b: accountList){
                                if(b.getAccountNumber().equals(accountNumber)){
                                    inUse = b;
                                }
                            }
                            //Performing credit for bank account
                            operation = inUse != null && inUse.credit(amount);

                            //Resolving operation and printing corresponding message
                            if (operation)
                                System.out.print("credit performed\n");
                            else
                                System.out.print("credit not performed\n");
                            break;
                        case 'D':   //Make Debit
                            System.out.print("Account number to make debit:\n");
                            String accountNumber2 = stdin.readLine().trim();
                            System.out.print("Amount (in pennies) to make debit:\n");
                            int amount2 = Integer.parseInt(stdin.readLine().trim());

                            inUse = null;
                            for(BankAccount b: accountList){
                                if(b.getAccountNumber().equals(accountNumber2)){
                                    inUse = b;
                                }
                            }
                            //Performing credit for bank account
                            operation = inUse != null && inUse.debit(amount2);

                            if (operation)
                                System.out.print("debit performed\n");
                            else
                                System.out.print("debit not performed\n");
                            break;
                        case 'I':    //Apply Monthly Interest

                            //Applying interest
                            for(BankAccount b: accountList){
                                    b.applyInterest();
                            }
                            //Printing out success message
                            System.out.print("monthly interest applied\n");
                            break;
                        case 'L':   //List BankAccounts
                            if (accountList.size() != 0) {
                                for(int i = 0; i < accountList.size(); i++){
                                    System.out.println(accountList.get(i));
                                }
                            }
                            else{
                                System.out.println("no account\n");
                            }
                            break;
                        case 'Q':   //Quit
                            break;
                        case 'T':   //Transfer Fund
                            System.out.print("Account number to transfer funds FROM - \n");
                            String fromAccountNumber = stdin.readLine().trim();
                            System.out.print("Account number to transfer funds TO - \n");
                            String toAccountNumber = stdin.readLine().trim();
                            System.out.print("Amount (in pennies) to transfer:\n");
                            int amount3 = Integer.parseInt(stdin.readLine().trim());

                            BankAccount fromAccount = null, toAccount = null;

                            for(BankAccount b: accountList){
                                if(b.getAccountNumber().equals(fromAccountNumber)){
                                    fromAccount = b;
                                }
                                if(b.getAccountNumber().equals(toAccountNumber)){
                                    toAccount = b;
                                }
                            }

                            //If allowed, transfer amount and print success message
                            if (toAccount != null && fromAccount != null && fromAccount.getBalanceInPennies() >= amount3) {
                                fromAccount.debit(amount3);
                                toAccount.credit(amount3);
                                System.out.print("transfer performed\n");
                            }
                            else
                                System.out.println("*** transfer failed - Invalid account number or insufficient funds!");
                            break;
                        case '?':   //Display Menu
                            printMenu();
                            break;
                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                }
                else
                {
                    System.out.print("Unknown action\n");
                }
            } while (input1 != 'Q'); // stop the loop when Q is read
        }
        catch (IOException exception)
        {
            System.out.println("IO Exception");
        }
    }

    /** The method printMenu displays the menu to a use **/
    public static void printMenu()
    {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd BankAccount\n" +
                "C\t\tMake Credit\n" +
                "D\t\tMake Debit\n" +
                "I\t\tApply Monthly Interest\n" +
                "L\t\tList BankAccounts\n" +
                "Q\t\tQuit\n" +
                "T\t\tTransfer Fund\n" +
                "?\t\tDisplay Help\n\n");
    }

}

