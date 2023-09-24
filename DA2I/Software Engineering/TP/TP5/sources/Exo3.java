import java.util.*;

public class Exo3
{

    public static void main(String[] args)
    {

	Scanner scan = new Scanner(System.in);
	//String input = scan.nextLine();
	String input = "azertytreza";

	char[] chars = input.toCharArray();
	ArrayList<Character> list = new ArrayList<Character>();

	for (char c : chars)
	{
	    if (Character.isLetter(c))
		list.add(new Character(Character.toUpperCase(c)));
	}

	for (Character c2 : list)
	    System.out.print((char)c2);
	System.out.println();

	ArrayList<Character> list2 = (ArrayList<Character>)(list.clone());
	Collections.reverse(list2);

	for (Character c3 : list2)
	    System.out.print((char)c3);
	System.out.println();

	System.out.println("Palindrome : " + (Exo3.isPalindrome(list) ? "oui" : "non"));

	

    }

    public static boolean isPalindrome(ArrayList<Character> list)
    {
	ArrayList<Character> list2 = (ArrayList<Character>)(list.clone());
	Collections.reverse(list2);

	return (list.equals(list2));
    }

}