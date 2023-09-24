public class Entiers1
{
    public static void main(String[] args)
    {
	System.out.println("--------------");
	tester(-126);
	System.out.println("--------------");
	tester(-127);
	System.out.println("--------------");
	tester(-128);
	System.out.println("--------------");
	tester(-129);
	System.out.println("--------------");
    }


    public static void tester()
    {
	Integer a = new Integer(100);
	int b = 100;
	Integer c = new Integer(100);

	System.out.println("");
	System.out.println("a == b : " + (a == b));
	//System.out.println("b == a : " + (b == a));
	System.out.println("b == c : " + (b == c));
	System.out.println("a == c : " + (a == c));
	//System.out.println("c == a : " + (c == a));
    }

    public static void tester(int val)
    {
	Integer a = val;
	int b = val;
	Integer c = val;

	System.out.println("val = " + val);
	System.out.println("a == b : " + (a == b));
	System.out.println("b == c : " + (b == c));
	System.out.println("a == c : " + (a == c));
    }
}