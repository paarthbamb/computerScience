/*
 * Authors:
 * P. Bamb
 */

import java.util.ArrayList;

public class CardGame {
    private Deck deckOfCards;
    private String nameOfGame;
    private ArrayList<CardPlayer> players;
    private int numberOfPlayers;
    private int currentPlayer;

    public CardGame(String nameOfGame, int numberOfPlayers, String[] playerNames, int currentPlayer) {
        System.out.println(">>> Printed in Constructor");
        this.nameOfGame = nameOfGame;
        this.numberOfPlayers = numberOfPlayers;
        this.currentPlayer = currentPlayer;
        this.deckOfCards = new Deck();
        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new CardPlayer(playerNames[i], 0, new ArrayList<Card>()));
            System.out.println("Player " + playerNames[i] + " is a CardPlayer");
        }
    }

    public Deck getDeckOfCards() {
        return deckOfCards;
    }
    public void setDeckOfCards(Deck deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public String getNameOfGame() {
        return nameOfGame;
    }
    public void setNameOfGame(String nameOfGame) {
        this.nameOfGame = nameOfGame;
    }

    public ArrayList<CardPlayer> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<CardPlayer> players) {
        this.players = players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public CardPlayer getPlayer(int i) {
        return players.get(i);
    }

    public void deal(int numCards, int playerIndex) {
        CardPlayer player = players.get(playerIndex);
        for (int i = 0; i < numCards; i++) {
            Card c = deckOfCards.dealTopCard();
            if (c != null) {
                player.addCard(c);
            }
        }
    }

    public void shuffle() {
        deckOfCards.shuffle();
    }

    public void playGame() {
        setCurrentPlayerToStartingPlayer();
        ArrayList<Card> gamePlayedCards = new ArrayList<>();
        for (int roundNum = 0; roundNum < 13; roundNum++) {
            ArrayList<Card> roundCards = new ArrayList<>();
            for (int i = 0; i < numberOfPlayers; i++) {
                int playerIndex = (currentPlayer + i) % numberOfPlayers;
                CardPlayer player = players.get(playerIndex);
                Card chosen = player.chooseCard(roundCards, gamePlayedCards);
                roundCards.add(chosen);
                gamePlayedCards.add(chosen);
            }
            checkRound(roundCards, currentPlayer);
            int winner = takeRound(currentPlayer, roundCards);
            CardPlayer winningPlayer = players.get(winner);
            for (Card c : roundCards) {
                winningPlayer.getTakenCards().add(c);
            }
            currentPlayer = winner;
        }
        for (CardPlayer p : players) {
            int roundScore = score4Game(p.getTakenCards());
            p.setScore(roundScore);
        }
        System.out.print(">>> playGame()");
        for (CardPlayer p : players) {
            System.out.print(" " + p.getName() + "(" + p.getScore() + ")");
        }
        System.out.println();
    }

    public int takeRound(int startingPlayer, ArrayList<Card> round) {
        String leadSuit = round.get(0).getSuit();
        Card winningCard = round.get(0);
        int winningIndex = 0;
        for (int i = 1; i < round.size(); i++) {
            Card currentCard = round.get(i);
            if (currentCard.getSuit().equals(leadSuit)) {
                if (currentCard.getRank() > winningCard.getRank()) {
                    winningCard = currentCard;
                    winningIndex = i;
                }
            }
        }
        return (startingPlayer + winningIndex) % numberOfPlayers;
    }

    public int score4Game(ArrayList<Card> takenCards) {
        int score = 0;
        for (Card c : takenCards) {
            if (c.getSuit().equals("hearts")) {
                score += 1;
            } else if (c.getSuit().equals("spades") && c.getName().equals("Q")) {
                score += 13;
            }
        }
        return score;
    }

    public void setCurrentPlayerToStartingPlayer() {
        Card twoOfClubs = new Card("2", "clubs", 2);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getHand().contains(twoOfClubs)) {
                currentPlayer = i;
                break;
            }
        }
    }

    public void checkRound(ArrayList<Card> round, int startingPlayer) {
        System.out.print(startingPlayer + " ");
        String roundSuit = round.get(0).getSuit();
        for (int i = 1; i < round.size(); i++) {
            if (!round.get(i).getSuit().equals(roundSuit)) {
                CardPlayer player = players.get((i + startingPlayer) % round.size());
                for (Card c : player.getHand()) {
                    if (c.getSuit().equals(roundSuit)) {
                        System.out.println("*** INCORRECT ***" + player.getName() + " playing " 
                            + round.get(i) + " in " + round + " while having " + player.getHand());
                        break;
                    }
                }
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***").append(nameOfGame).append("***\n");
        for (CardPlayer p : players) {
            sb.append(p).append("\n");
        }
        sb.append("deck -> ").append(deckOfCards.toString());
        return sb.toString();
    }
}


