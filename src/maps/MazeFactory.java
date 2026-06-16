package maps;

import model.Maze;

public class MazeFactory {

    public static Maze getMaze(int mazeNumber) {

        switch (mazeNumber) {

            case 1:
                return new Maze(Maze1.MAP, 9, 4);

            case 2:
                return new Maze(Maze2.MAP, 9, 5);

            default:
                return new Maze(Maze1.MAP, 9, 4);

        }

    }

}