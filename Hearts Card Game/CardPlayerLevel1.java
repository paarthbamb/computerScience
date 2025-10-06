import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class CardPlayerLevel1 extends CardPlayer {
    public CardPlayerLevel1() {
        super("", 0, new ArrayList<>());
    }

    public CardPlayerLevel1(String name, int score, ArrayList<Card> hand) {
        super(name, score, hand);
    }

    @Override
    public Card chooseCard(ArrayList<Card> roundCards, ArrayList<Card> previousCards) {
        if (getHand().isEmpty()) return null;
        
        Random rand = new Random();
        if (roundCards.isEmpty()) {
            return getHand().remove(rand.nextInt(getHand().size()));
        }
        
        String leadSuit = roundCards.get(0).getSuit();
        ArrayList<Card> sameSuit = new ArrayList<>();
        ArrayList<Card> hearts = new ArrayList<>();
        ArrayList<Card> others = new ArrayList<>();
        Card queenOfSpades = null;

        for (Card card : getHand()) {
            if (card.getSuit().equals(leadSuit)) {
                sameSuit.add(card);
            } else if (card.getSuit().equals("hearts")) {
                hearts.add(card);
            } else if (card.getName().equals("Q") && card.getSuit().equals("spades")) {
                queenOfSpades = card;
            } else {
                others.add(card);
            }
        }

        if (!sameSuit.isEmpty()) {
            return getHand().remove(getHand().indexOf(sameSuit.get(rand.nextInt(sameSuit.size()))));
        } else if (queenOfSpades != null) {
            getHand().remove(queenOfSpades);
            return queenOfSpades;
        } else if (!hearts.isEmpty()) {
            return getHand().remove(getHand().indexOf(Collections.max(hearts, Card::compareTo)));
        } else {
            return getHand().remove(getHand().indexOf(others.get(rand.nextInt(others.size()))));
        }
    }
}


