import java.util.*;

public class Card implements Comparable<Object> {
    private String rank;
    private String suit;
    private int value;

    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit.toLowerCase();
        this.value = value;
    }

    public String getName() {
        return this.rank;
    }

    public String getRank() {
        return this.rank;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit.toLowerCase();
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card other = (Card) o;
        return this.rank.equals(other.rank) && this.suit.equals(other.suit) && this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit, value);
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass())
            throw new IllegalArgumentException("Invalid object for comparison.");
        Card other = (Card) o;

        if (!this.suit.equals(other.suit)) {
            return this.suit.compareTo(other.suit);
        } else {
            return Integer.compare(this.value, other.value);
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit + " (" + value + ")";
    }

    public static void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
        Set<Card> uniqueCards = new HashSet<>(deck);
        if (uniqueCards.size() != deck.size()) {
            throw new IllegalStateException("Duplicate cards found after shuffling.");
        }
    }
}
