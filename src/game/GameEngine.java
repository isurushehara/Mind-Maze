package game;

import java.util.Scanner;

import maps.MazeFactory;
import model.Maze;
import model.Player;
import service.MovementService;

public class GameEngine {

    private Scanner scanner;
    private Player player;
    private Maze maze;
    private MovementService movementService;

    public GameEngine() {

        scanner = new Scanner(System.in);

        player = new Player();

        movementService = new MovementService();

    }

    public void start() {

        showWelcome();

        createPlayer();

        selectMaze();

        showInstructions();

        play();

    }

    private void showWelcome() {

        System.out.println("====================================");
        System.out.println("      WELCOME TO MAZE GAME");
        System.out.println("====================================");

    }

    private void createPlayer() {

        System.out.print("Enter player name: ");

        String name = scanner.nextLine();

        player.setName(name);

    }

    private void selectMaze() {

        while (true) {

            System.out.println();

            System.out.println("Select Maze");

            System.out.println("1. Maze 1");

            System.out.println("2. Maze 2");

            System.out.print("Choice : ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            if (choice == 1 || choice == 2) {

                maze = MazeFactory.getMaze(choice);

                break;

            } else {

                System.out.println("Invalid maze!");

            }

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

            String command = scanner.nextLine().toLowerCase();

            switch (command) {

                case "go":

                    boolean moved =
                            movementService.moveForward(player, maze);

                    if (moved) {

                        System.out.println("You moved forward.");

                    } else {

                        System.out.println("Cannot move! Wall or boundary.");

                    }

                    if (movementService.hasWon(player, maze)) {

                        System.out.println();

                        System.out.println("****************************");

                        System.out.println("Congratulations!");

                        System.out.println(player.getName());

                        System.out.println("You escaped the maze!");

                        System.out.println("Commands used : "
                                + player.getCommandCount());

                        System.out.println("****************************");

                        running = false;

                    }

                    break;

                case "turn left":

                    movementService.turnLeft(player);

                    System.out.println("Direction : "
                            + player.getDirection());

                    break;

                case "turn right":

                    movementService.turnRight(player);

                    System.out.println("Direction : "
                            + player.getDirection());

                    break;

                case "where":

                    showPlayerPosition();

                    break;

                case "exit":

                    running = false;

                    System.out.println("Game exited.");

                    break;

                default:

                    System.out.println("Invalid command!");

                    System.out.println("Available commands:");

                    System.out.println("go");

                    System.out.println("turn left");

                    System.out.println("turn right");

                    System.out.println("where");

                    System.out.println("exit");

            }

        }

    }

    private void showPlayerPosition() {

        System.out.println();

        System.out.println("Player : "
                + player.getName());

        System.out.println("Row : "
                + player.getRow());

        System.out.println("Column : "
                + player.getColumn());

        System.out.println("Direction : "
                + player.getDirection());

        System.out.println("Commands : "
                + player.getCommandCount());

    }

}