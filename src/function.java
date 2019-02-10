/**
 * abstract class function, to represent and build other classes from
 * @author: Maggie Lehman
 */
public abstract class Function {

    /**
     * Given a double floating point value of x, compute the value of the function
     * @return - The result as a double
     */
    public abstract double evaulate();

    /**
     * Return a human-readable expression of the function as a Java String. Functions using an infix
     * operator with two or more operands must include parentheses
     * @return - A function that is the derivative
     */
    public abstract Function derivative();

    /**
     * Compute the value of the definite integral of the function with respect to x over a
     * given interval. The interval is expressed by two double arguments. For all byt the simplest functions
     * the integral has to be computed numerically using trapezoid rule, so the number of trapezoids (i.e.
     * the granularity of the calculation is allso given in case it is needed.
     * @return - the area underneath the function as a double
     */
    public abstract double integral();

    /**
     * Answer whether or not this function is constant (including if is is a combination of other constants)
     * @return - boolean T/F
     */
    public abstract boolean isConstant();
    /**
     * return a human-readable expression of the function as a Java String. Functions using
     * an infix operator with two or more operands must include parentheses.
     * @return - The function as a readable string
     */
    public abstract String toString();


}
