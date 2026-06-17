package game;

import maps.MazeFactory;
import model.Maze;
import model.Player;
import model.Score;
import model.User;
import service.LoginService;
import service.MovementService;
import service.ScoreService;
import view.ConsoleView;

public class GameEngine {

    private final ConsoleView consoleView;
    private final Player player;
    private Maze maze;
    private final MovementService movementService;
    private final LoginService loginService;
    private final ScoreService scoreService;

    private User currentUser;

    public GameEngine() {

        consoleView = new ConsoleView();
        player = new Player();
        movementService = new MovementService();
        loginService = new LoginService();
        scoreService = new ScoreService();

    }

    public void start() {

        consoleView.showWelcome();

        mainMenu();

    }

    // ===================================
    // MAIN MENU
    // ===================================

    private void mainMenu() {

        boolean running = true;

        while (running) {

            consoleView.showMainMenu();

            int choice = consoleView.readMainMenuChoice();

            switch (choice) {

                case 1:

                    register();

                    break;

                case 2:

                    login();

                    break;

                case 3:

                    consoleView.showMessage("Good Bye!");

                    running = false;

                    break;

                default:

                    consoleView.showError("Invalid choice!");

            }

        }

    }

    // ===================================
    // REGISTER
    // ===================================

    private void register() {

        String username =
                consoleView.readUsername();

        String password =
                consoleView.readPassword();

        boolean success =
                loginService.register(username, password);

        if (success) {

            consoleView.showMessage(
                    "Registration successful.");

        } else {

            consoleView.showError(
                    "Registration failed.");

        }

    }

    // ===================================
    // LOGIN
    // ===================================

    private void login() {

        String username =
                consoleView.readUsername();

        String password =
                consoleView.readPassword();

        currentUser =
                loginService.login(username, password);

        if (currentUser == null) {

            consoleView.showError(
                    "Invalid username or password.");

            return;

        }

        consoleView.showMessage(
                "Welcome " +
                        currentUser.getUsername());

        player.setName(
                currentUser.getUsername());

        player.resetPosition();

        userMenu();

    }

    // ===================================
    // USER MENU
    // ===================================

    private void userMenu() {

        boolean running = true;

        while (running) {

            consoleView.showUserMenu();

            int choice =
                    consoleView.readUserMenuChoice();

            switch (choice) {

                case 1:

                    selectMaze();

                    consoleView.showInstructions();

                    play();

                    break;

                case 2:

                    consoleView.showScores(
                            scoreService.getScoresByUser(
                                    currentUser.getId()));

                    break;

                case 3:

                    currentUser = null;

                    consoleView.showMessage(
                            "Logged out.");

                    running = false;

                    break;

                case 4:

                    System.exit(0);

                    break;

                default:

                    consoleView.showError(
                            "Invalid choice.");

            }

        }

    }

    // ===================================
    // SELECT MAZE
    // ===================================

    private void selectMaze() {

        while (true) {

            int choice =
                    consoleView.readMazeChoice();

            if (choice == 1 || choice == 2) {

                maze =
                        MazeFactory.getMaze(choice);

                break;

            }

            consoleView.showError(
                    "Invalid maze.");

        }

    }

    // ===================================
    // GAME LOOP
    // ===================================

    private void play() {

        boolean running = true;

        while (running) {

            String command =
                    consoleView.readCommand();

            switch (command) {

                case "go":

                    boolean moved =
                            movementService.moveForward(player, maze);

                    if (moved) {

                        consoleView.showMessage(
                                "You moved forward.");

                    } else {

                        consoleView.showError(
                                "Wall detected.");

                    }

                    if (movementService.hasWon(player, maze)) {

                        Score score = new Score();

                        score.setUserId(currentUser.getId());

                        score.setMazeNumber(1); // update later if needed

                        score.setCommands(player.getCommandCount());

                        boolean saved =
                                scoreService.saveScore(score);

                        consoleView.showWin(player);

                        if(saved){

                            consoleView.showMessage(
                                    "Score saved successfully.");

                        }
                        else{

                            consoleView.showError(
                                    "Failed to save score.");

                        }

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

                    consoleView.showMessage(
                            "Direction : "
                                    + player.getDirection());

                    break;

                case "where":

                    consoleView.showPlayerInfo(player);

                    break;

                case "exit":

                    running = false;

                    break;

                default:

                    consoleView.showError(
                            "Invalid command.");

            }

        }

    }

}