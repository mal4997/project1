
/**
 * Test program for part one of the project
 * @author: Maggie Lehman
 */
public class TestPartOne {
    public static void main(String[] args) {
        /**
         * Makes sure program does not take command line arguments
         */
        if ( args.length != 0 ) {
            System.err.println( "TestPartOne takes no command line arguments." );
            System.exit( 1 );
        }
        //creates various functions, see the toString output to see what each function tests
        Variable v1 = Variable.X;
        Function f1 = new Sum(v1, v1, new Constant(35), new Constant (0));
        System.out.println("Testing program not out-putting constant 0 : " + f1.toString());
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
        Function f3 = new Sum (v1, v1, v1);
        System.out.println("Testing program with only variable : " + f3.toString());
        System.out.println("Evaluating function at a 10 : " + f3.evaluate(10));
        System.out.println("Evaluating function at 0 : " + f3.evaluate(0));
        System.out.println("Evaluating function at -10 : " + f3.evaluate(-10));
        System.out.println("Derivative : " + f3.derivative());
        Function f4 = new Sum(new Constant(0), new Constant(10), new Constant(99));
        System.out.println("Testing program with only constants : " + f4.toString());
        System.out.println("Evaluating function at a 10 : " + f4.evaluate(10));
        System.out.println("Evaluating function at 0 : " + f4.evaluate(0));
        System.out.println("Evaluating function at -10 : " + f4.evaluate(-10));
        System.out.println("Derivative : " + f4.derivative());
    }
}


