package OOP.HW2.TetrisGird;

import java.util.Arrays;

public class clearrows {
    private static boolean[][] grid;
    public boolean[][] getGrid() {
        return grid;
    }
    public static void clearRows(){
        int x = grid.length;
        int y = grid[0].length;
        for(int i=0; i<x; i++){
            boolean check = true;
            for(int j=0; j<y; j++){
                if(grid[i][j]!=true){
                    check = false;
                    break;
                }
            }
            if(check){
                for(int k = i; k>0; k--){
                    System.arraycopy(grid[k-1],0,grid[k],0,y);
                }
                Arrays.fill(grid[0],false);
            }
        }
    }
}
