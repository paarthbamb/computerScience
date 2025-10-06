import java.util.*;

public class Deck {
    private ArrayList<Card> cards;
    

    public Deck() {
        cards = new ArrayList<>();

        String[] suits = {"diamonds", "hearts", "spades", "clubs"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(ranks[i], suit, values[i]));
            }
        }
    }
    

    public ArrayList<Card> getDeck() {
        return new ArrayList<>(this.cards);
    }
    

    public void shuffle() {
        Collections.shuffle(cards);
    }
    

    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            return null;
        }
    }
    

    public int cardsRemaining() {
        return cards.size();
    }
    
    @Override
    public String toString() {
        return cards.toString();
    }
}

