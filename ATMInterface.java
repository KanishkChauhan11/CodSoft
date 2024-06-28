import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to set the initial balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to return the current balance of the account
    public double getBalance() {
        return balance;
    }

    // Method to add amount to the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid Input, please try again later");
        }
    }

    // Method to withdraw a specified amount from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            return true;
        } else {
            System.out.println("Withdrawal failed due to insufficient funds or invalid amount.");
            return false;
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000.0); // Initializing  the balance with $1000

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Please select an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: $" + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawalAmount = scanner.nextDouble();
                    if (userAccount.withdraw(withdrawalAmount)) {
                        System.out.println("Updated balance: $" + userAccount.getBalance());
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
