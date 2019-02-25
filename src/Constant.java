/**
 * The constructor takes the value as its argument, implements the function as a constant
 * @author Maggie Lehman
 */
public class Constant extends Function {
    /**
     * the value of the constant
     */
    double constant_val;

    /**
     * the constructor constant that makes an instance of a constant
     * @param value - the value you want to make a constant
     */
    public Constant(double value){
        this.constant_val = value;
    }

    /**
     * Return the constant evaluated at the value passed in
     * @param value - the value to evaluate at
     * @return - the evaluated constant
     */
    @Override
    public double evaluate(double value) {
        return this.constant_val;
    }

    /**
     * Returns the derivative of any constant, which in this case is 0
     * @return - the derivative of a constant
     */
    @Override
    public Function derivative() {
        return new Constant(0);
    }

    /**
     * Returns the integral of any constant
     * @return - the integral of a constant
     */
    @Override
    public double integral(double lower_bound, double upper_bound, double num_pieces) {
        double result = (upper_bound - lower_bound) * constant_val;
        return result;
    }

    /**
     * If a constant is a constant or not
     * @return - true
     */
    @Override
    public boolean isConstant() {
        return true;
    }

    /**
     * The toString representation of a constant
     * @return - the toString representation of a constant
     */
    @Override
    public String toString() {
        return Double.toString(constant_val);
    }
}
