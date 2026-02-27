package com.oleksdr;

import com.oleksdr.dto.Card;
import com.oleksdr.dto.Currency;
import com.oleksdr.dto.GameResult;
import com.oleksdr.entities.Player;
import com.oleksdr.services.DeckService;
import com.oleksdr.services.GameService;
import com.oleksdr.services.InputService;

import java.math.BigInteger;
import java.util.List;

/**
 * author: user,
 * date: 27.02.2026
 */
public class Main {
    static InputService inputService = new InputService();

    public static void main(String[] args) {
        System.out.println("Black Jack v 0.1\nHello user!");

        System.out.print("Please write number of games you want to play: ");
        int numberOfGames = inputService.getInputGames();

        System.out.print("Please write your nickname: ");
        String playerName = inputService.getInputName();

        System.out.print("Please write your balance: ");
        BigInteger amount = inputService.getInputMoneyAmount();

        System.out.println("Please write currency of your balance");
        Currency currency = inputService.getInputCurrency();

        System.out.printf("%s, number of your games is: %d%nYou balance is %d %s%nStart the game?%n",
                playerName, numberOfGames, amount, currency);

        if (inputService.getAnswer().equalsIgnoreCase("n")) return;

        startGame(numberOfGames, playerName, amount, currency);
    }

    private static void startGame(
            int numberOfGames,
            String playerName,
            BigInteger amount,
            Currency currency
    ) {
        Player player = new Player(playerName, amount, currency);
        while (player.getNumberOfGames() < numberOfGames) {
            player.incrementNumberOfGames();
            System.out.println("-------------------------->>>>>>>>");
            System.out.printf("Game: %d%n", player.getNumberOfGames());

            DeckService deckService = new DeckService();
            GameService gameService = new GameService();

            System.out.printf("Please write your bid (your balance is %d %s)%n",
                    player.getBalance().getMoneyAmount(),
                    player.getBalance().getCurrency()
            );
            BigInteger bid = inputService.getInputBid(player.getBalance().getMoneyAmount());
            player.getBalance().subtractMoney(bid);

            proceedGame(player, gameService, deckService);
            getGameResult(gameService, deckService, player, bid);

            if (player.getBalance().getMoneyAmount().compareTo(BigInteger.ZERO) <= 0) break;
        }
        System.out.println("-------------------------->>>>>>>>");
        System.out.println("Thanks for playing!!!");
        String str = player.toString();
        System.out.println(str);
    }

    private static void proceedGame(
            Player player,
            GameService gameService,
            DeckService deckService
    ) {
        deckService.generateDeck();

        player.clearPlayerHand();
        List<Card> playerHand = player.getPlayerHand();
        do {
            playerHand.add(deckService.getMainDeck().pop());
            int score = gameService.countScore(playerHand);
            System.out.printf("Player %s: %s%nTotal score: %s%n", player.getName(), playerHand, score);

            if (score < 21) {
                System.out.println("Next card?");
            } else {
                break;
            }
        } while (!inputService.getAnswer().equalsIgnoreCase("n"));
    }

    private static void getGameResult(
            GameService gameService,
            DeckService deckService,
            Player player,
            BigInteger bid
    ) {
        List<Card> computerHand = gameService.generateComputerDeck(deckService.getMainDeck());

        int playerScore = gameService.countScore(player.getPlayerHand());
        int computerScore = gameService.countScore(computerHand);

        System.out.println("-------------------------->>>>>>>>");
        System.out.println("RESULT");
        System.out.printf("Player %s: %s%nPlayer score: %s%n", player.getName(), player.getPlayerHand(), playerScore);
        System.out.printf("Computer: %s%nComputer score: %s%n", computerHand, computerScore);

        GameResult gameResult = gameService.getGameResult(playerScore, computerScore);
        System.out.println(gameResult.toString());

        if (gameResult == GameResult.PLAYER) {
            player.incrementNumberOfWins();
            player.getBalance().addMoney(bid.multiply(BigInteger.TWO));
        } else if (gameResult == GameResult.LOSE || gameResult == GameResult.COMPUTER) {
            player.getBalance().subtractMoney(bid);
        }
    }
}