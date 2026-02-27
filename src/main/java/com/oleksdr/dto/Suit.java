package com.oleksdr.dto;

import lombok.Getter;

/**
 * author: user,
 * date: 27.02.2026
 */

@Getter
public enum Suit {
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    SPADES("♠");

    private final String suit;

    Suit(String suit) {
        this.suit = suit;
    }
}
