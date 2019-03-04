import java.util.ArrayList;

/**
 * Cosine class function
 * @author: Maggie Lehman
 */
public class Cosine extends Function {
    /**
     * Array list representation of the function terms
     */
    ArrayList<Function> function_terms;

    /**
     * Constructor for the function terms class
     * @param terms - the terms to take the cos of
     */
    public Cosine(Function terms){
        function_terms = new ArrayList<>();
        function_terms.add(terms);
    }

    /**
     * Evaluate the cos function at a given value
     * @param value - where to evaluate
     * @return - the double result
     */
    @Override
    public double evaluate(double value) {
        double sum = 0;
        for(Function f: this.function_terms){
            double temp = f.evaluate(value);
            sum += temp;
        }
        sum = Math.cos(sum);
        return sum;
    }

    /**
     * The derivative of the cos function
     * @return - the function derivative
     */
    @Override
    public Function derivative() {
        Function negative = new Constant(-1);
        Function derivative = (new Product(new Sine(function_terms.get(0)),function_terms.get(0).derivative(), negative));
        return derivative;
    }

    /**
     * Find the integral of the cos fucntion
     * @param lower_bound - the lower bound of integration
     * @param upper_bound - the supper bound of integration
     * @param num_pieces - number of trapezoids to integrate with respect to
     * @return - the double integral value
     */
    @Override
    public double integral(double lower_bound, double upper_bound, double num_pieces) {
        double integral = 0.0;
        ArrayList<Function> temp_function = function_terms;
        Function function = new Product(temp_function.toArray(new Function[0]));
        double step_distance = (upper_bound - lower_bound) / num_pieces;
        for(double x = lower_bound; x < upper_bound; x += step_distance){
            integral = integral + (step_distance*((function.evaluate(x) + function.evaluate(x + step_distance))
                    / 2));
        }
        return integral;
    }

    /**
     * Is everything in cos a consatnt
     * @return - true if true otherwise false
     */
    @Override
    public boolean isConstant() {
        boolean constant = true;
        for(Function f: this.function_terms){
            if(!f.isConstant()) {
                return false;
            }
        }
        return constant;

    }

    /**
     * The toString representation of the cos function
     * @return - the string representation
     */
    @Override
    public String toString() {
        String result = "";
        String final_result = "";
        for(int i = 0; i < function_terms.size(); i++){
            result += function_terms.get(i).toString();
        }
        result = "(" + result  +")";
        final_result = "Cosine " + result;
        return final_result;
    }
}
