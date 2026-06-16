package model;

public class Score {

    private int id;
    private int userId;
    private int mazeNumber;
    private int commands;
    public Score() {
    }

    public Score(int id,
                 int userId,
                 int mazeNumber,
                 int commands) {

        this.id = id;
        this.userId = userId;
        this.mazeNumber = mazeNumber;
        this.commands = commands;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMazeNumber() {
        return mazeNumber;
    }

    public void setMazeNumber(int mazeNumber) {
        this.mazeNumber = mazeNumber;
    }

    public int getCommands() {
        return commands;
    }

    public void setCommands(int commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {

        return "Score{" +
                "maze=" + mazeNumber +
                ", commands=" + commands +
                '}';

    }

}