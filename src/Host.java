/**
 * Authors: J. Huff, Brad S, Riannon C
 * Date 5/5/2022
 * CIS 111B
 */
import java.util.HashMap;

/**
 * Abstract class for student hashmap. Gives access to information from any class
 */
public interface Host {

    HashMap<Integer, String> hostResponses = new HashMap<>();

    public HashMap getHostResponses();
}
