package shape;

public class Rectangle {
    private final double length;
    private final double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double calculateArea(){
        return this.length * this.breadth;
    }

    public double calculatePerimeter(){
        return 2 * (this.length + this.breadth);
    }
}
