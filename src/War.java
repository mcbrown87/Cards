import java.util.ArrayList;

public class War {
    private Deck deck = Deck.CreateNewDeck();
    private Player player1 = new Player("Player1");
    private Player player2 = new Player("Player2");

    public War() {
        deck.shuffle();

        while (!deck.getCards().isEmpty()) {
            Player drawingPlayer = deck.getCards().size() % 2 == 0 ? player1 : player2;
            drawingPlayer.addCard(deck.drawCard());
        }
    }

    public void play() {
        while (!player1.getCards().isEmpty() && !player2.getCards().isEmpty()) {
            player1.shuffleCards();
            player2.shuffleCards();

            ArrayList<Card> cardPool = new ArrayList<>();
            executeRound(player1, player2, cardPool);

            System.out.println(String.format("Player 1 has %d cards", player1.getCards().size()));
            System.out.println(String.format("Player 2 has %d cards", player2.getCards().size()));
            System.out.println("----------------------------------");
        }
    }

    private void executeRound(Player player1, Player player2, ArrayList<Card> cardPool) {
        Card player1Card = player1.playCard();
        Card player2Card = player2.playCard();
        cardPool.add(player1Card);
        cardPool.add(player2Card);

        if (player1Card.equals(player2Card)) {
            System.out.println("WAR");
            cardPool.addAll(drawWarCards(player1));
            System.out.println("");
            cardPool.addAll(drawWarCards(player2));
            System.out.println("");
            executeRound(player1, player2, cardPool);

        } else if (player1Card.compareTo(player2Card) > 0) {
            System.out.println(String.format("%s wins!", player1));
            player1.addCard(cardPool);
        } else {
            System.out.println(String.format("%s wins!", player2));
            player2.addCard(cardPool);
        }
    }

    private ArrayList<Card> drawWarCards(Player player) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(player.getCards().size() == 1) {
                break;
            }
            cards.add(player.playCard());
        }

        return cards;
    }
}
