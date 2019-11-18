/**
 * Cube class
 *
 * @author Piotr Moszkowicz
 * @version 1.0
 */
public class Cube extends Square {
    /**
     * Constructs Cube object
     * @param z [double]    -   depth of cube
     * @param x [double]    -   X coordinate of cube corner
     * @param y [double]    -   Y coordinate of cube corner
     */
    public Cube(double z, double x, double y) {
        super(z, x, y);
    }

    /**
     * Returns name of class
     * @return  [string]    -   name of class
     */
    @Override
    public String getName() {
        return "Cube";
    }

    /**
     * Returns string representation of class
     * @return  [string]    -   string representation of class
     */
    @Override
    public String toString() {
        return super.toString() + "; depth = " + this.z;
    }

    /**
     * Returns area of Cube
     * @return  [double]    -   Area of cube
     */
    @Override
    public double area() {
        return 6 * super.area();
    }

    /**
     * Returns volume of Cube
     * @return  [double]    -   Volume of cube
     */
    @Override
    public double volume() {
        return Math.pow(this.z, 3);
    }
}
