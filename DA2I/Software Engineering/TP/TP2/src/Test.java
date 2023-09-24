public class Test
{
    public static void main(String[] args)
    {
	System.out.println("" + System.currentTimeMillis());
	Eratosthene.main(null);
	System.out.println("" + System.currentTimeMillis());
	EratostheneRapide.main(null);
	System.out.println("" + System.currentTimeMillis());
    }
}