package OOP.GameProject;

public class Dir {
    public static int stand = 0;
    public static int right = 1;
    public static int left = 2;
    public static int up = 4;
    public static int down = 3;
    public static int getDir(int x){
        if(x == 0) return 3;
        else return 6;
    }
}
