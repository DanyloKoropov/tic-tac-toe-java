package org.example;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Tic-Tac-Toe!");

    String playAgain = "yes";

    while (playAgain.equals("yes")) {

      System.out.println("What kind of game would you like to play?");
      System.out.println("1. Human vs. Human");
      System.out.println("2. Human vs. Computer");
      System.out.println("3. Computer vs. Human");
      System.out.println("4. Adjacent Computer Player");

      String input = scanner.nextLine();

      while (!input.equals("1")
              && !input.equals("2")
              && !input.equals("3")
              && !input.equals("4")) {

        System.out.println("That is not a valid entry!");
        System.out.println("What kind of game would you like to play?");
        System.out.println("1. Human vs. Human");
        System.out.println("2. Human vs. Computer");
        System.out.println("3. Computer vs. Human");
        System.out.println("4. Adjacent Computer Player");

        input = scanner.nextLine();
      }

      int mode = Integer.parseInt(input);

      if (mode == 2) {
        System.out.println("Great! The computer will go second.");
      } else if (mode == 3) {
        System.out.println("Great! The computer will go first.");
      } else if (mode == 4) {
        System.out.println("Great! You will play against the adjacent computer player.");
      }

      Game game = new Game();
      game.game(mode);

      System.out.println("Would you like to play again (yes/no)?");
      playAgain = scanner.nextLine();

      while (!playAgain.equals("yes")
              && !playAgain.equals("no")) {

        System.out.println("That is not a valid entry!");
        System.out.println("Would you like to play again (yes/no)?");

        playAgain = scanner.nextLine();
      }
    }

    System.out.println("Goodbye!");
  }
}