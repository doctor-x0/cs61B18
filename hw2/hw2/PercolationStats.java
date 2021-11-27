package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int T;
    private double[] openSiteFractions;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        this.T = T;
        openSiteFractions = new double[T];

        for (int i = 0; i < T; i++) {
            Percolation test = pf.make(N);
            while (!test.percolates()) {
                int randomRow = StdRandom.uniform(N);
                int randomCol = StdRandom.uniform(N);
                test.open(randomRow, randomCol);
            }
            openSiteFractions[i] = (double) test.numberOfOpenSites() / (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(openSiteFractions);
    }

    public double stddev() {
        return StdStats.stddev(openSiteFractions);
    }

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }
}
