import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by mbrown on 4/1/17.
 */
public class CardShould {
    @Test
    public void NotAllowInvalidRanks() {
        assertThrows(IllegalArgumentException.class, () -> new Card(Card.Suit.Clubs, 0));
        assertThrows(IllegalArgumentException.class, () -> new Card(Card.Suit.Clubs, 15));
    }

    @Test
    public void NotAllowNullSuits() {
        assertThrows(IllegalArgumentException.class, () -> new Card(null, 5));
    }

    @Test
    public void BeComparable() {
        assertTrue(new Card(2).compareTo(new Card(5)) < 0);
        assertTrue(new Card(10).compareTo(new Card(9)) > 0);
        assertTrue(new Card(14).compareTo(new Card(14)) == 0);
    }

    @Test
    public void ImplementToString() {
        assertEquals("Ace of diamonds", new Card(Card.Suit.Diamonds, 14).toString());
        assertEquals("King of clubs", new Card(Card.Suit.Clubs, 13).toString());
        assertEquals("Queen of hearts", new Card(Card.Suit.Hearts, 12).toString());
        assertEquals("Jack of spades", new Card(Card.Suit.Spades, 11).toString());
        assertEquals("10 of diamonds", new Card(Card.Suit.Diamonds, 10).toString());
    }
}
