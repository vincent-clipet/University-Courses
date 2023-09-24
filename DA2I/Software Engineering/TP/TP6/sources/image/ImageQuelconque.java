package image;

public abstract class ImageQuelconque
{

	//
	// --- Attributes ----------------------------
	//

	int largeur;
	int hauteur;




	//
	// --- Constructors ----------------------------
	//

	public ImageQuelconque(int w, int h)
	{
		this.largeur = w ;
		this.hauteur = h ;
		initialiserPoints() ;
	}

	protected abstract void initialiserPoints();





	//
	// --- Methods ----------------------------
	//

	protected boolean correct(int x, int y)
	{
		return ((x >= 0) && (x < largeur) && (y >= 0) && (y < hauteur)) ;
	}

	protected boolean incompatible(ImageGrise img)
	{
		return (largeur != img.largeur()) || (hauteur != img.hauteur()) ;
	}

	public abstract NiveauGris pointEn(int x, int y);

	public void randomize() {
		for (int y=0; y<hauteur(); y++)
			for (int x=0; x<largeur() ; x++) 
				definirPoint(x, y, this.pointEn(x,y).randomizeNB()) ;
	}
	
	public abstract void definirPoint(int x, int y, NiveauGris gris);

	public void allumer(int x, int y) {
		if (this.correct(x,y))
			this.definirPoint(x, y, new NiveauGris(NiveauGris.NOIR)) ;
	}

	public void eteindre(int x, int y) {
		if (this.correct(x,y))
			this.definirPoint(x, y, new NiveauGris(NiveauGris.BLANC)) ;
	}

	public int compterPoints(NiveauGris gris) {
		int nombre = 0 ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				if (this.pointEn(x,y).equals(gris))
					nombre++ ;
		return nombre ;
	}

	public ImageGrise inverser() {
		ImageGrise result = getInstance() ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, this.pointEn(x,y).inverser()) ;
		return result ;
	}

	public ImageGrise eclaircir() {
		ImageGrise result = getInstance() ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, this.pointEn(x,y).eclaircir()) ;
		return result ;
	}

	public ImageGrise assombrir() {
		ImageGrise result = getInstance() ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, this.pointEn(x,y).assombrir()) ;
		return result ;
	}

	public ImageGrise dupliquer() {
		ImageGrise result = getInstance() ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, new NiveauGris(this.pointEn(x,y).code())) ;
		return result ;
	}

	public ImageGrise ajouter(ImageGrise img) {
		ImageGrise result = getInstance() ;
		if (this.incompatible(img)) 
			return result ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, 
						this.pointEn(x,y).ajouter(img.pointEn(x,y))) ;
		return result ;
	}

	public ImageGrise soustraire(ImageGrise img) {
		ImageGrise result = getInstance() ;
		if (this.incompatible(img)) 
			return result ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, 
						this.pointEn(x,y).soustraire(img.pointEn(x,y))) ;
		return result ;
	}

	public ImageGrise XOR(ImageGrise img) {
		ImageGrise result = getInstance() ;
		if (this.incompatible(img)) 
			return result ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, 
						this.pointEn(x,y).XOR(img.pointEn(x,y))) ;
		return result ;
	}

	public ImageGrise intersection(ImageGrise img) {
		ImageGrise result = getInstance() ;
		if (this.incompatible(img)) 
			return result ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				if (this.pointEn(x,y).equals(img.pointEn(x,y)))
					result.definirPoint(x, y, this.pointEn(x,y)) ;
		return result ;
	}

	public String toString()
	{
		String s = largeur + "x" + hauteur ;
		for (int y=0; y<hauteur; y++) 
		{
			s += "\n" ;
			for (int x=0; x<largeur; x++) 
				s += this.pointEn(x, y) ;	    
		}
		return s ;
	}

	public NiveauGris niveauMoyen() {
		int s = 0 ;
		for (int n=NiveauGris.BLANC; n<=NiveauGris.NOIR; n++) 
			s += n * this.compterPoints(new NiveauGris(n)) ;
		return new NiveauGris((int)(((double) s) / (largeur * hauteur))) ;
	}
	
	public ImageGrise augmenterContraste() {
		NiveauGris courant, moyen ;
		ImageGrise result = getInstance() ;
		moyen = this.niveauMoyen() ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) {
				courant = this.pointEn(x, y) ;
				if (courant.compareTo(moyen) > 0)
					result.definirPoint(x, y, courant.assombrir()) ;
				else 
					result.definirPoint(x, y, courant.eclaircir()) ;		    
			}
		return result ;
	}
	
	public abstract ImageGrise getInstance();
	
	
	


	//
	// --- Get & Set ----------------------------
	//

	public int largeur() { return largeur ; }
	public int hauteur() { return hauteur ; }


}
