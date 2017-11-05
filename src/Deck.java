import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        } else {
            return cards.remove(0);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public static Deck CreateNewDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        for(Card.Suit suit : Card.Suit.values()) {
            for (int rank = 2; rank <= 14; rank++) {
                cards.add(new Card(suit, rank));
            }
        }

        return new Deck(cards);
    }
}
