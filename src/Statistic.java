import java.util.ArrayList;

public class Statistic {

    private ArrayList<Integer> data;

    public Statistic() {
        this(new ArrayList<>());
    }

    public Statistic(ArrayList<Integer> data){
        this.data = data;
    }

    public void addDataPoint(int dataPoint) {
        this.data.add(dataPoint);
    }

    public double getMean() {
        int total = 0;
        for(int element : data) {
            total += element;
        }

        return total/data.size();
    }

    public double getVariance() {
        double mean = getMean();
        double temp = 0;

        for (int a : data) {
            temp += (a - mean) * (a - mean);
        }

        return temp / (data.size() - 1);
    }

    double getStdDev() {
        return Math.sqrt(getVariance());
    }
}
