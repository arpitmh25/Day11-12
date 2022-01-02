package com.bridgelabz.oops;


import java.util.ArrayList;
import java.util.Scanner;

public class StockAccountManagement {
    public static int noOfStocks = 0;
    public static double totalValue = 0;

    static class stockPortfolio {
        ArrayList<stockPortfolio.stock> portfolio = new ArrayList<stockPortfolio.stock>();

        public class stock {
            int NoOfShare;
            String company;
            double price;
        }

        public double totalValue() {
            for (int i = 0; i < portfolio.size(); i++) {
                totalValue += portfolio.get(i).price * portfolio.get(i).NoOfShare;
            }
            return totalValue;
        }
    }

    public static void main(String[] args) {
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        stockPortfolio read = new stockPortfolio();
        while (input == 0) {
            System.out.println("Enter the details of Stock ");
            stockPortfolio.stock value = read.new stock();
            System.out.println("Enter Company Name:");
            value.company = scanner.nextLine();
            System.out.println("Enter number of share:");
            value.NoOfShare = scanner.nextInt();
            System.out.println("Enter Price of share:");
            value.price = scanner.nextDouble();

            read.portfolio.add(value);
            System.out.println("Do you want to add more Stocks? enter 1 for YES or 2for NO!");
            input = scanner.nextInt();
            for (int i = 0; i < read.portfolio.size(); i++) {
                System.out.println(read.totalValue());

            }
        }

        }
    }