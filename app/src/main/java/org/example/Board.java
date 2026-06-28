package org.example;

public class Board {
    private String[] board = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9"
    };

    public void printBoard() {
        System.out.println();

        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);

        System.out.println();
    }

    public boolean move(int input, String player) {
        if (input > 0 && input < 10) {
            int index = input - 1;

            if (!board[index].equals("X") && !board[index].equals("O")) {
                board[index] = player;
                return true;
            } else {
                System.out.println("That is not a valid move! Try again.");
                return false;
            }
        } else {
            System.out.println("That is not a valid move! Try again.");
            return false;
        }
    }

    public boolean checkWinner(String player) {
        int[][] winCombinations = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] combination : winCombinations) {
            if (board[combination[0]].equals(player)
                    && board[combination[1]].equals(player)
                    && board[combination[2]].equals(player)) {
                return true;
            }
        }

        return false;
    }
}