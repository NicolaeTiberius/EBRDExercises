/*Solution created by Nicolae Chelmenciuc: Future investment value
 * Documentation has been done for understanding purposes and for future re-use */
import java.util.Scanner;

public class ExerciseFour {
    public static void main(String[] args) {
        //User input for the function to calculate what they need.
        Scanner userInput = new Scanner(System.in);
        System.out.print("Input the investment amount: ");
        double investAmount = userInput.nextDouble();
        System.out.print("Input the rate of interest: ");
        //calculates the monthly interest rate from yearly interest.
        double monthlyInterestRate = userInput.nextDouble()/1200; //monthly rate (per year it would be /100 but for each month it is 100*12=1200
        System.out.print("Input number of years: ");
        int years = userInput.nextInt();
        //Returns the investment value for the specified number of years.
        //Uses year to show how the interest changes each year until it meets the number of years needed.
        System.out.println("Year:   Future investment value:");
        for (int year = 1; year <=years ; year++) {
            System.out.print(year+"        ");
            System.out.printf("%1.2f\n" , futureInvestmentValue(investAmount, monthlyInterestRate, year));
        }

    }
    /**METHOD EXPLANATION

     //To calculate monthly compound interest the mathematical formula is  amount * (1+ RATE/100 (but since its monthly it is 1200))^time*12(monthly)

     Test Case: amount:1000, rate: 10, years:5

     1st year: 1000* (1+(10/1200)^(12 months) -> 1000* 1.10471306744 =  1104.71

     * @param investmentAmount the amount the user would like to invest at the start.
     * @param interestRate     the rate of interest they are being charged with. It is monthly so years is * 12
     * @param years            the duration they are borrowing and when it will be paid back.
     * @return the future investment value after calculating with the amount, interest rate and years.
     */


//     investment value * (1 + interest rate) ^ (to the power of) total months (years*12)
//     * years * 12 -> so it gets the total interest as it is monthly compounded
//     * so it will use overall months for the years specified.
    public static double futureInvestmentValue(double investmentAmount, double interestRate, int years) {
        return investmentAmount * Math.pow(1 + interestRate, (years * 12));
    } }




//OLD METHOD THAT WAS FOR PRACTICE BUT WAS WRONG FORMULA.
//   * It will iterate/loop through the total amount of months (years inputted * 12) since it is monthly compounded data
//           *The initial investment value will increase by the interest amount every iteration, it will use the updated investmentAmount each time in the loop
//           *amount = amount + (the % interest amount of the total value)
//           * e.g. start at 1000 with an interest of 10% for 1 year:
//           * 1st month the investment value will be 1100
//           * 2nd month it will be 1210
//           * 3rd month it will be 1331 (1210 + 121)
//    public static double futureInvestmentValue(double investmentAmount, double interestRate, int years) {
//        for (int i = 0; i < years * 12; i++) {
//            investmentAmount = investmentAmount + (investmentAmount * (interestRate / 10));
//        }
//        return investmentAmount;
//
//    }


