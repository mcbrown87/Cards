import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mbrown on 4/1/17.
 */
public class DeckShould {
    @Test
    public void AllowDrawingCards() {
        ArrayList<Card> cards = new ArrayList<>();
        Card myCard = new Card(5);
        cards.add(myCard);

        Deck sut = new Deck(cards);
        assertSame(myCard, sut.drawCard());
    }

    @Test
    public void ReturnNullWhenEmpty() {
        Deck sut = new Deck(new ArrayList<Card>());
        assertNull(sut.drawCard());
    }

    @Test
    public void BeAbleToAccessCards() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2));
        cards.add(new Card(3));

        Deck sut = new Deck(cards);

        for(int i=0;i<cards.size();i++) {
            assertEquals(cards.get(i), sut.getCards().get(i));
        }
    }

    @Test
    public void NotBeAbleToModifyCards(){
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2));
        cards.add(new Card(3));

        Deck sut = new Deck(cards);
        assertThrows(UnsupportedOperationException.class, () -> sut.getCards().add(cards.get(0)));
    }

    @Test
    public void BeAbleToShuffle() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2));
        cards.add(new Card(3));
        cards.add(new Card(4));
        cards.add(new Card(5));
        cards.add(new Card(6));
        cards.add(new Card(7));
        cards.add(new Card(8));
        cards.add(new Card(9));
        cards.add(new Card(10));
        cards.add(new Card(11));
        cards.add(new Card(12));
        cards.add(new Card(13));
        cards.add(new Card(14));

        Deck sut = new Deck((ArrayList<Card>) cards.clone());
        sut.shuffle();

        boolean sameOrder = true;
        for (int i = 0; i < cards.size(); i++) {
            Card card1 = cards.get(i);
            Card card2 = sut.getCards().get(i);
            if (card1 != card2) {
                sameOrder = false;
                break;
            }
        }

        assertFalse(sameOrder);
    }

    @Test
    public void BeAbleToCreateANewDeck() {
        Deck sut = Deck.CreateNewDeck();
        assertEquals(52, sut.getCards().size());
    }
}
