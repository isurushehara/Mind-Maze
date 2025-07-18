import java.util.Scanner;

public class Main extends Action{

    public static void main(String[] args) {

        //CREATE INPUT OBJECT AND PLAYER OBJECT
        Scanner input = new Scanner(System.in);
        Action player = new Action();

        //SELECT A MAP
        System.out.println("----------------------------------------------------------------");
        System.out.println("------------------- WELCOME TO THE MIND MAX --------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("|| Select a map: 1, 2");
//        int map_no = input.nextInt();
//        player.map_no = map_no;

        //INTRODUCTIONS
        System.out.println("----------------------------------------------------------------");
        System.out.println("||------------------------------------------------------------||");
        System.out.println("|| Your are enter the Maze that build using 10x10 blocks.     ||");
        System.out.println("|| x=1 and x=10 are the side walls                            ||");
        System.out.println("|| Start position is x:5 y:1.                                 ||");
        System.out.println("|| These are commands: go, turn right, turn left, where, exit ||");
        System.out.println("||------------------------------------------------------------||");
        System.out.println("----------------------------------------------------------------");

        //PLAY TIMES
        for(int i = 0; i<100; i++)
        {
            //GET USER INPUT UNTIL WIN THE GAME
            if(!player.win)
            {
                //GET USER INPUT
                System.out.print("-> Enter you command: ");
                String get_command = input.nextLine();

                //CALL METHODS ACCORDING TO USER'S INPUTS
                switch (get_command) {
                    case "go" -> player.go();
                    case "turn right" -> player.turn(true);
                    case "turn left" -> player.turn(false);
                    case "where" -> player.where();
                    case "exit" -> i = 100;
                    default ->
                            System.out.println("Invalid command!\nThese are commands: go, turn right, turn left, where, exit");
                }
            }
            else if (player.win)
                i = 100;
        }
    }
}