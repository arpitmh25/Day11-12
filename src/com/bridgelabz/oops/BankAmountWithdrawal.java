package com.bridgelabz.oops;

import java.util.Scanner;

class Bank {
    private String accountNumber;
    private String name;
    private long balance;

    Scanner scanner = new Scanner(System.in);


    void accountDetails() {
        System.out.print("Enter Account No: ");
        accountNumber = scanner.next();
        System.out.print("Enter Name: ");
        name = scanner.next();
        System.out.print("Enter Balance: ");
        balance = scanner.nextLong();

    }


    void showAccount() {
        System.out.println(accountNumber + "," + name + "," + balance);
    }


    void accountDeposit() {
        long amount;
        System.out.println("Enter Amount U Want to Deposit : ");
        amount = scanner.nextLong();
        balance = balance + amount;
    }


    void accountWithdrawal() {
        long amount;
        System.out.println("Enter Amount U Want to withdraw : ");
        amount = scanner.nextLong();
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }


    boolean search(String account) {
        if (accountNumber.equals(account)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class BankAmountWithdrawal {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("How Many Customer U Want to Input : ");
        int n = scanner.nextInt();
        Bank sbi[] = new Bank[n];
        for (int i = 0; i < sbi.length; i++) {
            sbi[i] = new Bank();
            sbi[i].accountDetails();
        }


        int details;
        do {
            System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.Exit ");
            System.out.println("Ur Choice :");
            details = scanner.nextInt();
            switch (details) {
                case 1:
                    for (int i = 0; i < sbi.length; i++) {
                        sbi[i].showAccount();
                    }
                    break;

                case 2:
                    System.out.print("Enter Account No U Want to Search...: ");
                    String account = scanner.next();
                    boolean found = false;
                    for (int i = 0; i < sbi.length; i++) {
                        found = sbi[i].search(account);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account No : ");
                    account = scanner.next();
                    found = false;
                    for (int i = 0; i < sbi.length; i++) {
                        found = sbi[i].search(account);
                        if (found) {
                            sbi[i].accountDeposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account No : ");
                    account = scanner.next();
                    found = false;
                    for (int i = 0; i < sbi.length; i++) {
                        found = sbi[i].search(account);
                        if (found) {
                            sbi[i].accountWithdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 5:
                    System.out.println("Good Bye..");
                    break;
            }
        }
        while (details != 5);
    }

}