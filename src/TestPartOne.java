/**
 * Test program for part one of the project
 * @author: Maggie Lehman
 */
public class TestPartOne {
    public static void main(String[] args) {
        if ( args.length != 0 ) {
            System.err.println( "FnTest0 takes no command line arguments." );
            System.exit( 1 );
        }
        Variable v1 = Variable.X;
        Function f1 = new Sum(v1, v1, new Constant(35), new Constant (0));
        System.out.println("Testing program not out-puting constant 0 : " + f1.toString());
        System.out.println("Evaluating function at a 10 : " + f1.evaluate(10));
        System.out.println("Evaluating function at 0 : " + f1.evaluate(0));
        System.out.println("Evaluating function at -10 : " + f1.evaluate(-10));
        System.out.println("Derivative : " + f1.derivative());
        Function f2 = new Sum(v1, v1, new Constant(-10), new Constant(-10));
        System.out.println("Testing program with negatives in function : " + f2.toString());
        System.out.println("Evaluating function at a 10 : " + f2.evaluate(10));
        System.out.println("Evaluating function at 0 : " + f2.evaluate(0));
        System.out.println("Evaluating function at -10 : " + f2.evaluate(-10));
        System.out.println("Derivative : " + f2.derivative());
    }
}


