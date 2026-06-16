package main;

import maps.MazeFactory;
import model.Maze;

public class Main {

    public static void main(String[] args) {

        Maze maze = MazeFactory.getMaze(1);

        maze.printMaze();

    }

}