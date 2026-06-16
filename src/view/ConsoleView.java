package view;

import model.Player;

import java.util.Scanner;

public class ConsoleView {

    private final Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    // ------------------------------------
    // Welcome
    // ------------------------------------

    public void showWelcome() {

        System.out.println("=========================================");
        System.out.println("         WELCOME TO MAZE GAME");
        System.out.println("=========================================");

    }

    // ------------------------------------
    // Player Name
    // ------------------------------------

    public String readPlayerName() {

        System.out.print("Enter player name: ");

        return scanner.nextLine();

    }

    // ------------------------------------
    // Maze Selection
    // ------------------------------------

    public int readMazeChoice() {

        System.out.println();
        System.out.println("Select Maze");
        System.out.println("1. Maze 1");
        System.out.println("2. Maze 2");

        System.out.print("Choice: ");

        int choice = scanner.nextInt();

        scanner.nextLine();

        return choice;

    }

    // ------------------------------------
    // Instructions
    // ------------------------------------

    public void showInstructions() {

        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("Available Commands");
        System.out.println("-------------------------------------");
        System.out.println("go");
        System.out.println("turn left");
        System.out.println("turn right");
        System.out.println("where");
        System.out.println("exit");
        System.out.println("-------------------------------------");

    }

    // ------------------------------------
    // Read Command
    // ------------------------------------

    public String readCommand() {

        System.out.print("\n>> ");

        return scanner.nextLine().trim().toLowerCase();

    }

    // ------------------------------------
    // Player Info
    // ------------------------------------

    public void showPlayerInfo(Player player) {

        System.out.println();

        System.out.println("Player : " + player.getName());

        System.out.println("Row : " + player.getRow());

        System.out.println("Column : " + player.getColumn());

        System.out.println("Direction : " + player.getDirection());

        System.out.println("Commands : " + player.getCommandCount());

    }

    // ------------------------------------
    // Messages
    // ------------------------------------

    public void showMessage(String message) {

        System.out.println(message);

    }

    public void showError(String message) {

        System.out.println("Error: " + message);

    }

    // ------------------------------------
    // Win Screen
    // ------------------------------------

    public void showWin(Player player) {

        System.out.println();

        System.out.println("================================");

        System.out.println("Congratulations!");

        System.out.println(player.getName());

        System.out.println("You escaped the maze!");

        System.out.println("Commands Used : "
                + player.getCommandCount());

        System.out.println("================================");

    }

}