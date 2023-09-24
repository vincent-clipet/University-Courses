/** Programme permettant de manipuler et d'exp�rimenter le problème
 *  des tours de Hanoï */
public class Hanoi 
{
	// Les trois piles repr�sentant les tours de Hanoi�
	private static PileHanoi a, b, c ;
	private static int size;
	public static int moves;

	// Initialisation des tours pour n disques, plac�s au d�but en A
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

	// Pour le mode interactif, le choix de la pile est donn� par le joueur
	// en toutes lettres ("A", "B", "C"). -> retourne la pile correspondante
	private static PileHanoi analyse(String r) 
	{
		if (r.equalsIgnoreCase("A"))
			return a ;
		if (r.equalsIgnoreCase("B"))
			return b ;
		return c ;
	}

	//- V�rifie que la valeur entr�e par l'utilisateur est correcte
	private static boolean correctInput(String rep)
	{
		return (rep.equalsIgnoreCase("STOP") || rep.equalsIgnoreCase("A") || rep.equalsIgnoreCase("B") || rep.equalsIgnoreCase("C"));
	}

	/** R�soud automatiquement le probl�me des tours de Hanoi */
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
				System.out.print("D�placer de : ") ; // on demande au joueur la tour de d�part

				rep = Clavier.readString();

				while (! correctInput(rep))
				{
					System.out.println("Cette pile n'existe pas");
					rep = Clavier.readString();
				}

				if (rep.equalsIgnoreCase("STOP"))
					fini = true ;

				depart = analyse(rep) ; // on en d�duit l'objet correspondant

				if (! fini)
				{
					// m�me chose pour la tour d'arriv�e
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

					// on effectue le d�placement si c'est possible
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
		
		System.out.println("OK, c'est fini ! (d�placements = " + moves + ")") ;
	}
}
