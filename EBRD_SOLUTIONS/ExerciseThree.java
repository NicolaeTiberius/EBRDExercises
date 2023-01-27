/*Solution created by Nicolae Chelmenciuc: String matcher: REGEX
 * Documentation has been done for understanding purposes and for future re-use */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExerciseThree {
    public static void main(String[] args) {

        //TEST CASES USED FOR DIFFERENT CONSTRAINTS
        System.out.println(matchString("Like a light LIKE A LIGHT like a l1ght!")); //all the cases + special character
        System.out.println(matchString("LikealightLIKEALIGHTlikeal1ght")); //all the cases
        System.out.println(matchString("UPPERCASES")); //upper cases
        System.out.println(matchString("lowercases")); // lower case
        System.out.println(matchString("1234_")); // numbers only
        System.out.println(matchString("_____")); //undercores only
        System.out.println(matchString("Thequickbrownfoxjumped_over2lakes")); // no spaces
        System.out.println(matchString("The quick brown fox jumped")); // with spaces

    }

    /** METHOD EXPLANATION:
        Using Regular expressions to format and match the string
           a-zA-Z0-9 means any lower and uppercase letters and numbers 0-9, then underscore follows.
           ^ means it must match from beginning of string and *$ means to the end of the string.
           Boolean is used to know whether string match is true or false and return specified output.

     @param string the string passed that will be verified if it matches the criteria/constraints.
     @return DOES MATCH if the string matches the constraints  of having at least one or more  uppercase, lowercase, underscore or numbers and NO other form of characters
     DOES NOT MUCH if the string does not match the constraints.
     */
    public static String matchString(String string){
        Pattern pattern = Pattern.compile("^[a-zA-Z_0-9]*$");
        Pattern pattern2 = Pattern.compile("^[\\w]*$"); // any word character -> a-z,A-Z,0-9 and underscores.
//        Used to search to see if that patterns exists in the string or not.
//         uses the pattern to match it with the string
        Matcher match = pattern.matcher(string);
        boolean matches = match.matches();
        Matcher match2 = pattern2.matcher(string);
        boolean matches2 = match2.matches();
        if(matches2) return "String DOES MATCH"; //if it's true.
        else return "String DOES NOT MATCHES"; //else it means it is false.


    }
}
