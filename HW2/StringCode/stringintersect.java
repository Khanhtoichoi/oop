package OOP.HW2.StringCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class stringintersect {
    public static boolean stringIntersect(String a, String b, int len){
        HashSet<String> h = new HashSet<>();
        for(int i=0; i<a.length(); i++){
            h.add(a.substring(i,i+len));
        }
        for(int i=0; i<b.length(); i++){
            if(h.contains(b.substring(i,i+len))) return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int len = sc.nextInt();
        System.out.print(stringIntersect(a,b,len));
    }
}
