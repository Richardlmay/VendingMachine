package com.techelevator;

import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("1")) {
            return "display";
        } else if (option.equals("2")) {
            return "purchase";
        } else if (option.equals("3")) {
            return "exit";
        } else {
            return "";
        }


    }
        public static String getSecondLevelOption() {




            System.out.println(("(1) Feed Money"));
            System.out.println(("(2) Select Product"));
            System.out.println(("(3) Finish Transaction"));

            System.out.println();
            System.out.print("Please select an item: ");

            String picOption = scanner.nextLine();
            String option = picOption.trim().toLowerCase();

            if (option.equals("1")) {
                return "feed";
            } else if (option.equals("2")) {
                return "select";
            } else if (option.equals("3")) {
                return "finish";
            } else {
                return "";
            }
        }


        public static String dollarBill() {
            System.out.println("1) $1");
            System.out.println("2) $2");
            System.out.println("3) $5");
            System.out.println("4) $10");
            System.out.println("5) Back");

            System.out.println();
            System.out.print("Please select an option: ");

            String picOption = scanner.nextLine();
            String option = picOption.trim().toLowerCase();

            if (option.equals("1")) {
                return "1";
            } else if (option.equals("2")) {
                return "2";
            } else if (option.equals("3")) {
                return "3";
            } else if (option.equals("4")) {
                return "4";
            } else if (option.equals("5")) {
                return "finish";
            } else {
                return "";
            }
        }


}