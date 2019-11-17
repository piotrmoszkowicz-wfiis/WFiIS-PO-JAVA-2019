public class Point extends Shape {
    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getName() {
        return "Point";
    }

    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }

    @Override
    public double area() {
        return 0.0;
    }

    @Override
    public double volume() {
        return 0.0;
    }
}
