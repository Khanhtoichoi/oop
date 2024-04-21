package OOP.HW2.StringCode;

import java.util.Scanner;

public class maxrun {
    public static int maxRun(String s){
        int maxi = 0;
        int cnt = 1;
        char[] a = s.toCharArray();
        for(int i=0; i<a.length-1; i++){
            if(a[i]==a[i+1]){
                cnt++;
            }
            else{
                cnt = 1;
            }
            maxi = Math.max(cnt, maxi);
        }
        return maxi;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(maxRun(s));
    }
}
