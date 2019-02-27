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
        return null;
    }

    @Override
    public double integral(double lower_bound, double upper_bound, double num_pieces) {
        return 0;
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
