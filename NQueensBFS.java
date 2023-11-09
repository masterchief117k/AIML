package AIML;
import java.util.LinkedList;
import java.util.Queue;

public class NQueensBFS {

    static class State {
        int row;
        int[] board;

        State(int row, int[] board) {
            this.row = row;
            this.board = board.clone();
        }
    }

    static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || board[i] - i == col - row || board[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    static void printSolution(int[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void solveNQueens(int n) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, new int[n]));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();

            int currentRow = currentState.row;
            int[] currentBoard = currentState.board;

            if (currentRow == n) {
               
                printSolution(currentBoard);
            } else {
                for (int col = 0; col < n; col++) {
                    if (isSafe(currentBoard, currentRow, col)) {
                        int[] newBoard = currentBoard.clone();
                        newBoard[currentRow] = col;
                        queue.add(new State(currentRow + 1, newBoard));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 8;
        solveNQueens(n);
    }
}
