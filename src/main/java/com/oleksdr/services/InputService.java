package com.oleksdr.services;

import java.util.InputMismatchException;
import java.util.Scanner;

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
                if(e instanceof InputMismatchException){
                    System.out.println("Error: Incorrect input please try again");
                    sc.next();  // clean buffer
                }
                else{
                    System.out.printf("Error: %s%n",e.getMessage());
                }
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
            } catch (IllegalArgumentException e) {
                System.out.printf("Error: %s%n", e.getMessage());
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
            } catch (IllegalArgumentException e) {
                System.out.printf("Error: %s%n", e.getMessage());
            }
        }
    }
}
