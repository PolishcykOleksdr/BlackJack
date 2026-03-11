package com.oleksdr.dto;

/**
 * author: user,
 * date: 27.02.2026
 */
public record Card(Suit suit, Rank rank) {
    @Override
    public String toString() {
        return suit.getSuit() + rank.getCost();
    }
}
