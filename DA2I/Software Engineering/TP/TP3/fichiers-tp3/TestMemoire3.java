public class TestMemoire3
{
    /** Un test dans lequel on crée 10000 instances non référencées de ObjetMortel.
     */
    public static void main (String [] args) 
    {
	for (long i=0; i<100000; i++) 
	    {
		System.out.println(new ObjetMortel()) ;
	    }
    }   
}