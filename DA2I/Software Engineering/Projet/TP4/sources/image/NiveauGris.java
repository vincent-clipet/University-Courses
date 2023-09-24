package image ;

import java.awt.Color ;

/** La class NiveauGris représente de façon abstraite une couleur 
 * intermédiaire entre blanc et noir. Cette représentation abstraite
 * peut ensuite faire l'objet d'un affichage en mode texte ou en
 * mode graphique. */
public class NiveauGris implements Comparable<NiveauGris> {
    /** Les constantes servant à indiquer les niveaux de gris disponibles */
    public static final int 
	BLANC = 0, GRIS_CLAIR = 1, GRIS_MOYEN = 2, GRIS_FONCE = 3, NOIR = 4 ;
    /** Les caractères représentant les divers niveaux de gris en mode texte */
    public static final char [] CODES = { ' ', '.', '+', 'x', '*' } ;
    /** Les couleurs représentant les divers niveaux de gris en mode graphique */
    public static final Color [] 
	COULEURS = { Color.WHITE, Color.LIGHT_GRAY, Color.GRAY,
		     Color.DARK_GRAY, Color.BLACK } ;
    
    // la valeur du niveau de gris : blanc par defaut
    private int niveau = BLANC ;

    /** Construit un niveau de gris à partir d'une des constantes de la classe */
    public NiveauGris(int niv) {
	niveau = Math.min(Math.max(niv, BLANC), NOIR) ;
    }

    /** Construit un niveau de gris à partir d'un degré de luminosité compris
     * entre 0 (noir) et 1 (blanc) */
    public NiveauGris(double luminosite) {
	double noirceur = Math.min(Math.max(1-luminosite, 0), 1) ;
	niveau = (int) Math.round(noirceur * (CODES.length - 1)) ;
    }

    /** Construit un niveau de gris à partir du caractère qui le représente
     * en mode texte */
    public NiveauGris(char code) {
	niveau = Math.max(indexOfCode(code), BLANC) ;	
    }

    /** Construit un niveau de gris à partir de la couleur qui le représente
     * en mode graphique */
    public NiveauGris(Color couleur) {
	niveau = Math.max(indexOfCouleur(couleur), BLANC) ;	
    }

    public static NiveauGris randomize() {
	return new NiveauGris((int)(Math.random()*(NOIR-BLANC+1))) ;
    }

    public static NiveauGris randomizeNB() {
	return new NiveauGris(BLANC + (NOIR-BLANC)*(int)(Math.random()*2)) ;
    }

    // méthode de recherche dans le tableau CODES
    private int indexOfCode(char code) {
	for (int i=0; i<CODES.length; i++)
	    if (CODES[i] == code) return i ;
	return -1 ;
    }

    // méthode de recherche dans le tableau COULEURS
    private int indexOfCouleur(Color couleur) {
	for (int i=0; i<COULEURS.length; i++)
	    if (COULEURS[i] == couleur) return i ;
	return -1 ;
    }

    /** Retourne le caractère représentant le niveau de gris courant */
    public char code() { return CODES[niveau] ; }

    /** Retourne la couleur représentant le niveau de gris courant */
    public Color couleur() { return COULEURS[niveau] ; }

    /** Teste si le niveau de gris courant est noir */
    public boolean estNoir() { return niveau == NOIR ; }

    /** Teste si le niveau de gris courant est blanc */
    public boolean estBlanc() { return niveau == BLANC ; }

    /** Renvoie le niveau de gris un ton plus clair que le niveau courant */
    public NiveauGris eclaircir() {
	return new NiveauGris(Math.max(niveau-1, BLANC)) ;
    }

    /** Renvoie le niveau de gris un ton plus foncé que le niveau courant */
    public NiveauGris assombrir() {
	return new NiveauGris(Math.min(niveau+1, NOIR)) ;
    }

    /** Renvoie le "négatif" du niveau courant (blanc &lt;-&gt; noir) */
    public NiveauGris inverser() {
	return new NiveauGris(NOIR - niveau) ; 
    }

    /** Renvoie BLANC si les deux niveaux de gris sont égaux, NOIR sinon */
    public NiveauGris XOR(NiveauGris gris) {
	return new NiveauGris(this.equals(gris)?BLANC:NOIR) ;
    }

    /** Renvoie un niveau de gris correspondant à la somme du niveau courant et
     * du paramètre (maximum : noir) */
    public NiveauGris ajouter(NiveauGris gris) {
	return new NiveauGris(Math.min(niveau + gris.niveau, NOIR)) ;       
    }

    /** Renvoie un niveau de gris correspondant à la différence entre le niveau 
     * courant et le paramètre (minimum : blanc) */
    public NiveauGris soustraire(NiveauGris gris) {
	return new NiveauGris(Math.max(niveau - gris.niveau, BLANC)) ;       
    }

    /** Renvoie un niveau de gris égal au plus sombre entre le niveau courant et
     * le paramètre */
    public NiveauGris maximum(NiveauGris gris) {
	return new NiveauGris(Math.max(niveau, gris.niveau)) ;
    }

    /** Renvoie un niveau de gris égal au plus clair entre le niveau courant et
     * le paramètre */
    public NiveauGris minimum(NiveauGris gris) {
	return new NiveauGris(Math.min(niveau, gris.niveau)) ;
    }

    /** Teste l'égalité du niveau de gris courant et de l'objet o. Cet objet doit 
     * pour cela être un niveau de gris de même valeur que <code>this</code> */
    public boolean equals(Object o) {
	if (o instanceof NiveauGris)
	    return niveau == ((NiveauGris)o).niveau ;
	return false ;
    }
	    
    /** Représentation sous forme de chaîne (en fait le caractère codant le niveau de gris) */
    public String toString() { return ""+code() ; }


    // IMPLEMENTATION DE L'INTERFACE java.lang.Comparable

    /** Un niveau de gris est "plus petit" qu'un autre s'il est plus clair */
    public int compareTo(NiveauGris o) {
	return niveau - o.niveau ;
    }
}
