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
        super(terms);
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
        if (result != 0.0) {
            function_terms.add(new Constant(result));
        }
        if (function_terms.isEmpty()) {
            function_terms.add(new Constant(0));
        }

    }

    /**
     * Evaluation of the individual parts of the sum function, and then those multiplied together
     * @param value - the value to evalute the function at
     * @return - the double evaluation
     */
    @Override
    public double evaluate(double value) {
        double sum = 0;
        for(Function f: this.terms){
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
        ArrayList<Function> derivative = new ArrayList<>();
        int current_term = 0;
        for(Function f : function_terms){
            ArrayList<Function> temp_deriv = new ArrayList<>();
            ArrayList<Function> function_term_temp = new ArrayList<>();
            temp_deriv.add(f.derivative());
            Function f_temp = new Product(temp_deriv.toArray(new Function [0]));
            for(Function f1 : function_terms){
                function_term_temp.add(f);
            }
            derivative.add(new Product(f_temp, function_term_temp.remove(current_term)));
            current_term ++;
        }
        Function f = new Product(derivative.toArray(new Function[0]));
        return f;
    }

    /**
     * The integral of the sum function
     * @return  - value of integral
     */
    @Override
    public double integral(double lower_bound, double upper_bound, double num_pieces) {
        double final_integral = 0.0;
        for(Function f : function_terms){
            final_integral *= f.integral(lower_bound, upper_bound, num_pieces);
        }
        return final_integral;
    }

    /**
     * If there is a non constant in the product function
     * @return - true if all constant/ false otherwise
     */
    @Override
    public boolean isConstant() {
        boolean constant = true;
        for(Function f: this.terms){
            if(!constant){
                break;
            }
            else{
                constant = f.isConstant();
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
        for(int i = 0; i < function_terms.size(); i++){
            result += function_terms.get(i).toString();
            if(i <  function_terms.size() -1 ){
                result += " * ";
            }
        }
        result = "(" + result + ")";
        return result;
    }
}
