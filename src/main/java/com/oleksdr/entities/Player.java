package com.oleksdr.entities;

import com.oleksdr.dto.Balance;
import com.oleksdr.dto.Card;
import com.oleksdr.dto.Currency;
import lombok.Getter;

import java.math.BigInteger;
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

    private final Balance balance;

    private int numberOfGames;
    private int numberOfWins;

    public Player(String name, BigInteger amount, Currency currency) {
        this.name = name;
        this.balance = new Balance(amount, currency);
        this.playerHand = new ArrayList<>();
    }

    public void clearPlayerHand() {
        playerHand.clear();
    }

    public void incrementNumberOfGames() {
        numberOfGames++;
    }

    public void incrementNumberOfWins() {
        numberOfWins++;
    }

    @Override
    public String toString() {
        return String.format(
                "Player %s:%n"+
                "MoneyAmount %d %s:%n" +
                "NumberOfGames: %d,%n" +
                "NumberOfWins: %d,%n" +
                "NumberOfLoses: %d,%n" +
                "Winrate: %.2f%%",
                name,
                balance.getMoneyAmount().intValue(),
                balance.getCurrency(),
                numberOfGames,
                numberOfWins,
                numberOfGames - numberOfWins,
                ((float) numberOfWins / numberOfGames) * 100
        );
    }
}
