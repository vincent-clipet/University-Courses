import java.util.*;

public class Exo7
{

    public static void main(String[] args)
    {
	String input = "Ceci est une phrase de test speciale HashSet";
	HashSet<Character> set = new HashSet<Character>();
	
	char[] c = input.toCharArray();
	
	for (char iter : c)
	{
	    if (set.add(new Character(iter)))
		System.out.print(iter + " ");
	}

	System.out.println("");

    }

}