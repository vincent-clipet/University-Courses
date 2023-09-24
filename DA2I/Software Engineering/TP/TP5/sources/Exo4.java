import java.util.*;

public class Exo4
{

    public static void main(String[] args)
    {

	Scanner scan = new Scanner(System.in);
	//String input = scan.nextLine();
	String input = "a ccc bb dddd";

	StringTokenizer st = new StringTokenizer(input, " ");
	Stack<String> stack = new Stack<String>();

	while (st.hasMoreTokens())
	{
	    String token = (String)st.nextToken();
	    stack.push(token);
	}

	String inv = "";

	while (! stack.isEmpty())
	    inv += stack.pop() + " ";

	System.out.println(inv);

    }

}