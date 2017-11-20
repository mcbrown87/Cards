public class Program {
    public static void main(String[] args) {
        War war = new War();
        war.addWarListener(new LogEvents());
        war.addRoundCompleteListener(new LogEvents());

        war.play();
    }
}
