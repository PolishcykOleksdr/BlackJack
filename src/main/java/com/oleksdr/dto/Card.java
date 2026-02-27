package com.oleksdr.dto;

import lombok.Getter;

/**
 * author: user,
 * date: 27.02.2026
 */
@Getter
public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return suit.getSuit() + rank.getCost();
    }
}
