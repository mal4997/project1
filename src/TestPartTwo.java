import java.util.ArrayList;
import java.util.List;

/**
 * Test program for part two of the project
 * @author: Maggie Lehman
 */
public class TestPartTwo {
    public static void main(String[] args) {
        /**
         * Makes sure program does not take command line arguments
         */
        if ( args.length != 0 ) {
            System.err.println( "TestPartTwo takes no command line arguments." );
            System.exit( 1 );
        }
        //creates various functions, see the toString output to see what each function tests
        Variable v = Variable.X;
        List< Function > functions = new ArrayList<>();
        Function p1 = new Product(v, new Constant(0));
        Function p2 = new Product(v, new Constant(11), v , new Constant(3));
        Function p3 = new Product(v, new Sum(v, new Constant(1)), new Constant (4));
        Function p4 = new Product(new Sum(v, new Constant (0)), new Sum(new Constant(10), new Constant(9)));
        Function sin1 = new Sine(new Product(v, new Constant(0)));
        Function sin2 = new Sine(new Product(v, new Constant(11)));
        Function sin3 = new Sine(new Sum(v, new Constant(4)));
        Function sin4 = new Sine(new Product(v, new Sum(v, new Constant(8))));
        Function cos1 = new Cosine(new Product(v, new Constant(0)));
        Function cos2 = new Cosine(new Product(v, new Constant(11)));
        Function cos3 = new Cosine(new Sum(v, new Constant(4)));
        Function cos4 = new Cosine(new Product(v, new Sum(v, new Constant(8))));
        functions.add(p1);
        functions.add(p2);
        functions.add(p3);
        functions.add(p4);
        functions.add(sin1);
        functions.add(sin2);
        functions.add(sin3);
        functions.add(sin4);
        functions.add(cos1);
        functions.add(cos2);
        functions.add(cos3);
        functions.add(cos4);
        int counter = 0;
        for(Function function : functions){
            System.out.println("Function #" + counter + " " + function.toString());
            counter++;
            System.out.println( function + " is " +
                    ( function.isConstant() ? "" : "not " ) +
                    "a constant." );
            System.out.println( "The derivative of " + function +
                    " is " + function.derivative() +
                    ", which is " +
                    ( function.derivative().isConstant() ? "" : "not " ) +
                    "a constant." );
        }
        System.out.println("x     " + "fn#1     " + "fn#2     " + "fn#3     " + "fn#4     " + "fn#5     " + "fn#6     " + "fn#7     " +
                "fn#8     " + "fn#9     " + "fn#10    " + "fn#11     " + "fn#12");
        System.out
                .println( "==============================================================================================================" );
        for ( double x = 0; x <= Math.PI; x += 0.1 ) {
            System.out.printf("%4.2f", x);
            for (Function f : functions) {
                System.out.printf(" %8.4f", f.evaluate(x));
            }
            System.out.println();
        }
    }
}
