package Functions;

import java.util.ArrayList;

/**
 * implements the function interface and takes values and adds them together
 * @author Maggie Lehman
 */
public class Sum extends Function {

    /**
     * The arrayList of all the function terms
     */
    ArrayList<Function> function_terms;

    /**
     * The Constructor for the sum of multiple functions
     * @param terms - the terms to make a sum of
     */
    public Sum(Function...terms){
        function_terms = new ArrayList<>();
        double result = 0;
        for(Function f: terms){
            if(f.isConstant() && f.evaluate(0) ==0) {
            }
             else if(f.isConstant()){
                 result += f.evaluate(1);
            }
            else{
                function_terms.add(f);
            }
        }
        if (result != 0.0) {
            Constant sum = new Constant(result);
            function_terms.add(sum);
        }
        if (function_terms.isEmpty()){
            Constant zero = new Constant(0);
            function_terms.add(zero);
        }

    }

    /**
     * Evaluate the sum function at a given value, by calling evaluate on each individual part
     * @param value - the value to evaluate at
     * @return - the double of the evaluated sum
     */
    @Override
    public double evaluate(double value) {
        double sum = 0;
        for(Function f: this.function_terms){
            double temp = f.evaluate(value);
            sum += temp;
        }
        return sum;
    }

    /**
     * The derivative of a sum function by calling all the individual parts derivative functions
     * @return - the function of the derivative
     */
    @Override
    public Function derivative() {
        ArrayList<Function> derivative = new ArrayList<>();
        for(Function f : function_terms){
            derivative.add(f.derivative());
        }
        Function f = new Sum(derivative.toArray(new Function[0]));
        return f;
    }

    /**
     * The integral of the sum function
     * @return - the integral
     */
    @Override
    public double integral(double lower_bound, double upper_bound, double num_pieces) {
        double final_integral = 0.0;
        for(Function f : function_terms){
            final_integral += f.integral(lower_bound, upper_bound, num_pieces);
        }
        return final_integral;
    }

    /**
     * If a sum function contains any non-constants
     * @return - true if it contains only constants, false otherwise
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
     * toString representation of the sum function, with the correct symbols
     * @return - the string representation
     */
    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < function_terms.size(); i++){
            result += function_terms.get(i).toString();
            if(i <  function_terms.size() -1 ){
                result += " + ";
            }
        }
        result = "(" + result + ")";
        return result;
    }
}
