package com.techelevator;

import com.techelevator.application.VendingMachine;

import java.util.List;
import java.util.Scanner;

public class Funds {

    private double currentMoneyProvided;
    private double moneyEarned;


        public int subtract() {
            return 0;
        }

        public void dispence() {

        }

        public void addMoney ( double amount){
            this.currentMoneyProvided = this.currentMoneyProvided + amount;
        }
        public int giveChange () {
            return 0;
        }

        public double getCurrentMoneyProvided() {
            return currentMoneyProvided;
        }

    public void setCurrentMoneyProvided(double currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

        public String changeGiven(double change) {

        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int pennies = 0;
        int changeAmount;

        int quarterCounter = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;
        int pennyCounter = 0;

        int equivelantValue = 0;
        int remainingChange = 0;
        int secondChange = 0;
        int thirdChange = 0;

        String StQuarterCounter = Integer.toString(quarterCounter);

        int changeInPennies = (int)(change * 100);

        if(changeInPennies >= quarter) {
            quarterCounter = changeInPennies / quarter;
            equivelantValue = quarterCounter * 25;
            remainingChange = changeInPennies - equivelantValue;
        } if (changeInPennies >= dime) {
            dimeCounter = remainingChange / dime;
            equivelantValue = dimeCounter * 10;
            secondChange = remainingChange - equivelantValue;
        } if (changeInPennies >= nickel) {
            nickelCounter = secondChange / nickel;
            equivelantValue = nickelCounter * 5;
            pennies = secondChange - equivelantValue;
        }

            return ("Quarters- "+quarterCounter+"\nDimes- "+dimeCounter+"\nNickels- "+nickelCounter+"\nPenny- "+pennies);
//            return (StQuarterCounter);
        }






}
