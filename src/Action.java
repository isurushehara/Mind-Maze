public class Action {

    //CHECK WIN OR NOT
    boolean win = false;
    //COUNT THE COMMANDS
    int command_count = 0;

    //MAP DETAILS
    int map_count = 2;
    //MAP 1
    int[][] map_1 = {
            {1,1,1,1,0,1,1,1,1,1},
            {1,0,1,0,0,0,1,0,0,1},
            {1,0,1,0,1,0,1,1,0,1},
            {1,0,0,0,1,1,1,0,0,1},
            {1,1,1,0,0,0,0,0,1,1},
            {1,0,0,1,1,1,1,0,1,1},
            {1,0,0,1,0,0,0,0,1,1},
            {1,0,1,1,0,1,1,0,1,1},
            {1,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,0,1,1,1,1,1}};

    //MAP 2
    int [][] map_2 = {
            {1,1,1,1,0,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
    };

    //MAP SELECTION
    int map_no;


    int[][] map;
    int row = 0, column = 4; //DEFAULT
    int position_value = map[row][column];

    //TURN ACTIONS
    //VARIABLES
    String[] array_direction = {"north","east","south","west"};
    int dir_turn = 0; //DEFAULT
    String direction = array_direction[dir_turn];

    //TURN ACTION METHOD (TRUE MEAN TURN RIGHT)
    void turn(boolean turn){
        if(turn && dir_turn != 3)
            dir_turn++;
        else if(turn && dir_turn == 3)
            dir_turn = 0;
        else if(!turn && dir_turn != 0)
            dir_turn--;
        else if(!turn && dir_turn == 0)
            dir_turn = 3;

        direction = array_direction[dir_turn];
        command_count++;
    }

    //FORWARD ACTION METHOD
    void go(){
        switch (direction){
            case "north":
                row++;
                if(map[row][column] == 1)
                {
                    System.out.println("Can't go, there is a wall");
                    row--;
                }
                else if(map[row][column] == 0 && row==9 && column==4)
                {
                    System.out.println("Congratulations! You are free.");
                    System.out.println("You use " +command_count +" commands.");
                    win = true;

                }
                else if(map[row][column] == 0)
                {
                    System.out.println("Way is clear and go");
                }
                break;

            case "east":
                column--;
                if(map[row][column] == 1)
                {
                    System.out.println("Can't go, there is a wall");
                    column++;
                }
                else if(map[row][column] == 0 && row==9 && column==4)
                {
                    System.out.println("Congratulations! You are free.");
                    System.out.println("You use " +command_count +" commands.");
                    win = true;
                }
                else if(map[row][column] == 0)
                {
                    System.out.println("Way is clear and go");
                }
                break;

            case "south":
                row--;
                if(map[row][column] == 1)
                {
                    System.out.println("Can't go, there is a wall");
                    row++;
                }
                else if(map[row][column] == 0 && row==9 && column==4)
                {
                    System.out.println("Congratulations! You are free.");
                    System.out.println("You use " +command_count +" commands.");
                    win = true;
                }
                else if(map[row][column] == 0)
                {
                    System.out.println("Way is clear and go");
                }
                break;

            case "west":
                column++;
                if(map[row][column] == 1)
                {
                    System.out.println("Can't go, there is a wall");
                    column--;
                }
                else if(map[row][column] == 0 && row==9 && column==4)
                {
                    System.out.println("Congratulations! You are free.");
                    System.out.println("You use " +command_count +" commands.");
                    win = true;
                }
                else if(map[row][column] == 0)
                {
                    System.out.println("Way is clear and go");
                }
                break;
        }
        command_count++;
    }

    //LOCATION METHOD
    void where() {
        int relative_column = 9 - column;
        int relative_row = row + 1;
        System.out.println("Direction:" +direction +"\nx:" +relative_column +" y:" +relative_row);
        command_count++;
    }

}
