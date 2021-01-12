package main.blob;

public class Blob {
    
    public static final int CELL_STATE_FREE = Maze.DEFAULT_CELL_STATE;
    public static final int CELL_STATE_BLOB_FRESH = CELL_STATE_FREE + 1;
    public static final int CELL_STATE_BLOB_DEAD = CELL_STATE_FREE + 2; 
    
    public boolean infest(
        final Maze maze,
        final int x,
        final int y
    ) { 
        maze.setCellState(x, y, Blob.CELL_STATE_BLOB_FRESH);

        if(maze.isGoal(x,y)){
            return true;
        }
        if(!maze.isWallLeft(x,y) && maze.getCellState(x-1,y) == 0 ){
            if(infest(maze,x-1,y)){
                return true;
            }
        }
        if(!maze.isWallRight(x,y) && maze.getCellState(x+1,y) == 0 ){
            if(infest(maze,x+1,y)){
                return true;
            }
        }
        if(!maze.isWallBelow(x,y) && maze.getCellState(x,y+1) == 0 ){
            if(infest(maze,x,y+1)){
                return true;
            }
        }
        if(!maze.isWallAbove(x,y) && maze.getCellState(x,y-1) == 0 ){
            if(infest(maze,x,y-1)){
                return true;
            }
        }

        maze.setCellState(x, y, Blob.CELL_STATE_BLOB_DEAD);
        return false;

    }
    
}