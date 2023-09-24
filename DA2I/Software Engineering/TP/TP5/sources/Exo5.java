import java.util.*;

public class Exo5
{

    public static void main(String[] args)
    {

	Scanner scan = new Scanner(System.in);
	//String input = scan.nextLine();
	String input = "Ceci est une phrase de test";
	String ret = "";

	StringTokenizer st = new StringTokenizer(input, " ");
	Stack<String> stack = new Stack<String>();

	while (st.hasMoreTokens())
	{
	    String token = (String)st.nextToken();
	    String newWord = "";

	    for (int i = token.length() - 1; i >= 0; i--)
		newWord += token.charAt(i);

	    ret += newWord + " ";
	}
	
	System.out.println(ret);

    }

}