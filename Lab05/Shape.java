/**
 * Shape class
 *
 * @author Piotr Moszkowicz
 * @version 1.0
 */
public abstract class Shape {
    /**
     * Returns name of class
     * @return  [string]    -   name of class
     */
    public abstract String getName();

    /**
     * Returns area of Shape
     * @return  [double]    -   Area of shape
     */
    public abstract double area();

    /**
     * Returns volume of Shape
     * @return  [double]    -   Volume of shape
     */
    public abstract double volume();
}
