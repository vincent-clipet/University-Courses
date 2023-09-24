import java.util.*;

public class Exo6
{

    public static void main(String[] args)
    {

	Scanner scan = new Scanner(System.in);
	//String input = scan.nextLine();
	String input = "Ceci est une phrase de test";

	//BitSet bitset = new BitSet(Character.MAX_VALUE - Character.MIN_VALUE);	
	BitSet bitset = new BitSet();
	
	char[] c = input.toCharArray();
	
	for (char iter : c)
	{
	    if (! bitset.get((int)iter))
		System.out.print(iter + " ");

	    bitset.set((int)iter, true);
	}

	System.out.println("");

    }

}