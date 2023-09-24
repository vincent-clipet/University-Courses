/** Programme permettant de manipuler et d'expérimenter le problÃ¨me
 *  des tours de HanoÃ¯ */
public class Hanoi 
{
	// Les trois piles représentant les tours de Hanoi¯
	private static PileHanoi a, b, c ;
	private static int size;
	public static int moves;

	// Initialisation des tours pour n disques, placés au début en A
	private static void init(int n) 
	{
		size = n;
		a = new PileHanoi("A", new AffichageGraphique("A")) ;
		b = new PileHanoi("B", new AffichageSimple()) ;
		c = new PileHanoi("C", new AffichageSimple()) ;
		for (int i=n; i>0; i--)
			a.empile(new DisqueHanoi(i)) ;
	}

	// Affichage des trois tours
	private static void affiche() 
	{
		System.out.println(a) ;
		System.out.println(b) ;
		System.out.println(c) ;
	}

	// Pour le mode interactif, le choix de la pile est donné par le joueur
	// en toutes lettres ("A", "B", "C"). -> retourne la pile correspondante
	private static PileHanoi analyse(String r) 
	{
		if (r.equalsIgnoreCase("A"))
			return a ;
		if (r.equalsIgnoreCase("B"))
			return b ;
		return c ;
	}

	//- Vérifie que la valeur entrée par l'utilisateur est correcte
	private static boolean correctInput(String rep)
	{
		return (rep.equalsIgnoreCase("STOP") || rep.equalsIgnoreCase("A") || rep.equalsIgnoreCase("B") || rep.equalsIgnoreCase("C"));
	}

	/** Résoud automatiquement le problème des tours de Hanoi */
	public static void resoudreAuto(PileHanoi a, PileHanoi b, PileHanoi c)
	{
		a.deplacerDesDisques(size, c, b);
	}

	/** Main */
	public static void main (String [] arg) 
	{
		System.out.println("Nombre de disques ? :");
		int nbDisques = Clavier.readInt() ;
		System.out.println("==============================");

		// initialisation des piles
		init(nbDisques) ;

		boolean fini = false ;
		String rep ;
		PileHanoi depart, arrivee ;

		//arg = new String[] {"--auto"}; // DEBUG

		if (arg.length == 0 || arg[0] == null || ! arg[0].equals("--auto"))
		{
			do
			{
				affiche(); // on commence par afficher les tours
				System.out.print("Déplacer de : ") ; // on demande au joueur la tour de départ

				rep = Clavier.readString();

				while (! correctInput(rep))
				{
					System.out.println("Cette pile n'existe pas");
					rep = Clavier.readString();
				}

				if (rep.equalsIgnoreCase("STOP"))
					fini = true ;

				depart = analyse(rep) ; // on en déduit l'objet correspondant

				if (! fini)
				{
					// même chose pour la tour d'arrivée
					System.out.print("Vers : ") ;
					rep = Clavier.readString() ;

					while (! correctInput(rep))
					{
						System.out.println("Cette pile n'existe pas");
						rep = Clavier.readString();
					}

					if (rep.equalsIgnoreCase("STOP"))
						fini = true ;

					arrivee = analyse(rep) ;

					// on effectue le déplacement si c'est possible
					if (depart != arrivee && arrivee.peutEmpiler(depart.sommet()))
						depart.deplacerUnElementVers(arrivee) ;
					else
						System.out.println("Impossible !") ;
				}

			}
			while (!fini) ; // et on continue tant que le joueur n'a pas dit STOP
		}
		else
		{
			resoudreAuto(a, b, c);
		}
		
		System.out.println("OK, c'est fini ! (déplacements = " + moves + ")") ;
	}
}
