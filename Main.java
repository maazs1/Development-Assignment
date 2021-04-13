import java.util.*; 

public class Main
{

  public static void findPalindrome (String inputStr)
  {
    /** The variable flag is initialized to true. Flag check will help determine if a palindrome is found **/
    boolean flag = true;

    /** The variable previous is initially set to 0 but it will store the last position of the most recent palindrome string.
     *  This will help avoid finding palindrome string within each other **/
    int previous = 0;

    /** Initializing ArrayList to store Palindrome objects **/
    ArrayList<Palindrome> palindromeArray = new ArrayList<Palindrome>();

    /** The first for loop will traverse through the inputStr starting from the first position **/
    for (int i = 0; i < inputStr.length(); i++) {

        /** The second for loop will traverse through the inputStr from the last position while j is greater than i. For each
         *  iteration, it will compare values between the i and j position **/
        for (int j = inputStr.length()-1; j > i; j--) {

            /** If there is a match between the values for positions i and j, set the flag to true (in case it was initialized 
             *  to false from the previous iteration) and continue inside the if-statement block. The if statement also checks to
             *  ensure the position of j is greater than the variable previous (the last position of the previous palindrome
             *  string). As mentioned before, this will help avoid finding a palindrome string within each other. 
             *  Ex. It will not return "BCB" from the string "ABCBA" **/
            if (inputStr.charAt(i) == inputStr.charAt(j) && j>previous) {
                flag=true;

                /** Traverse through the substring of inputStr between positions i and j. Initialize variable startPosition
                 *  to i and variable endPosition to j. Iterate through the substring by incrementing startPosition and decrementing 
                 *  endPosition while the startPosition is smaller than or equal to the endPosition. For each iteration, compare values
                 *  in position startPosition and endPosition **/
                for (int startPosition = i, endPosition = j; startPosition <= endPosition; startPosition++, endPosition--) {

                    /** If the values at position startPosition and endPosition are not the same, set the flag to false and 
                     *  break the for loop **/
                    if (!(inputStr.charAt(startPosition) == inputStr.charAt(endPosition))) {
                        flag = false;
                        break;
                    }
                }

                /** If the flag remains true, it means the previous for loop was successfully completed and a palindrome was found. A
                 *  Paldinrome object is creating storing the palindrome string, start position, and size. The Palindrome object is 
                 *  then stored into the palindromeArray ArrayList. Previous is set to the last position of the palindrome and the 
                 *  program breaks out of the second for loop **/
                if (flag) {
                    String palindrome = String.join("", inputStr.substring(i,j+1));
                    Integer start = i;
                    Integer size = palindrome.length();
                    palindromeArray.add(new Palindrome(palindrome, start, size));
                    previous = j;
                    break;
                }
            }
        }
    }

    /** Sorting the palindromeArray ArrayList by the palindrome size in descending order and outputting the results **/
    Collections.sort(palindromeArray);
    for (Palindrome p : palindromeArray) {
        System.out.println(p.palindrome+","+p.start+","+p.size);
    }
  }

  public static void main (String[] args)
  {
      
    /** Initialize the inputStr varaible **/
    String inputStr = "ABCBAHELLOHOWRACECARAREYOUILOVEUEVOLIIAMAIDOINGGOOD";

    /**Calling findPalindrome function. Ensuring the string is all uppercase without any special
     * characters **/
    findPalindrome(inputStr.replaceAll("[^a-zA-Z0-9]","").toUpperCase());

  }
}
