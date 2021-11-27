package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N;
    private WeightedQuickUnionUF sites;
    private WeightedQuickUnionUF sites1;
    private boolean[][] group;
    private int opensites = 0;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.N = N;
        sites = new WeightedQuickUnionUF(N * N + 2);
        sites1 = new WeightedQuickUnionUF(N * N + 1);
        group = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                group[i][j] = false;
            }
        }
        for (int i = 0; i < N; i++) {
            sites.union(N * N, i);
        }
        for (int i = 0; i < N; i++) {
            sites.union(N * N + 1, xyTo1D(N - 1, i));
        }
        for (int i = 0; i < N; i++) {
            sites1.union(N * N, i);
        }
    }

    private int xyTo1D(int row, int col) {
        return row * N + col;
    }

    public void open(int row, int col) {
        if (check(row, col)) {
            group[row][col] = true;
            opensites++;

            if (check(row + 1, col) && isOpen(row + 1, col)) {
                sites.union(xyTo1D(row, col), xyTo1D(row + 1, col));
                sites1.union(xyTo1D(row, col), xyTo1D(row + 1, col));
            }
            if (check(row - 1, col) && isOpen(row - 1, col)) {
                sites.union(xyTo1D(row, col), xyTo1D(row - 1, col));
                sites1.union(xyTo1D(row, col), xyTo1D(row - 1, col));
            }
            if (check(row, col + 1) && isOpen(row, col + 1)) {
                sites.union(xyTo1D(row, col), xyTo1D(row, col + 1));
                sites1.union(xyTo1D(row, col), xyTo1D(row, col + 1));
            }
            if (check(row, col - 1) && isOpen(row, col - 1)) {
                sites.union(xyTo1D(row, col), xyTo1D(row, col - 1));
                sites1.union(xyTo1D(row, col), xyTo1D(row, col - 1));
            }
        } else {
            throw new IllegalArgumentException("row and col must between 0 and N-1");
        }
    }

    public boolean isOpen(int row, int col) {
        if (check(row, col)) {
            return group[row][col];
        } else {
            throw new IllegalArgumentException("row and col must between 0 and N-1");
        }
    }

    public boolean isFull(int row, int col) {
        if (check(row, col) && isOpen(row, col)) {
            return sites1.connected(xyTo1D(row, col), N * N);
        } else {
            throw new IllegalArgumentException("row and col must between 0 and N-1");
        }
    }

    public int numberOfOpenSites() {
        return opensites;
    }

    public boolean percolates() {
        if (numberOfOpenSites() == 0) {
            return false;
        }
        return sites.connected(N * N, N * N + 1);
    }

    private boolean check(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }

    public static void main(String[] args) {
        
    }
}
