/**
 * The constructor takes no argument, since the only variable allowed is x. There
 * should only be one instance of Variable. Therefore, the constructor is private and there is a public
 * final static instance of Variable within the Variable class. The instance's name should be x
 * @author Maggie Lehman
 */
public class Variable extends Function {

    /**
     * The representation of the variable, as x
     */
    public final static Variable X = new Variable();

    /**
     * Defult constructor for variable
     */
    private Variable() {
    }

    /**
     * Evaluates the variable x at a given value
     * @param value - the value to evaluate x at
     * @return - will always just be the value
     */
    @Override
    public double evaluate(double value) {
        return value;
    }

    /**
     * Return the derivative of a variable
     * @return - the derivative, which will always be one
     */
    @Override
    public Function derivative() {
        return new Constant(1);
    }

    /**
     * Returns the integral of a constant
     * @return - the integral
     */
    @Override
    public double integral(double lower_bound, double upper_bound, double num_pieces) {
        double result = (upper_bound - lower_bound) * upper_bound;
        return result / 2;
    }

    /**
     * Returns if a variable is a constant
     * @return - false
     */
    @Override
    public boolean isConstant() {
        return false;
    }

    /**
     * The toString representation of a variable
     * @return - the string "X"
     */
    @Override
    public String toString() {
        return "X";
    }
}
