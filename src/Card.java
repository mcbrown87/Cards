import java.util.HashMap;

/**
 * Created by mbrown on 11/2/17.
 */
public class Card implements Comparable<Card> {
    public enum Suit {
        Hearts,
        Spades,
        Clubs,
        Diamonds
    }

    private static HashMap<Integer, String> faceCardMap;
    static {
        faceCardMap = new HashMap<>();
        faceCardMap.put(14, "Ace");
        faceCardMap.put(13, "King");
        faceCardMap.put(12, "Queen");
        faceCardMap.put(11, "Jack");
    }

    private Suit suit;
    private int rank;

    public Card(int rank) {
        this(Suit.Clubs, rank);
    }

    public Card(Suit suit, int rank) throws IllegalArgumentException {
        if(rank > 14 || rank < 2) {
            throw new IllegalArgumentException("Rank must be between 2 and 14");
        }

        if(suit == null) {
            throw new IllegalArgumentException("Suit must not be null");
        }

        this.suit = suit;
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank < 11 ? rank : faceCardMap.get(rank), suit.name().toLowerCase());
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }

        return compareTo((Card)o) == 0;
    }

    @Override
    public int compareTo(Card o) {
        if (this.getRank() ==  o.getRank())
            return 0;
        else if ((this.getRank()) > o.getRank())
            return 1;
        else
            return -1;
    }
}
