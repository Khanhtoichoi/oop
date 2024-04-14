package OOP.HW2;

import java.awt.*;

public class RGB {
    public static void main(String[] args){
        Picture picture = new Picture(args[0]);
        int x = picture.width();
        int y = picture.height();
        Picture R = new Picture(x,y);
        Picture G = new Picture(x,y);
        Picture B = new Picture(x,y);
        for(int i =0; i<x; i++){
            for(int j=0; j<y; j++){
                Color color = picture.get(i,j);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                R.set(i,j,new Color(r,0,0));
                G.set(i,j,new Color(0,g,0));
                B.set(i,j,new Color(0,0,b));
            }
        }
        R.show();
        G.show();
        B.show();
    }
}
