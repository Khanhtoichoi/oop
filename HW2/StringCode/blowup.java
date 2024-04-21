package OOP.HW2.StringCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class blowup {
    public static String Blowup(String s){
        char[] a = s.toCharArray();
        String ss = "";
        for(int i=0; i<a.length-1; i++){
            if(Character.isDigit(a[i])){
                int tmp = a[i]-'0';
                for(int j=0; j<tmp; j++){
                    ss = ss+a[i+1];
                }
            }
            else ss = ss + a[i];
        }
        if(!Character.isDigit(a[a.length-1])) ss = ss+a[a.length-1];
        return ss;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(Blowup(s));
    }
}
