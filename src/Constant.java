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
    @Override
    public double evaluate(double value) {
        return this.constant_val;
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }

    @Override
    public double integral() {
        return 0;
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public String toString() {
        return Double.toString(constant_val);
    }
}
