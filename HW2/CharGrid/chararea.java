package OOP.HW2.CharGrid;

public class chararea {
    char [][] grid = {
            {'c','a','x'},
            {'b',' ','b'},
            {' ',' ','a'}
    };

    public int charArea(char a){
        int x = grid.length;
        int y = grid[0].length;
        int min_length = x;
        int max_length = 0;
        int min_width = y;
        int max_width = 0;
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(grid[i][j]==a){
                    min_width = Math.min(min_width,j);
                    max_width = Math.max(max_length,j);
                    min_length = Math.min(min_length,i);
                    max_length = Math.max(max_length,i);
                }
            }
        }
        return (max_width - min_width + 1) * (max_length - min_length + 1);
    }
}
