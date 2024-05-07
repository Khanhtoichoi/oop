package OOP.GameProject;

import OOP.GameProject.Map.StartMap;

import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class CheckCollision {
    public static boolean CanMove(int x, int y, int width, int height){
        return StartMap.checkcollision(x,y,width,height);
    }
}
