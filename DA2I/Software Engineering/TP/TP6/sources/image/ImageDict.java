package image ;

import dictionnaire.correction.Dictionnaire;
import dictionnaire.correction.TabDict;

/** La classe <code>ImageDict</code> représente une image en niveaux 
 *  de gris au moyen d'un dictionnaire dont les clefs sont des coordonnées
 *  (classe <code>Point</code>) et les valeurs les niveaux de gris associés.
 *  Lors de l'instanciation, il suffit de créer un dictionnaire vide puisqu'on
 *  ne stocke que les niveau de gris autres que blanc. L'absence de la clef
 *  (x, y) dans le dictionnaire signifie que le point (x, y) est blanc.
 *  Cette classe utilise <code>TabDict</code>.
 *  @see image.NiveauGris
 *  @see image.Point
 *  @see dictionnaire.correction.TabDict
 */
public class ImageDict extends ImageQuelconque implements ImageGrise
{
	private Dictionnaire points ;

	public ImageDict(int w, int h)
	{
		super(w, h);
	}


	@Override
	protected void initialiserPoints()
	{
		points = new TabDict() ;
	}


	@Override
	public NiveauGris pointEn(int x, int y) {
		if (points.contientClef(new Point(x, y)))
			return (NiveauGris) points.valeurPour(new Point(x, y)) ;
		return new NiveauGris(NiveauGris.BLANC) ;
	}

	@Override
	public void definirPoint(int x, int y, NiveauGris gris) {
		if (this.correct(x,y)) {
			if (gris.equals(new NiveauGris(NiveauGris.BLANC))) 
				points.enleverPour(new Point(x, y)) ;
			else
				points.ajouter(new Point(x, y), gris) ;
		}
	}
	
	public ImageGrise getInstance()
	{
		return new ImageDict(super.largeur(), super.hauteur());
	}
	
}
