public class WarGameRunner {

    public void ExecuteGames(int count) {
        Statistic warEvents = new Statistic();
        Statistic roundEvents = new Statistic();

        for(int i=0;i<count;i++) {
            War warGame = new War();
            WarEventCounts warEventCounts = new WarEventCounts();
            addListeners(warGame, warEventCounts);

            warGame.play();

            warEvents.addDataPoint(warEventCounts.getWarCount());
            roundEvents.addDataPoint(warEventCounts.getRoundCount());
        }

        System.out.println(String.format("Average rounds: %.5f, %.5f", roundEvents.getMean(), roundEvents.getStdDev()));
        System.out.println(String.format("Average wars: %.5f, %.5f", warEvents.getMean(), warEvents.getStdDev()));
    }

    private static void addListeners(War war, WarEventCounts warEventCounts) {
        war.addWarListener(new LogEvents());
        war.addRoundCompleteListener(new LogEvents());

        war.addWarListener(warEventCounts);
        war.addRoundCompleteListener(warEventCounts);
    }
}
