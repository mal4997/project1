import java.util.ArrayList;

/**
 * Sine function class
 * @author Maggie Lehman
 */
public class Sine extends Function {
    /**
     * Array list to represent function terms
     */
    ArrayList<Function> function_terms;

    /**
     * Constructor for Sin
     * @param term - the term to take the sin of
     */
    public Sine(Function term){
        function_terms = new ArrayList<>();
        function_terms.add(term);
    }

    /**
     * Evaluate the sin function at a given value
     * @param value - the value to evaluate it at
     * @return - the value
     */
    @Override
    public double evaluate(double value) {
        double sum = 0;
        for(Function f: this.function_terms){
            double temp = f.evaluate(value);
            sum += temp;
        }
        sum = Math.sin(sum);
        return sum;
    }

    /**
     * Take the derivative of the sin function
     * @return the function derivative
     */
    @Override
    public Function derivative() {
        Function derivative = new Product(new Cosine(function_terms.get(0)),function_terms.get(0).derivative());
        return derivative;
    }

    /**
     * Take the integral using trapezoidal rule
     * @param lower_bound - the lower bound of integration
     * @param upper_bound - the supper bound of integration
     * @param num_pieces - number of trapezoids to integrate with respect to
     * @return - the double result
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
     * Everything in function a constant
     * @return if true / True otherwise false
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
     * ToString representation of the sin function
     * @return - string represenation
     */
    @Override
    public String toString() {
        String result = "";
        String final_result = "";
        for(int i = 0; i < function_terms.size(); i++){
            result += function_terms.get(i).toString();
        }
        final_result = "Sine " + result;
        return final_result;
    }
}
