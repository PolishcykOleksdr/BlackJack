package com.oleksdr.dto;

import lombok.Getter;

/**
 * author: user,
 * date: 27.02.2026
 */
@Getter
public enum Rank {
    TWO("2",2),
    THREE("3",3),
    FOUR("4",4),
    FIVE("5",5),
    SIX("6",6),
    SEVEN("7",7),
    EIGHT("8",8),
    NINE("9",9),
    TEN("10",10),
    JACK("J",10),
    QUEEN("Q",10),
    KING("K",10),
    ACE("A",11);

    private final String name;
    private final int cost;

    Rank(String name, int number) {
        this.name = name;
        this.cost = number;
    }
}
