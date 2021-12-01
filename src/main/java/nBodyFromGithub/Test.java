package nBodyFromGithub;

import com.aparapi.Kernel;
import com.aparapi.Range;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;

public class Test {

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();

        int MAX_SIZE = 1024; // 10^8 numbers;
        final float[] inA = new float[MAX_SIZE];
        final float[] inB = new float[MAX_SIZE];
        final float[] sum = new float[MAX_SIZE];

        Random rand = new Random();
        for (int i = 0; i < MAX_SIZE; ++i) {
            inA[i] = (float) rand.nextDouble();
            inB[i] = (float) rand.nextDouble();
        }
        System.out.println("Initialization for an array of size " + MAX_SIZE +
                " costs " + stopwatch.elapsedTime() + " seconds.");

        stopwatch = new Stopwatch();
        for (int T = 0; T < 100; ++T) {
            for (int i = 0; i < MAX_SIZE; ++i) {
                sum[i] = inA[i] + inB[i];
            }
        }
        System.out.println("100 times of adding calculation for an array of size " + MAX_SIZE +
                " on CPU costs " + stopwatch.elapsedTime() + " seconds.");

        stopwatch = new Stopwatch();
        Kernel kernel = new Kernel() {
            @Override
            public void run() {
                int i = getGlobalId();
                sum[i] = inA[i] + inB[i];
            }
        };
        Range range = Range.create(MAX_SIZE);
        for (int T = 0; T < 100; ++T) {
            kernel.execute(range);
        }
        kernel.dispose();
        System.out.println("100 times of adding calculation for an array of size " + MAX_SIZE +
                " on GPU costs " + stopwatch.elapsedTime() + " seconds.");
        for (int i = 0; i < MAX_SIZE; ++i) {
            assert sum[i] == inA[i] + inB[i];
        }
    }

}
