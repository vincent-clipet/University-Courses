package image;

import java.awt.Color;
import java.util.Iterator;

import dictionnaire.correction.ArrayListDict;
import dictionnaire.correction.CoupleObj;
import dictionnaire.correction.Dictionnaire;

public class ImageDict implements ImageGrise
{
	/* Question 4 :
	  La vitesse d'affichage pourrait être grandement augmentée en utilisant un 'Iterator<CoupleObj<Integer, Integer>, NiveauGris>'.
	  Cela éviterait de devoir faire (longueur x hauteur) itérations pour afficher une image de seulement quelques "pixels"
	*/




	public ArrayListDict<CoupleObj<Integer, Integer>, NiveauGris> dictionnaire;
	public int largeur;
	public int hauteur;



	public ImageDict(int largeur, int hauteur)
	{
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.dictionnaire = new ArrayListDict<CoupleObj<Integer, Integer>, NiveauGris>();
	}

	public ImageDict(ArrayListDict<CoupleObj<Integer, Integer>, NiveauGris> toCopy, int largeur, int hauteur)
	{
		this(largeur, hauteur);

		for (int j = 0; j < this.hauteur; j++)
		{
			for (int i = 0; i < this.largeur; i++)
			{
				CoupleObj<Integer, Integer> c = new CoupleObj<Integer, Integer>(i, j);
				NiveauGris ng = toCopy.valeurPour(c);

				if (ng != null)
					definirPoint(i, j, ng);
			}
		}
	}



	public int largeur()
	{
		return this.largeur;
	}


	public int hauteur()
	{
		return this.hauteur;
	}


	public NiveauGris pointEn(int x, int y)
	{
		CoupleObj<Integer, Integer> c = new CoupleObj<Integer, Integer>(x, y);

		if (this.dictionnaire.contientClef(c))
			return this.dictionnaire.valeurPour(c);
		else
			return (new NiveauGris(Color.WHITE));
	}

	public void definirPoint(int x, int y, NiveauGris gris)
	{
		if (gris.estBlanc())
			return;

		CoupleObj<Integer, Integer> c = new CoupleObj<Integer, Integer>(x, y);
		this.dictionnaire.ajouter(c, gris);
	}

	public void allumer(int x, int y)
	{
		definirPoint(x, y, new NiveauGris(Color.BLACK));
	}

	public void eteindre(int x, int y)
	{
		definirPoint(x, y, new NiveauGris(Color.WHITE));
	}

	public void randomize()
	{
		// Aucun intérêt de randomiser ici
	}

	public int compterPoints(NiveauGris gris)
	{
		int count = 0;

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);

				if (ng != null && ng.equals(gris))
					count++;
			}
		}

		return count;
	}

	public ImageGrise inverser()
	{
		ImageDict ret = (ImageDict)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);

				if (ng != null)
					ret.definirPoint(i, j, ng.inverser());
			}
		}

		return ret;
	}

	public ImageGrise eclaircir()
	{
		ImageDict ret = (ImageDict)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);

				if (ng != null)
					ret.definirPoint(i, j, ng.eclaircir());
			}
		}

		return ret;
	}

	public ImageGrise assombrir()
	{
		ImageDict ret = (ImageDict)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);

				if (ng != null)
					ret.definirPoint(i, j, ng.assombrir());
			}
		}

		return ret;
	}

	public ImageGrise dupliquer()
	{
		return (new ImageDict(this.dictionnaire, this.largeur(), this.hauteur()));
	}

	private boolean hasSameSize(ImageGrise img)
	{
		return (this.largeur() == img.largeur() && this.hauteur() == img.hauteur());
	}

	public ImageGrise ajouter(ImageGrise img)
	{
		if (! hasSameSize(img))
			return null;

		ImageDict ret = (ImageDict)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);
				NiveauGris ng2 = img.pointEn(i, j);

				if (ng2 != null)
				{
					if (ng == null)
						ret.definirPoint(i, j, ng2);
					else
						ret.definirPoint(i, j, ng.ajouter(ng2));
				}
			}
		}

		return ret;
	}

	public ImageGrise soustraire(ImageGrise img)
	{
		if (! hasSameSize(img))
			return null;

		ImageDict ret = (ImageDict)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);
				NiveauGris ng2 = img.pointEn(i, j);

				if (ng2 != null)
				{
					if (ng == null)
						ret.definirPoint(i, j, ng2);
					else
						ret.definirPoint(i, j, ng.soustraire(ng2));
				}
			}
		}

		return ret;
	}

	public ImageGrise XOR(ImageGrise img)
	{
		if (! hasSameSize(img))
			return null;

		ImageDict ret = (ImageDict)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);
				NiveauGris ng2 = img.pointEn(i, j);

				if (ng2 != null)
				{
					if (ng == null)
						ret.definirPoint(i, j, new NiveauGris(Color.BLACK));
					else
						ret.definirPoint(i, j, ng.XOR(ng2));
				}
			}
		}

		return ret;
	}

	public ImageGrise intersection(ImageGrise img)
	{
		if (! hasSameSize(img))
			return null;

		ImageDict ret = (ImageDict)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);
				NiveauGris ng2 = img.pointEn(i, j);

				if (ng2 != null && ng != null)
				{
					if (! ng.equals(ng2))
						ret.definirPoint(i, j, new NiveauGris(Color.WHITE));
				}
			}
		}

		return ret;
	}

	public NiveauGris niveauMoyen()
	{
		int[] count = new int[] { 0,0,0,0,0 };
		NiveauGris white = new NiveauGris(Color.WHITE);

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);
				int comparison = 0;

				if (ng != null)
					comparison = ng.compareTo(white);

				count[comparison]++;
			}
		}

		int sum = 0;

		for (int i = 0; i < 5; i++)
			sum += i * count[i];

		float avg = (float)sum / (largeur() * hauteur());
		int toRet = Math.round(avg);

		return (new NiveauGris(toRet));
	}

	public ImageGrise augmenterContraste()
	{
		ImageDict ret = (ImageDict)dupliquer();
		NiveauGris avg = niveauMoyen();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				NiveauGris ng = pointEn(i, j);
				int comparison = 0;

				if (ng != null)
				{
					comparison = ng.compareTo(avg);

					if (comparison == 0)
						continue;
					else if (comparison < 0)
						ret.definirPoint(i, j, ng.eclaircir());
					else if (comparison > 0)
						ret.definirPoint(i, j, ng.assombrir());
				}
			}
		}

		return ret;
	}

}
