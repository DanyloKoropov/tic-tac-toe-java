package org.example;

import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Board board = new Board();

    public void game() {

        int moveCount = 0;
        String currentPlayer = "X";
        boolean gameOver = false;

        while (!gameOver) {

            board.printBoard();

            System.out.println("Enter your move: ");
            String input = scanner.nextLine();

            if (!input.matches("\\d+")) {
                System.out.println("That is not a valid move! Try again.");
                continue;
            }

            int move = Integer.parseInt(input);

            if (board.move(move, currentPlayer)) {

                moveCount++;

                if (board.checkWinner(currentPlayer)) {
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (moveCount == 9) {
                    board.printBoard();
                    System.out.println("Draw!");
                    gameOver = true;
                } else {

                    if (currentPlayer.equals("X")) {
                        currentPlayer = "O";
                    } else {
                        currentPlayer = "X";
                    }

                }
            }
        }
    }
}