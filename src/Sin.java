import java.util.ArrayList;

/**
 * Sin function class
 * @author Maggie Lehman
 */
public class Sin extends Function {
    ArrayList<Function> function_terms;

    public Sin(Function...terms){
        function_terms = new ArrayList<>();
        Function sin = new Product(terms);
        function_terms.add(sin);
    }

    @Override
    public double evaluate(double value) {
        double sum = 0;
        for(Function f: this.function_terms){
            double temp = f.evaluate(value);
            sum *= temp;
        }
        sum = Math.sin(sum);
        return sum;
    }

    @Override
    public Function derivative() {
        ArrayList<Function> temp_function = function_terms;
        Function temp = new Product(temp_function.toArray(new Function[0]));
        Function derivative = new Sum(new Cos(temp),temp.derivative());
        return derivative;
    }

    @Override
    public double integral(double lower_bound, double upper_bound, double num_pieces) {
        double integral = 0.0;
        ArrayList<Function> temp_function = function_terms;
        Function function = new Product(temp_function.toArray(new Function[0]));
        double step_distance = (upper_bound - lower_bound) / num_pieces;
        for(double x = lower_bound; x < upper_bound; x += step_distance){
            integral = integral + (step_distance*((function.evaluate(x) + function.evaluate(x + step_distance)) / 2));
        }
        return integral;
    }

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

    @Override
    public String toString() {
        String result = "";
        String final_result = "";
        for(int i = 0; i < function_terms.size(); i++){
            result += function_terms.get(i).toString();
        }
        result = "(" + result  +")";
        final_result = "Sin " + result;
        return final_result;
    }
}
