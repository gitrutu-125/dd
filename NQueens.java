
import java.util.Scanner;

public class NQueens {

    static int N;

    // Check whether queen can be placed safely
    static boolean isSafe(int board[][], int row, int col) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < N; i--, j++) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Solve N-Queens using Backtracking
    static boolean solveNQueens(int board[][], int row) {

        // All queens are placed
        if (row == N)
            return true;

        // Try placing queen in each column
        for (int col = 0; col < N; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 1;

                if (solveNQueens(board, row + 1))
                    return true;

                // Backtrack
                board[row][col] = 0;
            }
        }

        return false;
    }

    // Display chessboard
    static void printBoard(int board[][]) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        N = sc.nextInt();

        if (N <= 0) {
            System.out.println("Enter a positive number.");
        } else {

            int board[][] = new int[N][N];

            if (solveNQueens(board, 0)) {

                System.out.println("\nSolution:");
                printBoard(board);

            } else {

                System.out.println("Solution does not exist.");
            }
        }

        sc.close();
    }
}
