public class Cube extends Square {
    public Cube(double z, double x, double y) {
        super(z, x, y);
    }

    @Override
    public String getName() {
        return "Cube";
    }

    @Override
    public String toString() {
        return super.toString() + "; depth = " + this.z;
    }

    @Override
    public double area() {
        return 6 * super.area();
    }

    @Override
    public double volume() {
        return Math.pow(this.z, 3);
    }
}
