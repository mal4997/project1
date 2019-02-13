import java.util.Iterator;
import java.util.TreeSet;

/**
 * implements the function interface and takes values and adds them together
 * @author Maggie Lehman
 */
public class Sum extends Function {

    Sum s = new Sum();
    public Sum(Function...terms){
        TreeSet sum = new TreeSet();
        //Iterator i = terms.iterator();
    }

    @Override
    public double evaluate(double value) {
        return value;
    }

    @Override
    public Function derivative() {
        return null;
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
        return null;
    }
}
