package OOP.GameProject;

import OOP.GameProject.Map.FireMap;
import OOP.GameProject.Map.MapManager;
import OOP.GameProject.Map.StartMap;

import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class CheckCollision {
    public static boolean CanMove(int x, int y, int width, int height){
        switch (MapManager.map){
            case StartMap -> {
                return StartMap.checkcollision(x,y,width,height);
            }
            case FireMap -> {
                return FireMap.checkcollision(x,y,width,height);
            }
        }
        return false;

    }
}
