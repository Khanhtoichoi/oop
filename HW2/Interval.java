package OOP.HW2;

public class Interval {
    private double left;
    private double right;
    Interval(int x, int y){
        this.left = x;
        this.right = y;
    }
    public boolean contains(double x){
        if(x>=left && x<=right) return true;
        else return false;
    }
    public boolean intersects(Interval b){
        if(this.right < b.left) return false;
        if(this.left > b.right) return false;
        return true;
    }
    public String toString(){
        return "["+left + "," + right +"]";
    }
}
