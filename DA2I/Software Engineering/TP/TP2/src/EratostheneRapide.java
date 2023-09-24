/** 
 * Algorithme "objet" du crible d'Ératosthène.
 */

public class EratostheneRapide {

    /**
     * Principe : on crée un générateur de nombres de 2 à N,
     * puis on le fait travailler. On peut donner comme argument de la ligne
     * de commande la valeur de N (par défaut : 10000).
     */
    public static void main (String [] args)
    {
	long temps = System.currentTimeMillis();

	int i = 100000 ;
	if (args.length > 0) 
	    i = (new Integer(args[0])).intValue() ;	
	GenerateurRapide g = new GenerateurRapide(i) ;
	g.travailler() ;
	System.out.println(g.toString()) ;
	
	System.out.println("temps = " + (System.currentTimeMillis() - temps));
    }
    
}
