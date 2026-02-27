package com.oleksdr.entities;

import com.oleksdr.dto.Card;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * author: user,
 * date: 27.02.2026
 */
@Getter
public class Player {
    private final String name;
    private final List<Card> playerHand;
    private int numberOfGames;
    private int numberOfWins;

    public Player(String name) {
        this.name = name;
        this.playerHand = new ArrayList<>();
    }

    public void clearPlayerHand() {
        playerHand.clear();
    }
    public void incrementNumberOfGames(){
        numberOfGames++;
    }
    public void incrementNumberOfWins(){
        numberOfWins++;
    }
}
