/*Solution created by Nicolae Chelmenciuc: Closest number distance in array
 * Documentation has been done for understanding purposes and for future re-use */
import java.util.Arrays;

public class ExerciseTwo {
    public static void main(String[] args) {
       /** TEST CASES FOR DEMONSTRATION:
            [1,5,10,2] should return 1
            The method will sort the array to -> 1,2,5,10
            Then calculate the minimum distance of 1,2 and 5,10 and compare it -> min(1,5) = 1

            [1,5,9,14,20,12] should return 2 - > 14 and 12 are the closest and the distance is 2.

            Smallest distance between 2 possible numbers can be 0 (since they could be the same number)
        */
        int[] array1 = {1,5,10,2};
        int[] array2 = {1,5,9,14,20,12};

        System.out.println("Array: "+ Arrays.toString(array1) + "\nMinimum distance: "+TwoClosestDistance(array1));
        System.out.println("Array: "+ Arrays.toString(array2) + "\nMinimum distance: "+TwoClosestDistance(array2));
    }

    /**
     * METHOD EXPLANATION
     *
     * To find the closest numbers you must first sort the array which will make it much more efficient...
     *
     * Quicksort is the best method to sort the array for both small and large data sets.
     *
     * It works by breaking an array  into smaller ones and swapping/flipping the smaller arrays,
     * depending on a comparison with the 'pivot' element picked.
     *
     * ...to calculate the smallest difference as you only need to compare adjacent pairs in one iteration
     * and calculate the minimum at the same time all-in-one loop.
     *
     * @param nums the array that is passed to work out the minimum distance between 2 numbers.
     */
    public static int TwoClosestDistance(int[] nums){

        //Sorting the numbers to be able to compare numbers and then compare the smallest distances.
        Arrays.sort(nums); //sorted at  time O(n log(n) as it is quicksort formula : as the input size grows, the number of operations grows very slowly.
        // and O(1) space as it is 1 array constant space without being changed.
        int closestDistance = Integer.MAX_VALUE;    // instead of using 0 because if smallest distance in array is 1 then cannot retrieve answer to compare.
        //Go through every element in the array.
        //It will stop the loop if the closest distance is 0 otherwise it will keep iterating.
        for (int i = 0; i < nums.length-1 && closestDistance!=0; i++) {
            //distance is calculated by the difference between current and next element in array
            int currentDistance = nums[i+1]-nums[i]; // compares 2 numbers at a time for example 1 and 5 then 5 and 9 etc
            //Calculating the SMALLEST distance by using Math.Min function
            closestDistance = Math.min(currentDistance,closestDistance); // returns the smallest of the 2 values.
        }
        //returns the closest distance value outside the loop to get the final one.
        return closestDistance;
    }





}
