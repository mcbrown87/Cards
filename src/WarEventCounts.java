public class WarEventCounts implements IWarListener, IRoundCompleteListener {

    private int warCount = 0;
    private int roundCount = 0;

    public int getWarCount() {
        return warCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    @Override
    public void OnWar() {
        warCount++;
    }

    @Override
    public void OnRoundComplete(Player winningPlayer, Player losingPlayer) {
        roundCount++;
    }
}
