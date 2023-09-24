public class RationnelTest
{

    public static void main(String[] args)
    {
	Rationnel r1 = new Rationnel(-3, 2, 7);
	Rationnel r2 = new Rationnel(12, 345, -678);
	Rationnel r3 = new Rationnel(-4, 9, 7);
	Rationnel r4 = new Rationnel(5, -30, 5);
	Rationnel r5 = new Rationnel(6, 36, -6);

	System.out.println("-----------------------------");

	System.out.println(r1);
	System.out.println(r2);
	System.out.println(r3);
	System.out.println(r4);
	System.out.println(r5);

	System.out.println("-----------------------------");

	System.out.println(r1.getInverse());
	System.out.println(r2.getInverse());
	System.out.println(r3.getInverse());
	System.out.println(r4.getInverse());
	//System.out.println(r5.getInverse()); // by zero
	
	System.out.println("-----------------------------");

	System.out.println(r1.getSum(r3));
	System.out.println(r3.getSum(r1));
	System.out.println(r3.getSum(r2));
	System.out.println(r2.getSum(r1));

	System.out.println("-----------------------------");

	System.out.println(r1.getProduct(r3));
	System.out.println(r3.getProduct(r1));
	System.out.println(r3.getProduct(r2));
	System.out.println(r2.getProduct(r1));

	System.out.println("-----------------------------");

	System.out.println(r1.getComparison(r3));
	System.out.println(r3.getComparison(r1));
	System.out.println(r1.getComparison(r2));
	System.out.println(r3.getComparison(r2));

	System.out.println("-----------------------------");

	/*System.out.println(new Rationnel(3, 4, 5));
	System.out.println(new Rationnel(5, 4, 3)) ;
	System.out.println(new Rationnel(-2, 3)) ;
	System.out.println(new Rationnel(3, -2)) ;
	System.out.println(new Rationnel(3, 6, -2)) ;
	System.out.println(new Rationnel(3)) ;
	System.out.println(new Rationnel(1,3)) ; */
    }
}