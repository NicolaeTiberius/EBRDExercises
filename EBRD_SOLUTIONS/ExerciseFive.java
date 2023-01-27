/*Solution created by Nicolae Chelmenciuc: Nth Fibonacci number
* Documentation has been done for understanding purposes and for future re-use */
import java.util.Scanner;

public class ExerciseFive {
    private static long[] fibonacciStorage;

    public static void main(String[] args) {

        //Take user input for calculation
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter integer to calculate fibonacci: ");
        int fibonacciNumber = userInput.nextInt();
        //Stores the number in a long array so that if it is repeated in future it can be accessed faster.
        fibonacciStorage = new long[fibonacciNumber + 1]; //count starts at 0 not 1, so you need an extra for that.
        //Prints out the result by calling upon the fibonacciNumber function.
        System.out.println("The " + fibonacciNumber + "th fibonacci number is: " +fibonacciNumber(fibonacciNumber));

    }
    //Solution is Time: O(N) and Space O(1)

    //Long was chosen for bigger numbers to be able to return as it is 64 bit.
    //The limit of the long data type is the 92nd number.
    //The limit for integer data type is 30th number.


    /** Linear: iterative method explanation
     *
     *If the user enters a number less than 2 then it will always return 1 as the first 2 numbers in the sequence are 1.
     *
     * If the user enters 3:
     *it will iterate twice so that i>n : 1st iteration : result = 2, a =1, b =2 , 2nd iteration: result = 2+1
     *
     * @param n the nth number in the fibonacci sequence
     * @return fibonacci number
     */
    public static long fibonacciNumber(int n){
        //if they enter 0
        if(n<=1){
            return n;
        }
        int result = 1; //stores the fibonacci number result
        int previous = 1; // previous number
        int prevPrevious = 1; //previous previous number
        //starts from 2 -> n because the first 2 fibonacci numbers are 1,1, then it goes to 2,3,5...
        //so if n is 1 or 2 then it will return 1 otherwise if it is bigger than 2 it will do the method e.g. if n is 3.
        for (int i = 2; i <n ; i++) {
            //first iteration i = 2
            result = previous + prevPrevious; //
            //swaps them for next iteration to use previous numbers
            prevPrevious = previous; //previous-previous  number becomes previous number
            previous = result; //previous  number becomes current result (a+b)
        }
        return result;
    }


    /** RECURSIVE METHOD EXPLANATION:
     *
     *
       -Recursion method -> calls the method on itself to return the number.
       -The result is the sum of the 2 preceding numbers so that's why you do n-1 + n-2.
       -Base case is used so recursion doesn't occur infinitely e.g. for f(5) = f(4) +f(3) -> f(4) = f(3)+f(2) -> f(3) = f(2)+f(1)

        To make recursion much faster from it having to  repeat itself each time we use memoization,
        so it remembers the numbers for next time a calculation is done
        and is needed again.

        IT IS TOO SLOW WITH BIGGER NUMBERS COMPARED TO ITERATIVE METHOD AS IT HAS TO KEEP RECURRING OVER TO FIND THE SAME NUMBERS - IT IS FIXED WITH MEMOIZATION
        BUT IT WILL GIVE SAME SPEED AS ITERATIVE METHOD

     // it can be improved to O(1) using golden ratio formula however it is not always reliably that fast
     // compared to this one due to calculating the power of numbers each time.
     @param  n the nth fibonacci value the user would like requested.
     */
    public static long recursiveFibonacciNumber(int n){
        //base case
        if(n<=1) return n;
        //Check if the value has already been used or repeated before by checking the storage.
        //Check if it's not equal to 0 because primitives can never be null.
        //So if the value IS NOT 0 then it means it exists, and it can be returned without re-calculating.
        if(fibonacciStorage[n] !=0){
            return fibonacciStorage[n];
        }
        //Calculating the nth number using the fibonacci formula and stores it as a long type result for larger numbers.
        long fibonacciResult = recursiveFibonacciNumber(n-1)+recursiveFibonacciNumber(n-2); //gets the result of previous fibonacci numbers and adds them together
        //Store the value in the storage for future use and faster calculations.
        fibonacciStorage[n] = fibonacciResult;
        return fibonacciResult;
    }
}
