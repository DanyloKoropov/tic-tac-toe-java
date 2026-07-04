package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    @Test
    void computerChoosesCornerOnFirstMove() {
        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        int move = computer.chooseMove(board, "X", "O", 0);

        assertTrue(move == 1 || move == 3 || move == 7 || move == 9);
    }

    @Test
    void computerChoosesCenterOnSecondMoveIfAvailable() {
        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(1, "X");

        assertEquals(5, computer.chooseMove(board, "O", "X", 1));
    }

    @Test
    void computerTakesWinningMove() {
        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(1, "O");
        board.move(2, "O");
        board.move(5, "X");

        assertEquals(3, computer.chooseMove(board, "O", "X", 3));
    }

    @Test
    void computerBlocksOpponentWinningMove() {
        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(1, "X");
        board.move(2, "X");
        board.move(5, "O");

        assertEquals(3, computer.chooseMove(board, "O", "X", 3));
    }

    @Test
    void computerChoosesRandomEmptySpotWhenNoBetterMoveExists() {
        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(1, "X");
        board.move(5, "O");
        board.move(9, "X");

        int move = computer.chooseMove(board, "O", "X", 3);

        assertTrue(board.isEmpty(move));
    }
}