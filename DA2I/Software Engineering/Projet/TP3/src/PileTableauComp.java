/** Une implémentation de l'interface Pile utilisant un tableau. À
 * noter : cette classe n'est pas générique, elle est destinée à ne
 * contenir des objets comparables. Ainsi, elle possède une méthode
 * <code>trier</code> qui s'appuie sur la méthode
 * <code>compareTo</code> de <code>Comparable</code>. */
public class PileTableauComp implements Pile<Comparable> {

	private Comparable [] elements ;
	private int nbElem = 0 ;
	private String nom = "la pile" ;

	/** Constructeur qui crée une pile vide */
	public PileTableauComp() {
		elements = new Comparable[MAX_ELEMENTS] ;
	}

	/** Constructeur qui crée une pile vide et lui donne un nom */
	public PileTableauComp(String nom) {
		elements = new Comparable[MAX_ELEMENTS] ;
		this.nom = nom ;
	}



	////////////////////////////////////////////
	//                                        //
	//   IMPLEMENTATION DE L'INTERFACE PILE   //
	//                                        //
	////////////////////////////////////////////

	/** teste si la pile est vide */
	public boolean vide() {
		return (nbElem == 0) ;
	}

	/** teste si la pile est pleine */
	public boolean pleine () {
		return (nbElem == MAX_ELEMENTS) ;
	}

	/** teste si la pile peut empiler x */
	public boolean peutEmpiler (Comparable x) {
		return (!pleine()) ;
	}

	/** renvoie la valeur de l'objet sur le sommet de la pile */
	public Comparable sommet() {
		if (vide())
			return null ;
		else return elements[nbElem-1] ;
	}

	/** renvoie la valeur de l'objet sur le sommet de la pile
	 * et l'enlève */
	public Comparable depile() {
		if (vide())
			return null ;
		nbElem-- ;
		return elements[nbElem] ;
	}

	/** ajoute un objet sur le sommet de la pile */
	public void empile(Comparable o) {
		if (peutEmpiler(o)) {
			elements[nbElem] = o ;
			nbElem++ ;
		}
	}

	/** vide la pile */
	public void vider() {
		nbElem = 0 ;
	}

	/** compte le nombre d'éléments présents dans la pile */
	public int nbElements() {
		return nbElem ;
	}

	public void deplacerUnElementVers(Pile<Comparable> p) {
		if (!vide() && p.peutEmpiler(sommet())) {
			p.empile(this.depile()) ;
			if (p instanceof PileTableau) 
				System.out.println("Déplacement de " + nom + " vers "
						+ ((PileTableau) p).nom()) ;
		}
	}

	/** affichage */
	public String toString() {
		String s = nom + "\n" ;
		for (int i = nbElem-1; i>=0; i--)
			s += elements[i] + "\n" ;
		return s ;
	}
	//
	// METHODES PROPRES A PileTableauComp
	//

	/** accès au nom de la pile */
	public String nom() { return nom ; }

	/** Méthode qui trie les éléments dans l'ordre croissant du sommet
	 * vers la base (plus petit en haut). Cette méthode s'appuie sur
	 * la méthode <code>compareTo</code> de l'interface
	 * <code>java.lang.Comparable</code> qu'implémentent tous les
	 * éléments de la pile. */
	public void trier() {
		// une boucle de la base à l'avant-dernier
		for (int i=0; i<nbElements()-1; i++)
			// une boucle pour les éléments "au-dessus" de i
			for (int j=i+1; j<nbElements(); j++)
				// si l'élément i est plus petit qu'un élément j au-dessus
				if (elements[i].compareTo(elements[j]) < 0) {
					// il faut les permuter
					Comparable temp = elements[i] ;
					elements[i] = elements[j] ;
					elements[j] = temp ;
				}
	}

	// TEST
}
