import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by mbrown on 4/1/17.
 */
public class PlayerShould {
    @Test
    public void HaveAName() {
        Player sut = new Player("Player1");

        assertEquals("Player1", sut.getName());
    }

    @Test
    public void BeAbleToAddCards() {
        Player sut = new Player();

        sut.addCard(new Card(5));
        assertEquals(new Card(5), sut.getCards().get(0));
    }

    @Test
    public void BeAbleToAddMultipleCards() {
        Player sut = new Player();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(5));
        cards.add(new Card(5));

        sut.addCard(cards);

        assertEquals(2, sut.getCards().size());
    }

    @Test
    public void BeAbleToPlayCards() {
        Player sut = new Player();
        sut.addCard(new Card(5));

        assertEquals(new Card(5), sut.playCard());
        assertEquals(0, sut.getCards().size());
    }

    @Test
    public void ThrowAnErrorWhenPlayingACardAndOutOfCards() {
        Player sut = new Player();
        assertThrows(IllegalStateException.class, () -> sut.playCard());
    }

    @Test
    public void BeAbleToPlayMultipleCards() {
        Player sut = new Player();
        sut.addCard(new Card(5));
        sut.addCard(new Card(5));

        assertEquals(2, sut.playCard(2).size());
    }

    @Test
    public void ThrowAnErrorWhenPlayingMultipleCardsAndOutOfCards() {
        Player sut = new Player();
        sut.addCard(new Card(5));

        assertThrows(IllegalStateException.class, () -> sut.playCard(2));
    }
}