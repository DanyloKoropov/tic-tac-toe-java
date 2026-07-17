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

    public int chooseAdjacentMove(Board board, int previousMove) {

        int row = (previousMove - 1) / 3;
        int col = (previousMove - 1) % 3;

        if (col < 2) {
            int move = previousMove + 1;

            if (board.isValidAdjacentMove(move)) {
                return move;
            }
        }

        if (col > 0) {
            int move = previousMove - 1;

            if (board.isValidAdjacentMove(move)) {
                return move;
            }
        }

        if (row > 0) {
            int move = previousMove - 3;

            if (board.isValidAdjacentMove(move)) {
                return move;
            }
        }

        if (row < 2) {
            int move = previousMove + 3;

            if (board.isValidAdjacentMove(move)) {
                return move;
            }
        }

        return board.randomEmptySpot();
    }
}