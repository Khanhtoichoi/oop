package OOP.HW2;

public class ReverseString {
    public static String reverse(String s){
        int x = s.length();
        char[] a = s.toCharArray();
        for(int i=0; i<x/2; i++){
            char k = a[i];
            a[i] = a[x-i-1];
            a[x-i-1] = k;
        }
        return new String(a);
    }
    public static void main(String[] args){
        String s = args[0];
        String moi = reverse(s);
        System.out.print(moi);
    }
}
