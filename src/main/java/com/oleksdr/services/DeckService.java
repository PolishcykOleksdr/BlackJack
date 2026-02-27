package com.oleksdr.services;

import com.oleksdr.dto.Card;
import com.oleksdr.dto.Rank;
import com.oleksdr.dto.Suit;
import lombok.Getter;

import java.util.Collections;
import java.util.Stack;

/**
 * author: user,
 * date: 27.02.2026
 */
@Getter
public class DeckService {
    private final Stack<Card> mainDeck;

    public DeckService() {
        this.mainDeck = new Stack<>();
    }

    public void generateDeck() {
        for(Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                mainDeck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(mainDeck);
    }
}
