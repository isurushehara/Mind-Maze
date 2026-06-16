package model;

public enum Direction {

    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction turnRight() {

        Direction[] directions = values();

        return directions[(this.ordinal() + 1) % directions.length];

    }

    public Direction turnLeft() {

        Direction[] directions = values();

        return directions[
                (this.ordinal() - 1 + directions.length)
                        % directions.length
                ];

    }

}