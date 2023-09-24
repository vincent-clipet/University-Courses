import java.util.Scanner;
import java.util.StringTokenizer;

public class Exo1
{

    public static void main(String[] args)
    {

	Scanner scan = new Scanner(System.in);
	//String input = scan.nextLine();
	String input = "jhjhgghg hfgggyg hgyhghygygyg ,hjkkj";
	String ret = "";
	boolean b = false;

	StringTokenizer st = new StringTokenizer(input, " ");

	while (st.hasMoreTokens())
	{
	    String token = (String)st.nextToken();
	    System.out.println(token.toUpperCase() + " " + b);
	    ret += (b ? token.toUpperCase() : token.toLowerCase()) + " ";

	    b = !b;
	}

	System.out.println(ret);

    }

}