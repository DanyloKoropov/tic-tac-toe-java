package org.example;

import java.util.ArrayList;
import java.util.Random;

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

    public boolean isEmpty(int position) {
        if (position < 1 || position > 9) {
            return false;
        }

        return !board[position - 1].equals("X")
                && !board[position - 1].equals("O");
    }

    public String getCell(int position) {
        return board[position-1];
    }

    public boolean isBoardEmpty() {
        for (int i = 1; i <= 9; i++) {
            if (!isEmpty(i)) {
                return false;
            }
        }

        return true;
    }

    public int findWinningMove(String player) {
        for (int position = 1; position <= 9; position++) {
            if (isEmpty(position)) {
                board[position - 1] = player;

                if (checkWinner(player)) {
                    board[position - 1] = String.valueOf(position);
                    return position;
                }

                board[position - 1] = String.valueOf(position);
            }

        }
        return -1;
    }

    public int randomEmptySpot() {
        ArrayList<Integer> emptySpots = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= board.length; i++) {
            if (isEmpty(i)) {
                emptySpots.add(i);
            }
        }

        int index = random.nextInt(emptySpots.size());
        return emptySpots.get(index);
    }
}