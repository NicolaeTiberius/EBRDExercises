public class ExerciseOne {
    public static void main(String[] args) {
        // Define the initial values for the endpoints a and b, tolerance TOL, and maximum number of iterations No
        double a ,b, TOL;
        a = 1;
        b = 2;
        TOL = 0.0001;
        //maximum iterations
        int No = 15;
        //Printing the result
        findRoot(a,b,TOL,No);

    }
    /**
     * The function to be evaluated, f(x) = x^3 + 4x^2 - 10, to then work out the root for it.
     *
     * @param x the input value
     * @return the function value at x
     *
     */
    public static double equationFunction(double x){
        return Math.pow(x, 3) + (4 * Math.pow(x, 2)) - 10;
    }

    /**
     * Method to perform the root algorithm
     *
     * @param a the left endpoint
     * @param b the right endpoint
     * @param TOL the tolerance for the solution : absolute value of the difference between the actual root of the function x and the approximation c.
     * @param No the maximum number of iterations
     * @return the approximate solution, or failed during the max amount of iterations
     *
     * you can have many solutions -probably 3 ..so thats why you must iterate a couple of times for better accuracy.
     */
    public static void findRoot(double a, double b, double TOL, int No){
        // STEP 1:  Compute the value of the function at the left endpoint
        double fa = equationFunction(a); // f(1) = 1^3 + (4*1^2)-10
        // Initialize the iteration counter
        int i = 1;
        // STEP 2:  Begin the algorithm
        while (i <= No) { // 1 <= 15
            //STEP 3: Compute the midpoint and the value of the function at the midpoint

            //At each step the method divides the interval in two parts/halves by computing the midpoint of the interval
            // and the values of the function f(x) at that point.
            // If x itself is a root then the process has succeeded and stops.

            double p = (a + b) / 2; // performs binary search so this would be an o(Log n) time complexity solution -> p = (1+2)/2 = 1.5
            double fp = equationFunction(p); // f(1.5) = 1.5^3 + (4*1.5^2)-10 = 2.375
//            System.out.println(p); // debugging purposes -> shows the result of p at each iteration
            //IF IT'S NEGATIVE
            //STEP 4: Check if the midpoint is the solution or if the tolerance has been met - if it is equal to the root or not.
            if (fp == 0 || Math.abs(b - a) / 2 < TOL) { //fp (2.375) != 0 or 1.5 < 0.00001
                // Return the midpoint as the approximate solution // PROCEDURE COMPLETED SUCCESSFULLY
                System.out.println("Approximate solution: " + p);
                System.out.println("Procedure completed successfully");
                return;

            }
            //STEP 5: Increment the iteration counter to move on to the next iteration
            i++;
            //STEP 6:  Check the sign of the function at the endpoints and the midpoint.
            //IF IT IS POSITIVE THEN REPLACE A
            if (fa * fp > 0) {
                // Update the left endpoint and the function value at the left endpoint
                a = p;
                fa = fp;
                //IF NEGATIVE THEN REPLACE B
            } else {
                // Update the right endpoint
                b = p;
            }
        }
        //STEP 7: If the method has not been successful after the maximum number of iterations.
        System.out.println("Method failed after " + No + " iterations");
        System.out.println("The procedure was unsuccessful");
    }
}

