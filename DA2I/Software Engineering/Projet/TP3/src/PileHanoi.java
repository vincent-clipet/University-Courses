/** Une impl�mentation de l'interface Pile utilisant un tableau. �
 * noter : cette classe reste g�n�rique. */
public class PileHanoi implements Pile<DisqueHanoi> {

	private DisqueHanoi[] elements ;
	private int nbElem = 0 ;
	private String nom = "la pile" ;
	private Affichage algoAffichage = new AffichageSimple();

	/** Constructeur qui cr�e une pile vide */
	public PileHanoi(Affichage a) {
		elements = new DisqueHanoi[MAX_ELEMENTS] ;
		this.algoAffichage = a;
	}

	/** Constructeur qui cr�e une pile vide et lui donne un nom */
	public PileHanoi(String nom, Affichage a) {
		elements = new DisqueHanoi[MAX_ELEMENTS] ;
		this.algoAffichage = a;
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
	public boolean peutEmpiler (DisqueHanoi x)
	{
		if (vide())
			return true;

		//System.out.println("elements : " + this.elements);
		//System.out.println("elements[this.nbElem] : " + this.elements[this.nbElem]);

		int comp = ((DisqueHanoi)(this.elements[this.nbElem - 1])).compareTo((DisqueHanoi)x);

		return comp > 0;
	}

	/** renvoie la valeur de l'objet sur le sommet de la pile */
	public DisqueHanoi sommet() {
		if (vide())
			return null ;
		else return elements[nbElem-1] ;
	}

	/** renvoie la valeur de l'objet sur le sommet de la pile et l'enl�ve */
	public DisqueHanoi depile()
	{
		if (vide())
			return null ;

		nbElem-- ;
		return elements[nbElem];
	}

	/** ajoute un objet sur le sommet de la pile */
	public void empile(DisqueHanoi o)
	{
		if (peutEmpiler(o))
		{
			elements[nbElem] = o;
			nbElem++;
		}
	}

	/** vide la pile */
	public void vider() {
		nbElem = 0 ;
	}

	/** compte le nombre d'�l�ments pr�sents dans la pile */
	public int nbElements() {
		return nbElem ;
	}

	/** d�place le 1er �l�ment de la pile actuelle vers la pile pass�e en param�tre */
	public void deplacerUnElementVers(Pile<DisqueHanoi> p)
	{
		if (vide())
			return;

		if (p.peutEmpiler(sommet()))
		{
			p.empile(this.depile()) ;

			if (p instanceof PileHanoi) 
				System.out.println("D�placement de " + nom + " vers " + ((PileHanoi) p).nom());
		}
	}

	/** R�soud le probl�me des tours de Hanoi */
	public void deplacerDesDisques(int n, Pile dest, Pile interm)
	{
		if (n == 1)
		{
			deplacerUnElementVers(dest);
			Hanoi.moves++;
		}
		else
		{
			this.deplacerDesDisques(n - 1, interm, dest);
			this.deplacerDesDisques(1, dest, interm);
			((PileHanoi)interm).deplacerDesDisques(n - 1, dest, this);
		}
	}



	/** affichage */
	public String toString()
	{
		/*String s = nom + "\n" ;
		for (int i = 0; i < this.nbElem; i++)
	    	s += elements[i] + "\n" ;
	    return s ;*/

		Disque[] discs = (Disque[]) this.elements;
		return this.nom + " : " + this.algoAffichage.affichage_tableau(discs, this.nbElem);
	}

	/** acc�s au nom de la pile */
	public String nom()
	{
		return nom ;
	}

}
