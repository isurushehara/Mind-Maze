package service;

import model.Direction;
import model.Maze;
import model.Player;

public class MovementService {

    public boolean moveForward(Player player, Maze maze) {

        int newRow = player.getRow();
        int newColumn = player.getColumn();

        switch (player.getDirection()) {

            case NORTH:
                newRow++;
                break;

            case SOUTH:
                newRow--;
                break;

            case EAST:
                newColumn--;
                break;

            case WEST:
                newColumn++;
                break;

        }

        if (!maze.isValidPosition(newRow, newColumn)) {

            return false;

        }

        if (maze.isWall(newRow, newColumn)) {

            return false;

        }

        player.setRow(newRow);
        player.setColumn(newColumn);

        player.increaseCommandCount();

        return true;

    }

    public void turnRight(Player player) {

        player.setDirection(
                player.getDirection().turnRight());

        player.increaseCommandCount();

    }

    public void turnLeft(Player player) {

        player.setDirection(
                player.getDirection().turnLeft());

        player.increaseCommandCount();

    }

    public boolean hasWon(Player player, Maze maze) {

        return maze.isExit(
                player.getRow(),
                player.getColumn());

    }
}