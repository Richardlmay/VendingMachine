package com.techelevator.application;

import com.techelevator.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private List<Item> items = new ArrayList<>();    //changed to public;
    private Funds fund = new Funds();

    public void run() {

        File file = new File("vendingmachine.csv");

        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArr = line.split("\\|");

                String id = lineArr[0];
                String name = lineArr[1];
                double price = Double.parseDouble(lineArr[2]);
                String type = lineArr[3];
                int slot = Integer.parseInt(lineArr[4]);

                if (type.equals("Drink")) {
                    Beverage beverage = new Beverage(id, name, price, type, slot);
                    items.add(beverage);
                }
                if (type.equals("Candy")) {
                    Candy candy = new Candy(id, name, price, type, slot);
                    items.add(candy);
                }
                if (type.equals("Chip")) {
                    Chips chips = new Chips(id, name, price, type, slot);
                    items.add(chips);
                }
                if (type.equals("Gum")) {
                    Gum gum = new Gum(id, name, price, type, slot);
                    items.add(gum);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean keepRunning = true;

        do {
            String choice = UserInput.getHomeScreenOption();
            if (choice.equals("display")) {
                System.out.println("");
                for (Item item : items) {
                    System.out.println(item.getId() + " " + item.getName() + " " + item.getPrice() + " " + item.getType() + " " + item.getSlot());
                }
            } else if (choice.equals("purchase")) {
                handleLevel2();
            } else if (choice.equals("exit")) {
                keepRunning = false;
            }
        } while (keepRunning);
    }

    public void handleLevel2() {

        String choice = UserInput.getSecondLevelOption();
        if (choice.equals("feed")) {
            handleLevel3();

        } else if (choice.equals("select")) {

            for (Item item : items) {
                System.out.println(item.getId() + " " + item.getName() + " " + item.getPrice());
            }

            System.out.println("Please select item");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine();
            boolean found = false;

            for (Item item : items) {
                if (item.getId().equals(id)) {
                    found = true;

                    if (item.getSlot() != 0) {
                        if (fund.getCurrentMoneyProvided() >= item.getPrice()) {

                            System.out.println("this is item price " + item.getPrice());
                            double remainingMoney = fund.getCurrentMoneyProvided() - item.getPrice();
                            System.out.println(item.getName() + ", " + item.getPrice() + ",");
                            System.out.println("Remaining money " + remainingMoney);
                            fund.setCurrentMoneyProvided(remainingMoney);

                            if (item.getType().equals("Beverage")) {
                                System.out.println("Glug Glug,Yum!");
                            }
                            if (item.getType().equals("Candy")) {
                                System.out.println("Munch Munch, Yum!");
                            }
                            if (item.getType().equals("Chips")) {
                                System.out.println("Crunch Crunch, Yum!");
                            }
                            if (item.getType().equals("Gum")) {
                                System.out.println("Chew Chew, Yum!");
                            }

                            int quantity = item.getSlot();
                            quantity--;
                            item.setSlot(quantity);
                        }
                    } else {
                        System.out.println("SOLD OUT");
                    }
                    break;
                }

            }

            if (!found) {
                System.out.println("Invalid Product Option");
            }
        }

        else if (choice.equals("finish")) {
            double startingBalance = fund.getCurrentMoneyProvided();

            String change = fund.changeGiven(fund.getCurrentMoneyProvided());

            double endingBalance = fund.getCurrentMoneyProvided();

            System.out.println(change);
            FileLogger.log("Purchased thing: $"+startingBalance+" $"+endingBalance);



        }
    }

    public void handleLevel3() {

        boolean keepRunning = true;
        double startingBalance = fund.getCurrentMoneyProvided();
        do {
            String choice = UserInput.dollarBill(); // how to return change in int format
            if (choice.equals("1")) {
                System.out.println("add 1");
                fund.addMoney(1.0);
            } else if (choice.equals("2")) {
                System.out.println("add 2");
                fund.addMoney(2.0);
            } else if (choice.equals("3")) {
                System.out.println("add 5");
                fund.addMoney(5.0);
            } else if (choice.equals("4")) {
                System.out.println("add 10.0");
                fund.addMoney(10.0);
            } else if (choice.equals("finish")) {
                keepRunning = false;
            }
        } while (keepRunning);

        double endingBalance = fund.getCurrentMoneyProvided();

        FileLogger.log("FEED money: $"+startingBalance+" $"+endingBalance);
    }
}

