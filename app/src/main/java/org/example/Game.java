package org.example;

import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Board board = new Board();

    public void game(int mode) {

        int moveCount = 0;
        int previousMove = -1;

        String currentPlayer = "X";
        boolean gameOver = false;

        ComputerPlayer computer = new ComputerPlayer();

        while (!gameOver) {

            board.printBoard();

            int move;

            if (mode == 2 && currentPlayer.equals("O")) {

                move = computer.chooseMove(board, "O", "X", moveCount);
                System.out.println("Computer chooses: " + move);

            }

            else if (mode == 3 && currentPlayer.equals("X")) {

                move = computer.chooseMove(board, "X", "O", moveCount);
                System.out.println("Computer chooses: " + move);

            }

            else if (mode == 4 && currentPlayer.equals("O")) {

                move = computer.chooseAdjacentMove(board, previousMove);

                if (Math.abs(move - previousMove) == 1
                        || Math.abs(move - previousMove) == 3) {

                    System.out.println("The computer moved in spot " + move + ".");

                } else {

                    System.out.println("The computer moved randomly in spot " + move + ".");

                }

            }

            else {

                System.out.println("Enter your move:");

                String input = scanner.nextLine();

                if (!input.matches("\\d+")) {
                    System.out.println("That is not a valid move! Try again.");
                    continue;
                }

                move = Integer.parseInt(input);

            }

            if (board.move(move, currentPlayer)) {

                previousMove = move;
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