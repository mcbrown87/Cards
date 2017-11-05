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

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public Card playCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }

        throw new IllegalStateException("Failed to play a card. No cards to play");
    }
}
