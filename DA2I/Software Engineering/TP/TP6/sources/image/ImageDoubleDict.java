package image ;

import dictionnaire.correction.* ;

public class ImageDoubleDict extends ImageQuelconque implements ImageGrise {

    private Dictionnaire points ;



    public ImageDoubleDict(int w, int h) {
		super(w, h);
    }

    private void initialiserPoints() {
		points = new TabDict() ;
    }



	@Override
    public NiveauGris pointEn(int x, int y) {
	if (points.contientClef(x))
	{
	    Dictionnaire d = (Dictionnaire) points.valeurPour(x) ;
	    if (d.contientClef(y))
			return (NiveauGris) d.valeurPour(y) ;
		return new NiveauGris(NiveauGris.BLANC) ;
    }

	@Override
    public void definirPoint(int x, int y, NiveauGris gris) {
		if (this.correct(x,y)) {
			if (gris.equals(new NiveauGris(NiveauGris.BLANC))) {
				Dictionnaire d ;
				if (points.contientClef(x)) {
					d = (Dictionnaire) points.valeurPour(x) ;
					d.enleverPour(y) ;
					if (d.estVide())
					points.enleverPour(x) ;
				}
			}
			else {
				Dictionnaire d ;
				if (points.contientClef(x))
					d = (Dictionnaire) points.valeurPour(x) ;
				else {
					d = new TabDict() ;
					points.ajouter(x, d) ;
				}
				d.ajouter(y, gris) ;
			}
		}
    }
    
    public ImageGrise getInstance()
    {
    	return new ImageDoubleDict(super.largeur(), super.hauteur());
    }
}
