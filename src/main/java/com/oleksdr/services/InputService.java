package com.oleksdr.services;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.oleksdr.dto.Currency;

/**
 * author: user,
 * date: 27.02.2026
 */
public class InputService {
    private final Scanner sc;

    public InputService() {
        this.sc = new Scanner(System.in);
    }

    public int getInputGames(){
        while(true){
            try {
                int numberOfGames = sc.nextInt();

                if(numberOfGames < 1){
                    throw new IllegalArgumentException("Sorry but number of games cannot be less than zero");
                }
                return numberOfGames;
            }catch (IllegalArgumentException | InputMismatchException e){
                printException(e);
            }
        }
    }
    public String getInputName(){
        while(true) {
            try {
                String playerName = sc.next();
                if (playerName.isEmpty()) {
                    throw new IllegalArgumentException("Player name cannot be empty");
                }
                return playerName;
            } catch (IllegalArgumentException | InputMismatchException e) {
                printException(e);
            }
        }
    }

    public String getAnswer() {
        while(true){
            try {
                System.out.print("[Y/N]: ");
                String ans = sc.next();
                if (ans.isEmpty()) {
                    throw new IllegalArgumentException("Answer cannot be empty");
                }
                if(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")){
                    throw new IllegalArgumentException("Illegal answer ");
                }
                return ans;
            } catch (IllegalArgumentException | InputMismatchException e) {
                printException(e);
            }
        }
    }

    public BigInteger getInputMoneyAmount() {
        while (true){
            try{
                BigInteger amount = sc.nextBigInteger();
                if(amount.signum() <= 0){
                    throw new IllegalArgumentException("You cannot put amount less than zero");
                }
                return amount;
            }catch (IllegalArgumentException | InputMismatchException e){
                printException(e);
            }
        }
    }

    public BigInteger getInputBid(BigInteger maxBalance) {
        while (true){
            try{
                BigInteger amount = sc.nextBigInteger();
                if(amount.signum() <= 0){
                    throw new IllegalArgumentException("You cannot put amount less than zero");
                }
                if(amount.compareTo(maxBalance) > 0){
                    throw new IllegalArgumentException("You don`t have enough money");
                }
                return amount;
            }catch (IllegalArgumentException | InputMismatchException e){
                printException(e);
            }
        }
    }

    public Currency getInputCurrency() {
        while (true){
            try{
                System.out.printf("Currency list:%n%s:", Arrays.toString(Currency.values()));
                String currencyToPick = sc.next();
                for (Currency value : Currency.values()) {
                    if(value.toString().equalsIgnoreCase(currencyToPick)){
                        return value;
                    }
                }
                throw new IllegalArgumentException("No currency with name " + currencyToPick);
            }catch (IllegalArgumentException | InputMismatchException e){
                printException(e);
            }
        }
    }
    private void printException(Exception e){
        if (e == null) {
            return;
        }

        if(e instanceof InputMismatchException){
            System.out.println("Error: Incorrect input please try again");
            sc.next();
        }
        else{
            System.out.printf("Error: %s%n", e.getMessage());
        }
        System.out.print("Try again: ");
    }
}
