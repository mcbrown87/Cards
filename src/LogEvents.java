public class LogEvents implements IWarListener, IRoundCompleteListener {

    @Override
    public void OnWar() {
        System.out.println("WAR!");
    }

    @Override
    public void OnRoundComplete(Player winningPlayer, Player losingPlayer) {
        System.out.println(String.format("%s wins", winningPlayer));
        System.out.println(String.format("%s has %d cards", winningPlayer, winningPlayer.getCards().size()));
        System.out.println(String.format("%s has %d cards", losingPlayer, losingPlayer.getCards().size()));
        System.out.println("----------------------------------");
    }
}
