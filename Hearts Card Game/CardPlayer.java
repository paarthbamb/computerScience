import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/* authors: Paarth B*/

class CardPlayer extends Player {
    private ArrayList<Card> hand;
    private ArrayList<Card> takenCards;

    public CardPlayer(String name, int score, ArrayList<Card> hand) {
        super(name, score);
        this.hand = hand;
        this.takenCards = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getTakenCards() {
        return takenCards;
    }

    public void setTakenCards(ArrayList<Card> takenCards) {
        this.takenCards = takenCards;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card playCard(int index) {
        if (index >= 0 && index < hand.size()) {
            return hand.remove(index);
        }
        return null;
    }

    public Card chooseCard(ArrayList<Card> roundCards, ArrayList<Card> previousCards) {
        if (hand.isEmpty()) return null;
        
        for (Card card : hand) {
            if (card.getName().equals("2") && card.getSuit().equals("clubs")) {
                hand.remove(card);
                return card;
            }
        }
        
        Random rand = new Random();
        if (roundCards.isEmpty()) {
            return hand.remove(rand.nextInt(hand.size()));
        }
        
        String leadSuit = roundCards.get(0).getSuit();
        ArrayList<Card> sameSuit = new ArrayList<>();
        ArrayList<Card> hearts = new ArrayList<>();
        ArrayList<Card> others = new ArrayList<>();

        for (Card card : hand) {
            if (card.getSuit().equals(leadSuit)) {
                sameSuit.add(card);
            } else if (card.getSuit().equals("hearts")) {
                hearts.add(card);
            } else {
                others.add(card);
            }
        }

        if (!sameSuit.isEmpty()) {
            return hand.remove(hand.indexOf(sameSuit.get(rand.nextInt(sameSuit.size()))));
        } else if (!hearts.isEmpty()) {
            return hand.remove(hand.indexOf(hearts.get(rand.nextInt(hearts.size()))));
        } else {
            return hand.remove(hand.indexOf(others.get(rand.nextInt(others.size()))));
        }
    }

    @Override
    public String toString() {
        Collections.sort(hand);
        return super.toString() + " " + hand;
    }
}
