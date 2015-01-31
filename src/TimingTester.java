import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by andreahe on 1/27/15.
 */
public class TimingTester {
    public static void main(String[] args){
        Algorithm1 algorithm1 = new Algorithm1();
        //double[] d1 = generateTimingData(algorithm1);
        //System.out.println(Arrays.toString(d1));
        //Algorithm2 algorithm2 = new Algorithm2();
        //double[] d2 = generateTimingData(algorithm2);
        Algorithm3 algorithm3 = new Algorithm3();
        double[] d3 = generateTimingData(algorithm3);
        System.out.println(Arrays.toString(d3));
    }
    public static class TimeInterval {

        private long startTime, endTime;
        private long elapsedTime; // Time interval in milliseconds

        // Commands
        public void startTiming() {
            elapsedTime = 0;
            startTime = System.currentTimeMillis();
        }

        public void endTiming() {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
        }

        // Queries
        public double getElapsedTime() {
            return (double) elapsedTime / 1000.0;
        }

    }

/*    public interface PermutationAlgorithm {
        public void permute(int n);
    }*/

    public static class Algorithm1 implements PermutationAlgorithm {
        public void permute(int n) {
            int[] permutationArray = new int[n];
            Random generator = new Random();
            for (int i = 0; i < n; i++) {
                boolean alreadyUsed;
                do {
                    permutationArray[i] = generator.nextInt(n) + 1;
                    //System.out.println("permutationArray[" + i + "] is " + permutationArray[i]);
                    alreadyUsed = false;
                    for (int j = 0; j < i; j++) {
                        if (permutationArray[j] == permutationArray[i]) {
                            alreadyUsed = true;
                            break;
                        }
                    }
                } while (alreadyUsed);
            }
        }
    }

    public static double[] generateTimingData(PermutationAlgorithm algorithm) {
        int dataSize = 100;
        ArrayList<Double> timingData = new ArrayList<Double>();
        TimeInterval t = new TimeInterval();
        do {
            t.startTiming();
            algorithm.permute(dataSize);
            t.endTiming();
            timingData.add((double) dataSize);
            timingData.add(t.getElapsedTime());
            System.out.println("dataSize is " + dataSize + " and time is " + t.getElapsedTime());
            dataSize = dataSize * 2;
        } while (dataSize < 7000000 && t.getElapsedTime() < 30);
        double timingDataArray[] = new double[timingData.size()];
        for (int i = 0; i < timingData.size(); i++) {
            timingDataArray[i] = timingData.get(i);
        }
        return timingDataArray;
    }
}
