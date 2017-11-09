import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Player {
    private String name;
    private ArrayList<Card> cards = new ArrayList<>();

    public Player() {
        this(String.format("Player %s", UUID.randomUUID().toString()));
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCard(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public ArrayList<Card> playCard(int count) {
        ArrayList<Card> cards = new ArrayList<>();
        for(int i = 0;i<count;i++){
            cards.add(playCard());
        }

        return cards;
    }

    public Card playCard() {
        if (!cards.isEmpty()) {
            Card playedCard = cards.remove(0);
            System.out.println(String.format("%s played a %s", this, playedCard));
            return playedCard;
        }

        throw new IllegalStateException("Failed to play a card. No cards to play");
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        return getName();
    }
}
