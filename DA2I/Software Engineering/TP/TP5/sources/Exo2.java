import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Exo2
{

    public static void main(String[] args)
    {

	Scanner scan = new Scanner(System.in);
	//String input = scan.nextLine();
	String input = "a ccc bb dddd";

	StringTokenizer st = new StringTokenizer(input, " ");
	ArrayList<String> list = new ArrayList<String>();

	while (st.hasMoreTokens())
	{
	    String token = (String)st.nextToken();
	    list.add(token);
	}

	Collections.sort(list);
	String ret = "";

	for (String s : list)
	    ret += s + " ";

	System.out.println(ret);

    }

}