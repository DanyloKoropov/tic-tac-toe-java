package org.example;

import java.util.Random;

public class ComputerPlayer {
    public int chooseMove(Board board, String computerMark, String humanMark, int moveCount) {
        if (board.isBoardEmpty()) {
            int[] corners = {1, 3, 7, 9};
            Random random = new Random();
            return corners[random.nextInt(corners.length)];
        }

        if (moveCount == 1 && board.isEmpty(5)) {
            return 5;
        }

        int winningMove = board.findWinningMove(computerMark);
        if (winningMove != -1) {
            return winningMove;
        }

        int blockingMove = board.findWinningMove(humanMark);
        if (blockingMove != -1) {
            return blockingMove;
        }

        return board.randomEmptySpot();
    }
}