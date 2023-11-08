import java.util.Scanner;

class BankAccount{
    private int balance;

    public BankAccount(int initialAmount){
        this.balance = initialAmount;
    }

    public int balance(){
        return balance;
    }

    public void deposit(int amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Deposit of " + amount + "Rs was successfull");
        } else {
            System.out.println("Invalid entry!. Please choose a number above 0");
        }
    }

    public void withdraw(int amount){
        if (amount > 0 && amount <= balance){
            System.out.println("Withdraw successfull of "+amount+"Rs");
            amount -= balance;
        } else {
            System.out.println("Invaid entry!!.Insuffucient balance or negative value entered");
        }
    }
}

class ATM{

    private BankAccount account;
    public ATM(BankAccount account){
        this.account = account;
    }

    public void display(){
        System.out.println("Select Options");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Leave");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            display();
            System.out.println("Pick an option");
            option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter amount to deposit");
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw");
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance " + account.balance());
                    break;
                case 4:
                    System.out.println("Thanks for working with Pratik Bank");
                    break;
                default:
                    System.out.println("Invalid entry!!. Enter only the given options");
            }
        }while (option != 4);
        sc.close();;
    }
}

public class Main {

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(30000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
