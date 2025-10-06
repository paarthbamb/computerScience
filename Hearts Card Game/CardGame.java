/*
/ Authors:
/ P.Bamb
*/

import java.util.ArrayList;

public class CardGameEngine {
    private Deck cardDeck;
    private String gameTitle;
    private ArrayList<Player> playerList;
    private int totalPlayers;
    private int activePlayerIndex;

    public CardGameEngine(String gameTitle, int totalPlayers, String[] playerNames, int activePlayerIndex) {
        System.out.println(">>> Constructor Initialized");
        this.gameTitle = gameTitle;
        this.totalPlayers = totalPlayers;
        this.activePlayerIndex = activePlayerIndex;
        this.cardDeck = new Deck();
        this.playerList = new ArrayList<>();
        for (int i = 0; i < totalPlayers; i++) {
            playerList.add(new Player(playerNames[i], 0, new ArrayList<Card>()));
            System.out.println("Player " + playerNames[i] + " added to game");
        }
    }

    public Deck getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(Deck cardDeck) {
        this.cardDeck = cardDeck;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public int getActivePlayerIndex() {
        return activePlayerIndex;
    }

    public void setActivePlayerIndex(int activePlayerIndex) {
        this.activePlayerIndex = activePlayerIndex;
    }

    public Player getPlayerByIndex(int index) {
        return playerList.get(index);
    }

    public void distributeCards(int cardsPerPlayer, int playerIndex) {
        Player player = playerList.get(playerIndex);
        for (int i = 0; i < cardsPerPlayer; i++) {
            Card drawnCard = cardDeck.dealTopCard();
            if (drawnCard != null) {
                player.addCardToHand(drawnCard);
            }
        }
    }

    public void shuffleDeck() {
        cardDeck.shuffle();
    }

    public void startGame() {
        setStartingPlayer();
        ArrayList<Card> cardsPlayedInGame = new ArrayList<>();
        for (int round = 0; round < 13; round++) {
            ArrayList<Card> roundCards = new ArrayList<>();
            for (int i = 0; i < totalPlayers; i++) {
                int currentIndex = (activePlayerIndex + i) % totalPlayers;
                Player currentPlayer = playerList.get(currentIndex);
                Card chosenCard = currentPlayer.chooseCardToPlay(roundCards, cardsPlayedInGame);
                roundCards.add(chosenCard);
                cardsPlayedInGame.add(chosenCard);
            }
            validateRound(roundCards, activePlayerIndex);
            int roundWinnerIndex = determineRoundWinner(activePlayerIndex, roundCards);
            Player roundWinner = playerList.get(roundWinnerIndex);
            for (Card card : roundCards) {
                roundWinner.collectCard(card);
            }
            activePlayerIndex = roundWinnerIndex;
        }
        for (Player player : playerList) {
            int playerScore = calculateScore(player.getCollectedCards());
            player.setScore(playerScore);
        }
        System.out.print(">>> startGame()");
        for (Player player : playerList) {
            System.out.print(" " + player.getName() + "(" + player.getScore() + ")");
        }
        System.out.println();
    }

    public int determineRoundWinner(int startingPlayerIndex, ArrayList<Card> roundCards) {
        String leadingSuit = roundCards.get(0).getSuit();
        Card highestCard = roundCards.get(0);
        int winnerOffset = 0;
        for (int i = 1; i < roundCards.size(); i++) {
            Card currentCard = roundCards.get(i);
            if (currentCard.getSuit().equals(leadingSuit) && currentCard.getRank() > highestCard.getRank()) {
                highestCard = currentCard;
                winnerOffset = i;
            }
        }
        return (startingPlayerIndex + winnerOffset) % totalPlayers;
    }

    public int calculateScore(ArrayList<Card> collectedCards) {
        int score = 0;
        for (Card card : collectedCards) {
            if (card.getSuit().equals("hearts")) {
                score += 1;
            } else if (card.getSuit().equals("spades") && card.getName().equals("Q")) {
                score += 13;
            }
        }
        return score;
    }

    public void setStartingPlayer() {
        Card twoOfClubs = new Card("2", "clubs", 2);
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getHand().contains(twoOfClubs)) {
                activePlayerIndex = i;
                break;
            }
        }
    }

    public void validateRound(ArrayList<Card> roundCards, int startingPlayerIndex) {
        System.out.print(startingPlayerIndex + " ");
        String leadSuit = roundCards.get(0).getSuit();
        for (int i = 1; i < roundCards.size(); i++) {
            if (!roundCards.get(i).getSuit().equals(leadSuit)) {
                Player player = playerList.get((i + startingPlayerIndex) % roundCards.size());
                for (Card card : player.getHand()) {
                    if (card.getSuit().equals(leadSuit)) {
                        System.out.println("*** INVALID MOVE *** " + player.getName() + " played " 
                            + roundCards.get(i) + " in " + roundCards + " while holding " + player.getHand());
                        break;
                    }
                }
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("*** ").append(gameTitle).append(" ***\n");
        for (Player player : playerList) {
            builder.append(player).append("\n");
        }
        builder.append("Deck -> ").append(cardDeck.toString());
        return builder.toString();
    }
}
