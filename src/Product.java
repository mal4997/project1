import java.util.ArrayList;

/**
 * Product takes in functions to be multiplied together
 * @author Maggie Lehman
 */
public class Product extends Function {

    /**
     * The arrayList internal representation of the function turns
     */
    ArrayList<Function> function_terms;

    /**
     * The constructor for the product function
     * @param terms - the list of terms to make a sum function of
     */
    public Product(Function...terms){
        function_terms = new ArrayList<>();
        double result = 1;
        for (Function f : terms) {
            if (f.isConstant()) {
                result = result * f.evaluate(1);
            } else {
                function_terms.add(f);
            }
        }
        ArrayList<Function> temp_terms = new ArrayList<>();
        for(Function f : function_terms){
            if(f.isConstant() && f.evaluate(1) == 1 && function_terms.size() > 2){
                temp_terms.add(f);
            }
        }
        if(!temp_terms.isEmpty())
            function_terms = temp_terms;
        if (result != 0.0 && function_terms.size() > 1) {
            function_terms.add(new Constant(result));
        }
        else if(result == 0.0){
            function_terms.clear();
        }
        if (function_terms.isEmpty()) {
            function_terms.add(new Constant(result));
        }

    }

    /**
     * Evaluation of the individual parts of the sum function, and then those multiplied together
     * @param value - the value to evalute the function at
     * @return - the double evaluation
     */
    @Override
    public double evaluate(double value) {
        double sum = 1;
        for(Function f: this.function_terms){
            double temp = f.evaluate(value);
            sum *= temp;
        }
        return sum;
    }

    /**
     * The derivative function of the product funtion
     * @return - the function of the derivative
     */
    @Override
    public Function derivative() {
        ArrayList<ArrayList<Function>> derivative = new ArrayList<>();
        int length = function_terms.size();
        for(int i = 0; i < length; i++){
            derivative.add(new ArrayList<>());
        }
        for(int r = 0; r < length ; r++){
            for(int c = 0; c< length; c++){
                derivative.get(r).add(function_terms.get(c));
            }
        }
        for(int m =  0; m < length; m++){
            derivative.get(m).set(m, derivative.get(m).get(m).derivative());
        }
        Function[] addterms = new Product[length];
        for( int i = 0; i <length; i++){
            addterms[i] = new Product(derivative.get(i).toArray(new Function[0]));

        }
        Function final_deriv = new Sum(addterms);
        return final_deriv;
    }

    /**
     * The integral of the sum function
     * @return  - value of integral
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
     * If there is a non constant in the product function
     * @return - true if all constant/ false otherwise
     */
    @Override
    public boolean isConstant() {
        boolean constant = true;
        for(Function f: this.function_terms) {
            if (!f.isConstant()) {
                return false;
            }
        }
        return constant;
    }

    /**
     * toString representation of the product function
     * @return - string representation of the product function
     */
    @Override
    public String toString() {
        String result = "";
        int counter = 0;
        for(int i = 0; i < function_terms.size(); i++){
            counter ++;
            result += function_terms.get(i).toString();
            if(i <  function_terms.size() -1 ){
                result += " * ";
            }
        }
        //if(counter > 1)
            result = "(" + result + ")";
        return result;
    }
}
