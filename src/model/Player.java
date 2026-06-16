package model;

public class Player {

    private String name;
    private int row;
    private int column;
    private Direction direction;
    private int commandCount;

    public Player() {
        this.name = "Player";
        this.row = 0;
        this.column = 4;
        this.direction = Direction.NORTH;
        this.commandCount = 0;
    }

    public Player(String name, int row, int column, Direction direction) {
        this.name = name;
        this.row = row;
        this.column = column;
        this.direction = direction;
        this.commandCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getCommandCount() {
        return commandCount;
    }

    public void increaseCommandCount() {
        commandCount++;
    }

    public void resetPosition() {
        row = 0;
        column = 4;
        direction = Direction.NORTH;
        commandCount = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", row=" + row +
                ", column=" + column +
                ", direction='" + direction + '\'' +
                ", commandCount=" + commandCount +
                '}';
    }
}