import java.util.*;

public class Exo8
{

    public static void main(String[] args)
    {
	String input = "Ceci est une phrase de test speciale HashSet";
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	
	char[] c = input.toCharArray();
	
	for (char iter : c)
	{
	    Character currentChar = new Character(iter);

	    int i = (map.containsKey(currentChar) ? map.get(currentChar) : 1);
	    map.put(currentChar, i);
	}

	System.out.println("");

    }

}