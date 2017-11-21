import java.util.ArrayList;

public class War {
    private Deck deck = Deck.CreateNewDeck();
    private Player player1 = new Player("Player1");
    private Player player2 = new Player("Player2");
    private ArrayList<IWarListener> warListeners = new ArrayList<>();
    private ArrayList<IRoundCompleteListener> roundCompleteListeners = new ArrayList<>();

    public War() {
        deck.shuffle();

        while (!deck.getCards().isEmpty()) {
            Player drawingPlayer = deck.getCards().size() % 2 == 0 ? player1 : player2;
            drawingPlayer.addCard(deck.drawCard());
        }
    }

    public void addWarListener(IWarListener warListener) {
        warListeners.add(warListener);
    }

    public void addRoundCompleteListener(IRoundCompleteListener roundCompleteListener){
        roundCompleteListeners.add(roundCompleteListener);
    }

    public void play() {
        while (!player1.getCards().isEmpty() && !player2.getCards().isEmpty()) {
            player1.shuffleCards();
            player2.shuffleCards();

            ArrayList<Card> cardPool = new ArrayList<>();
            executeRound(player1, player2, cardPool);
        }
    }

    private void executeRound(Player player1, Player player2, ArrayList<Card> cardPool) {
        if(player1.getCards().isEmpty() || player2.getCards().isEmpty()) {
            return;
        }

        Card player1Card = player1.playCard();
        Card player2Card = player2.playCard();

        cardPool.add(player1Card);
        cardPool.add(player2Card);

        if (player1Card.equals(player2Card)) {
            onWar();
            cardPool.addAll(drawWarCards(player1));
            cardPool.addAll(drawWarCards(player2));
            executeRound(player1, player2, cardPool);

        } else if (player1Card.compareTo(player2Card) > 0) {
            player1.addCard(cardPool);
            onRoundComplete(player1, player2);
        } else {
            player2.addCard(cardPool);
            onRoundComplete(player2, player1);
        }
    }

    private ArrayList<Card> drawWarCards(Player player) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(player.getCards().size() <= 1) {
                break;
            }
            cards.add(player.playCard());
        }

        return cards;
    }

    private void onRoundComplete(Player winningPlayer, Player losingPlayer) {
        roundCompleteListeners.forEach(roundCompleteListener -> roundCompleteListener.OnRoundComplete(winningPlayer,
                losingPlayer));
    }

    private void onWar(){
        warListeners.forEach(warListeners -> warListeners.OnWar());
    }
}
