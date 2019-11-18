/**
 * Square class
 *
 * @author Piotr Moszkowicz
 * @version 1.0
 */
public class Square extends Point {
    /**
     * Side of square
     */
    protected double z;

    /**
     * Constructs Square object
     * @param z [double]    -   side of square
     * @param x [double]    -   X coordinate of square corner
     * @param y [double]    -   Y coordinate of square corner
     */
    public Square(double z, double x, double y) {
        super(x, y);
        this.z = z;
    }

    /**
     * Returns name of class
     * @return  [string]    -   name of class
     */
    @Override
    public String getName() {
        return "Square";
    }

    /**
     * Returns string representation of class
     * @return  [string]    -   string representation of class
     */
    @Override
    public String toString() {
        return "Corner = " + super.toString() + "; side = " + this.z;
    }

    /**
     * Returns area of Square
     * @return  [double]    -   Area of square
     */
    @Override
    public double area() {
        return Math.pow(this.z, 2);
    }

    /**
     * Returns volume of Square
     * @return  [double]    -   Volume of square
     */
    @Override
    public double volume() {
        return super.volume();
    }
}
