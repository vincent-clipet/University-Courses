public class TestMemoire1
{
    /** Un test dans lequel on crée une instance référencée par une
     * variable, puis neuf autres non référencées. 
     */
    public static void main (String [] args) 
    {
	ObjetMortel o = new ObjetMortel() ;
	System.out.println(o) ;
	for (int i=1; i<10; i++) 
	    {
		System.out.println(new ObjetMortel()) ;
	    }
	// on appelle le garbage collector avant de quitter le
	// programme
	System.gc() ;
    }   
}