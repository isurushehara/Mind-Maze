package model;

public class Maze {

    private int[][] grid;
    public static final int PATH = 0;
    public static final int WALL = 1;

    private int exitRow;

    private int exitColumn;

    public Maze(int[][] grid,
                int exitRow,
                int exitColumn){

        this.grid=grid;
        this.exitRow=exitRow;
        this.exitColumn=exitColumn;

    }

    public int[][] getGrid(){

        return grid;

    }

    public int getRowCount(){

        return grid.length;

    }

    public int getColumnCount(){

        return grid[0].length;

    }

    public boolean isValidPosition(int row,int column){

        return row>=0 &&
                row<getRowCount() &&
                column>=0 &&
                column<getColumnCount();

    }

    public boolean isWall(int row,int column){

        return grid[row][column]==WALL;

    }

    public boolean isPath(int row,int column){

        return grid[row][column]==PATH;

    }

    public boolean isExit(int row,int column){

        return row==exitRow &&
                column==exitColumn;

    }

    public void printMaze(){

        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[i].length;j++){

                System.out.print(grid[i][j]+" ");

            }

            System.out.println();

        }

    }

}