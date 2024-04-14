package OOP.HW2;

import java.awt.*;

public class Flip {
    public static void main(String[] args){
        Picture picture = new Picture(args[0]);
        int x = picture.width();
        int y = picture.height();
        Picture moi = new Picture(x,y);

        for(int j=0; j<x; j++){
            for(int i=0; i<y/2; i++){
                Color color = picture.get(i,j);
                Color color1 = picture.get(x-i-1,j);
                moi.set(i,j,color1);
                moi.set(x-i-1,j,color);
            }
        }
        moi.show();
    }
}
