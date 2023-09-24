package image ;

/** La classe <code>ImageTab</code> représente une image en niveaux 
 *  de gris au moyen d'un tableau à deux dimensions de <code>NiveauGris</code>.
 *  Le tableau de départ doit donc être initialisé lors de l'instanciation
 *  en plaçant partout des points blancs.
 *  @see image.NiveauGris
 */
public class ImageTab extends ImageQuelconque implements ImageGrise
{
	private NiveauGris [][] points ;

	public ImageTab(int w, int h)
	{
		super(w, h);
	}

	@Override
	protected void initialiserPoints()
	{
		points = new NiveauGris[largeur][hauteur] ;

		for (int y=0; y<hauteur; y++)
		{
			for (int x=0; x<largeur; x++) 
				this.definirPoint(x, y, new NiveauGris(NiveauGris.BLANC)) ;
		}
	}




	@Override
	public NiveauGris pointEn(int x, int y) {
		if (this.correct(x,y))
			return points[x][y] ;

		return new NiveauGris(NiveauGris.BLANC) ;
	}

	@Override
	public void definirPoint(int x, int y, NiveauGris gris) {
		if (this.correct(x,y)) 
			points[x][y] = gris ;
	}

	public ImageGrise masquer(ImageGrise img) {
		ImageGrise result = new ImageTab(largeur(), hauteur()) ;
		if (this.incompatible(img)) 
			return result ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				if (this.pointEn(x,y).equals(img.pointEn(x,y)))
					result.definirPoint(x, y, this.pointEn(x,y)) ;
		return result ;
	}
	 
	 public ImageGrise getInstance()
	 {
	 	return new ImageTab(super.largeur(), super.hauteur());
	 }
}
