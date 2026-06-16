package game;

import java.util.Scanner;

import maps.MazeFactory;
import model.Maze;
import model.Player;
import service.MovementService;
import view.ConsoleView;

public class GameEngine {
    private ConsoleView consoleView;
    private Player player;
    private Maze maze;
    private MovementService movementService;

    public GameEngine() {

        consoleView = new ConsoleView();
        player = new Player();
        movementService = new MovementService();

    }

    public void start() {

        consoleView.showWelcome();

        createPlayer();

        selectMaze();

        showInstructions();

        play();

    }

    private void createPlayer() {

        player.setName(
                consoleView.readPlayerName());

    }

    private void selectMaze() {

        while (true) {

            int choice = consoleView.readMazeChoice();

            if (choice == 1 || choice == 2) {

                maze = MazeFactory.getMaze(choice);

                break;

            }

            consoleView.showError("Invalid maze!");

        }

    }

    private void showInstructions() {

        System.out.println();

        System.out.println("--------------------------------");

        System.out.println("Available Commands");

        System.out.println("--------------------------------");

        System.out.println("go");

        System.out.println("turn left");

        System.out.println("turn right");

        System.out.println("where");

        System.out.println("exit");

        System.out.println("--------------------------------");

    }

    private void play() {

        boolean running = true;

        while (running) {

            System.out.print("\n>> ");

            String command = consoleView.readCommand();

            switch (command) {

                case "go":

                    boolean moved =
                            movementService.moveForward(player, maze);

                    if (moved) {

                        consoleView.showMessage("You moved forward.");

                    } else {

                        consoleView.showError("Wall detected!");

                    }

                    if (movementService.hasWon(player, maze)) {

                        consoleView.showWin(player);

                        running = false;

                    }

                    break;

                case "turn left":

                    movementService.turnLeft(player);

                    consoleView.showMessage(
                            "Direction : "
                                    + player.getDirection());

                    break;

                case "turn right":

                    movementService.turnRight(player);

                    System.out.println("Direction : "
                            + player.getDirection());

                    break;

                case "where":

                    consoleView.showPlayerInfo(player);

                    break;

                case "exit":

                    running = false;

                    consoleView.showMessage("Game exited.");

                    break;

                default:

                    consoleView.showError("Invalid command!");

                    System.out.println("Available commands:");

                    System.out.println("go");

                    System.out.println("turn left");

                    System.out.println("turn right");

                    System.out.println("where");

                    System.out.println("exit");

            }

        }

    }


}