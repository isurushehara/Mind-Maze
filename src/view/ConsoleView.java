package view;

import model.Player;
import model.Score;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private final Scanner scanner;

    public ConsoleView() {

        scanner = new Scanner(System.in);

    }

    // ==========================================
    // WELCOME
    // ==========================================

    public void showWelcome() {

        System.out.println("========================================");
        System.out.println("           MAZE GAME");
        System.out.println("========================================");

    }

    // ==========================================
    // MAIN MENU
    // ==========================================

    public void showMainMenu() {

        System.out.println();
        System.out.println("========== MAIN MENU ==========");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("===============================");

    }

    public int readMainMenuChoice() {

        System.out.print("Choice : ");

        int choice = scanner.nextInt();

        scanner.nextLine();

        return choice;

    }

    // ==========================================
    // USER MENU
    // ==========================================

    public void showUserMenu() {

        System.out.println();
        System.out.println("========== USER MENU ==========");
        System.out.println("1. Start Game");
        System.out.println("2. My Scores");
        System.out.println("3. Logout");
        System.out.println("4. Exit");
        System.out.println("===============================");

    }

    public int readUserMenuChoice() {

        System.out.print("Choice : ");

        int choice = scanner.nextInt();

        scanner.nextLine();

        return choice;

    }

    // ==========================================
    // LOGIN / REGISTER
    // ==========================================

    public String readUsername() {

        System.out.print("Username : ");

        return scanner.nextLine();

    }

    public String readPassword() {

        System.out.print("Password : ");

        return scanner.nextLine();

    }

// ==========================================
// SHOW SCORES
// ==========================================

    public void showScores(List<Score> scores) {

        System.out.println();

        System.out.println("========== MY SCORES ==========");

        if (scores.isEmpty()) {

            System.out.println("No scores found.");

            return;

        }

        for (Score score : scores) {

            System.out.println(
                    "Maze : " + score.getMazeNumber()
                            + " | Commands : " + score.getCommands()
            );

        }

        System.out.println("===============================");

    }

    // ==========================================
    // MAZE SELECTION
    // ==========================================

    public int readMazeChoice() {

        System.out.println();
        System.out.println("========== SELECT MAZE ==========");
        System.out.println("1. Maze 1");
        System.out.println("2. Maze 2");

        System.out.print("Choice : ");

        int choice = scanner.nextInt();

        scanner.nextLine();

        return choice;

    }

    // ==========================================
    // GAME INSTRUCTIONS
    // ==========================================

    public void showInstructions() {

        System.out.println();

        System.out.println("======================================");

        System.out.println("Available Commands");

        System.out.println("--------------------------------------");

        System.out.println("go");

        System.out.println("turn left");

        System.out.println("turn right");

        System.out.println("where");

        System.out.println("exit");

        System.out.println("======================================");

    }

    // ==========================================
    // READ COMMAND
    // ==========================================

    public String readCommand() {

        System.out.print("\n>> ");

        return scanner.nextLine()
                .trim()
                .toLowerCase();

    }

    // ==========================================
    // PLAYER INFO
    // ==========================================

    public void showPlayerInfo(Player player) {

        System.out.println();

        System.out.println("========== PLAYER ==========");

        System.out.println("Name : "
                + player.getName());

        System.out.println("Row : "
                + player.getRow());

        System.out.println("Column : "
                + player.getColumn());

        System.out.println("Direction : "
                + player.getDirection());

        System.out.println("Commands : "
                + player.getCommandCount());

        System.out.println("============================");

    }

    // ==========================================
    // WIN
    // ==========================================

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

    // ==========================================
    // MESSAGE
    // ==========================================

    public void showMessage(String message) {

        System.out.println(message);

    }

    // ==========================================
    // ERROR
    // ==========================================

    public void showError(String message) {

        System.out.println();

        System.out.println("ERROR : " + message);

    }

}

