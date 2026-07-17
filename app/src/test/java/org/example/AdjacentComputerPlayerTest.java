package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjacentComputerPlayerTest {

    @Test
    void computerMovesRightIfAvailable() {

        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(1, "X");

        int move = computer.chooseAdjacentMove(board, 1);

        assertEquals(2, move);
    }

    @Test
    void computerMovesLeftIfRightIsBlocked() {

        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(5, "X");
        board.move(6, "O");

        int move = computer.chooseAdjacentMove(board, 5);

        assertEquals(4, move);
    }

    @Test
    void computerMovesUpIfRightAndLeftBlocked() {

        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(5, "X");
        board.move(6, "O");
        board.move(4, "O");

        int move = computer.chooseAdjacentMove(board, 5);

        assertEquals(2, move);
    }

    @Test
    void computerMovesDownIfRightLeftAndUpBlocked() {

        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(5, "X");
        board.move(6, "O");
        board.move(4, "O");
        board.move(2, "O");

        int move = computer.chooseAdjacentMove(board, 5);

        assertEquals(8, move);
    }

    @Test
    void computerChoosesRandomMoveIfAllAdjacentCellsAreBlocked() {

        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(5, "X");
        board.move(2, "O");
        board.move(4, "O");
        board.move(6, "O");
        board.move(8, "O");

        int move = computer.chooseAdjacentMove(board, 5);

        assertTrue(board.isEmpty(move));
    }

    @Test
    void computerCanMoveFromCorner() {

        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(9, "X");

        int move = computer.chooseAdjacentMove(board, 9);

        assertTrue(move == 8 || move == 6);
    }

    @Test
    void chosenMoveIsAlwaysEmpty() {

        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer();

        board.move(1, "X");
        board.move(5, "O");
        board.move(9, "X");

        int move = computer.chooseAdjacentMove(board, 9);

        assertTrue(board.isEmpty(move));
    }

}