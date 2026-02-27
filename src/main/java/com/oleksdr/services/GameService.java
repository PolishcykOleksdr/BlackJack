package com.oleksdr.services;

import com.oleksdr.dto.Card;
import com.oleksdr.dto.GameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * author: user,
 * date: 27.02.2026
 */
public class GameService {
    public int countScore(List<Card> deck){
        int score = 0;
        for(Card card : deck){
            score += card.getRank().getCost();
        }

        if(deck.size() == 2 && isBlackJack(score)){
            score = 21;
        }
        return score;
    }
    private boolean isBlackJack(int score){
        return score == 22;
    }

    public List<Card> generateComputerDeck(Stack<Card> mainDeck) {
        List<Card> computerHand = new ArrayList<>();
        int numberOfCards = new Random().nextInt(2,6);
        for (int i = 0; i < numberOfCards; i++) {
            computerHand.add(mainDeck.pop());
        }
        return computerHand;
    }
    public GameResult getGameResult(int plScore, int cpScore){
        if(plScore > 21 && cpScore > 21){
            return GameResult.LOSE;
        } else if (cpScore > 21) {
            return GameResult.PLAYER;
        } else if (plScore > 21) {
            return GameResult.COMPUTER;
        } else if (plScore > cpScore) {
            return GameResult.PLAYER;
        } else if (cpScore > plScore) {
            return GameResult.COMPUTER;
        } else {
            return GameResult.DRAW;
        }
    }
}
