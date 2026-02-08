package atmmachine.java;

import java.util.Scanner;

class Account {
    private double balance = 5000.0;
    private final int pin = 1234;

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Successfully withdrawn: $" + amount);
        } else {
            System.out.println("❌ Insufficient funds or invalid amount.");
        }
    }
}

public class ATMMachineJava {
    public static void main(String[] args) {
        Account myAccount = new Account();
        Scanner scanner = new Scanner(System.in);

        System.out.println("********** WELCOME TO JAVA ATM **********");
        System.out.print("Please enter your PIN: ");
        
        if (scanner.hasNextInt()) {
            int enteredPin = scanner.nextInt();
            if (myAccount.validatePin(enteredPin)) {
                boolean exit = false;
                while (!exit) {
                    System.out.println("\n--- ATM MENU ---");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit Money");
                    System.out.println("3. Withdraw Money");
                    System.out.println("4. Exit");
                    System.out.print("Choose option: ");
                    
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> System.out.println("Current Balance: $" + myAccount.getBalance());
                        case 2 -> {
                            System.out.print("Enter amount to deposit: ");
                            myAccount.deposit(scanner.nextDouble());
                        }
                        case 3 -> {
                            System.out.print("Enter amount to withdraw: ");
                            myAccount.withdraw(scanner.nextDouble());
                        }
                        case 4 -> {
                            System.out.println("Thank you for using the ATM. Goodbye!");
                            exit = true;
                        }
                        default -> System.out.println("Invalid Option.");
                    }
                }
            } else {
                System.out.println("❌ Incorrect PIN. Access Denied.");
            }
        }
        scanner.close();
    }
}