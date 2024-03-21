package org.example;

public class EightQueensProblem {
    final int N = 8; // Number of queens and board size
    int[][] board = new int[N][N];

    // Function to print the solution
    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    // Function to check if a queen can be placed on board[row][col]
    private boolean isSafe(int row, int col) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive function to solve the problem
    private boolean solveNQUtil(int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(col + 1))
                    return true;

                // Backtrack
                board[i][col] = 0;
            }
        }
        return false;
    }

    // Wrapper function for solveNQUtil()
    public boolean solveNQ() {
        if (!solveNQUtil(0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution();
        return true;
    }

    public static void main(String args[]) {
        EightQueensProblem queen = new EightQueensProblem();
        queen.solveNQ();
    }
}

