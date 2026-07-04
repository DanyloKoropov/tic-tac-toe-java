package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void movePlacesMarkOnEmptyCell() {
        Board board = new Board();

        assertTrue(board.move(1, "X"));
        assertEquals("X", board.getCell(1));
    }

    @Test
    void moveRejectsTakenCell() {
        Board board = new Board();

        assertTrue(board.move(1, "X"));
        assertFalse(board.move(1, "O"));
        assertEquals("X", board.getCell(1));
    }

    @Test
    void moveRejectsInvalidPosition() {
        Board board = new Board();

        assertFalse(board.move(0, "X"));
        assertFalse(board.move(10, "X"));
    }

    @Test
    void checkWinnerDetectsRowWin() {
        Board board = new Board();

        board.move(1, "X");
        board.move(2, "X");
        board.move(3, "X");

        assertTrue(board.checkWinner("X"));
    }

    @Test
    void checkWinnerDetectsColumnWin() {
        Board board = new Board();

        board.move(1, "O");
        board.move(4, "O");
        board.move(7, "O");

        assertTrue(board.checkWinner("O"));
    }

    @Test
    void checkWinnerDetectsDiagonalWin() {
        Board board = new Board();

        board.move(1, "X");
        board.move(5, "X");
        board.move(9, "X");

        assertTrue(board.checkWinner("X"));
    }

    @Test
    void isBoardEmptyWorks() {
        Board board = new Board();

        assertTrue(board.isBoardEmpty());

        board.move(5, "X");

        assertFalse(board.isBoardEmpty());
    }

    @Test
    void findWinningMoveFindsWinningSpot() {
        Board board = new Board();

        board.move(1, "X");
        board.move(2, "X");

        assertEquals(3, board.findWinningMove("X"));
    }

    @Test
    void findWinningMoveReturnsNegativeOneWhenNoWin() {
        Board board = new Board();

        board.move(1, "X");
        board.move(5, "O");

        assertEquals(-1, board.findWinningMove("X"));
    }

    @Test
    void randomEmptySpotReturnsAnEmptyCell() {
        Board board = new Board();

        board.move(1, "X");
        board.move(2, "O");
        board.move(3, "X");

        int move = board.randomEmptySpot();

        assertTrue(move >= 4 && move <= 9);
        assertTrue(board.isEmpty(move));
    }
}