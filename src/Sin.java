import java.util.ArrayList;

/**
 * Sin function class
 * @author Maggie Lehman
 */
public class Sin extends Function {
    ArrayList<Function> function_terms;

    public Sin(Function...terms){
        super(terms);
        function_terms = new ArrayList<>();
        Function sin = new Product(terms);
        function_terms.add(sin);
    }
    @Override
    public double evaluate(double value) {
        double sum = 0;
        for(Function f: this.terms){
            double temp = f.evaluate(value);
            sum *= temp;
        }
        sum = Math.sin(sum);
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
        final_result = "Sin " + result;
        return final_result;
    }
}
