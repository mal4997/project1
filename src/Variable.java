/**
 * The constructor takes no argument, since the only variable allowed is x. There
 * should only be one instance of Variable. Therefore, the constructor is private and there is a public
 * final static instance of Variable within the Variable class. The instance's name should be x
 * @author Maggie Lehman
 */
public class Variable extends Function {

    public final static Variable v = new Variable();

    private Variable() {
        t.add(v);
    }

    @Override
    public double evaluate(double value) {
        return 0;
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
        return false;
    }

    @Override
    public String toString() {
        return "X";
    }
}
