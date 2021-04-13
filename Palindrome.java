/** Palindrome class to store string, starting position, and size of a palindrome. Implementing 
 * Java Comparable Interface to override the compareTo Function **/
public class Palindrome implements Comparable<Palindrome>
{
    String palindrome;
    Integer start;
    Integer size;

    /** Constructor to instantiate the object **/
    public Palindrome(String palindrome, Integer start, Integer size)
    {
        this.palindrome = palindrome;
        this.start = start;
        this.size = size;
    }

    /** Getter to retrieve the size of the object **/
    public Integer getSize()
    {
        return size;
    }

    /** Overriding the compareTo function to order by size of the Palindrome object in descending order **/
    @Override
    public int compareTo(Palindrome palindrome)
    {
        return palindrome.getSize()-this.size;
    }
}