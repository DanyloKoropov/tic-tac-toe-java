package org.example;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Tic-Tac-Toe!");

    String playAgain = "yes";

    while (playAgain.equals("yes")) {
      Game game = new Game();
      game.game();

      System.out.println("Would you like to play again (yes/no)?");
      playAgain = scanner.nextLine();

      while (!playAgain.equals("yes") && !playAgain.equals("no")) {
        System.out.println("That is not a valid entry!");
        System.out.println("Would you like to play again (yes/no)?");
        playAgain = scanner.nextLine();
      }
    }

    System.out.println("Goodbye!");
  }
}