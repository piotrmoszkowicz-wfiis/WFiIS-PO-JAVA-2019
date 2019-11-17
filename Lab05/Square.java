public class Square extends Point {
    protected double z;

    public Square(double z, double x, double y) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public String toString() {
        return "Corner = " + super.toString() + "; side = " + this.z;
    }

    @Override
    public double area() {
        return Math.pow(this.z, 2);
    }

    @Override
    public double volume() {
        return super.volume();
    }
}
