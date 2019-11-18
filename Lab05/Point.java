/**
 * Point class
 *
 * @author Piotr Moszkowicz
 * @version 1.0
 */
public class Point extends Shape {
    /**
     * X coordinate of Point
     */
    protected double x;

    /**
     * Y coordinate of Point
     */
    protected double y;

    /**
     * Constructs Point object
     * @param x [double]    -   X coordinate of point
     * @param y [double]    -   Y coordinate of point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns name of class
     * @return  [string]    -   name of class
     */
    @Override
    public String getName() {
        return "Point";
    }

    /**
     * Returns string representation of class
     * @return  [string]    -   string representation of class
     */
    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }

    /**
     * Returns area of Point
     * @return  [double]    -   Area of point
     */
    @Override
    public double area() {
        return 0.0;
    }

    /**
     * Returns volume of Point
     * @return  [double]    -   Volume of point
     */
    @Override
    public double volume() {
        return 0.0;
    }
}
