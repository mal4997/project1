import java.util.ArrayList;
import java.util.Arrays;


/**
 * implements the function interface and takes values and adds them together
 * @author Maggie Lehman
 */
public class Sum extends Function {
    ArrayList<Function> function_terms;
    public Sum(Function...terms){
        super(terms);
        function_terms = new ArrayList<>();
        double result = 0;
        for(Function f: terms){
            if(f.isConstant()){
                if(f.evaluate(1) != 0)
                    result += f.evaluate(1);
            }
            else{
                function_terms.add(f);
            }
        }
        Constant sum = new Constant(result);
        function_terms.add(sum);

    }

    @Override
    public double evaluate(double value) {
        double sum = 0;
        for(Function f: this.terms){
            double temp = f.evaluate(value);
            sum += temp;
        }
        return sum;
    }

    @Override
    public Function derivative() {
        ArrayList<Function> derivative = new ArrayList<>();
        for(Function f : this.terms){
            derivative.add(f.derivative());
        }
        Function f = new Sum(derivative.toArray(new Function[0]));
        return f;
    }

    @Override
    public double integral() {
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
        for(int i = 0; i < function_terms.size(); i++){
            result += function_terms.get(i).toString();
            if(i <  function_terms.size() -1 ){
                result += " + ";
            }
        }
        return result;
    }
}
