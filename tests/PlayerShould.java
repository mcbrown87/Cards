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
}