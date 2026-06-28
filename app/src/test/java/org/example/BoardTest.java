package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void movePlacesXOnEmptyCell() {
        Board board = new Board();

        boolean result = board.move(1, "X");

        assertTrue(result);
        assertTrue(board.checkWinner("X") == false);
    }

    @Test
    void moveRejectsCellBelowRange() {
        Board board = new Board();

        boolean result = board.move(0, "X");

        assertFalse(result);
    }

    @Test
    void moveRejectsCellAboveRange() {
        Board board = new Board();

        boolean result = board.move(10, "X");

        assertFalse(result);
    }

    @Test
    void moveRejectsTakenCell() {
        Board board = new Board();

        assertTrue(board.move(1, "X"));
        assertFalse(board.move(1, "O"));
    }

    @Test
    void checkWinnerDetectsTopRowWin() {
        Board board = new Board();

        board.move(1, "X");
        board.move(2, "X");
        board.move(3, "X");

        assertTrue(board.checkWinner("X"));
    }

    @Test
    void checkWinnerDetectsMiddleRowWin() {
        Board board = new Board();

        board.move(4, "O");
        board.move(5, "O");
        board.move(6, "O");

        assertTrue(board.checkWinner("O"));
    }

    @Test
    void checkWinnerDetectsColumnWin() {
        Board board = new Board();

        board.move(1, "X");
        board.move(4, "X");
        board.move(7, "X");

        assertTrue(board.checkWinner("X"));
    }

    @Test
    void checkWinnerDetectsDiagonalWin() {
        Board board = new Board();

        board.move(1, "O");
        board.move(5, "O");
        board.move(9, "O");

        assertTrue(board.checkWinner("O"));
    }

    @Test
    void checkWinnerDetectsOtherDiagonalWin() {
        Board board = new Board();

        board.move(3, "X");
        board.move(5, "X");
        board.move(7, "X");

        assertTrue(board.checkWinner("X"));
    }

    @Test
    void checkWinnerReturnsFalseWhenThereIsNoWinner() {
        Board board = new Board();

        board.move(1, "X");
        board.move(2, "O");
        board.move(3, "X");

        assertFalse(board.checkWinner("X"));
        assertFalse(board.checkWinner("O"));
    }
}