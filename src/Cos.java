import java.util.ArrayList;

public class Cos extends Function {
    ArrayList<Function> function_terms;

    public Cos(Function...terms){
        super(terms);
        function_terms = new ArrayList<>();
        Function cos = new Product(terms);
        function_terms.add(cos);
    }
    @Override
    public double evaluate(double value) {
        double sum = 0;
        for(Function f: this.terms){
            double temp = f.evaluate(value);
            sum *= temp;
        }
        sum = Math.cos(sum);
        return sum;
    }

    @Override
    public Function derivative() {
        ArrayList<Function> temp_function = function_terms;
        Function temp = new Product(temp_function.toArray(new Function[0]));
        Function negative = new Constant(-1);
        Function derivative = new Product((new Sum(new Sin(temp),temp.derivative())), negative);
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

    @Override
    public String toString() {
        String result = "";
        String final_result = "";
        for(int i = 0; i < function_terms.size(); i++){
            result += function_terms.get(i).toString();
        }
        result = "(" + result  +")";
        final_result = "Cos " + result;
        return final_result;
    }
}
