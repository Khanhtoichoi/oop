package OOP.HW2;

public class Point {
    private double x;
    private double y;
    Point(double a, double b){
        this.x = a;
        this.y = b;
    }
    public double distance(Point q){
        double dx = this.x - q.x;
        double dy = this.y - q.y;
        return(Math.sqrt(dx*dx+dy*dy));
    }
    public String toString(){
        return "("+x+","+y+")";
    }
}
