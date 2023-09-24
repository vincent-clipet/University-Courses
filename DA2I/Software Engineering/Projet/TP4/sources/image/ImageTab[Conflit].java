package image;

import java.awt.Color;

public class ImageTab implements ImageGrise
{

	private NiveauGris[][] pixels;
	private int largeur;
	private int hauteur;



	public ImageTab(int largeur, int hauteur)
	{
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.pixels = new NiveauGris[hauteur][largeur];

		fillWithWhite();
	}

	public ImageTab(NiveauGris[][] toCopy)
	{
		this.largeur = toCopy[0].length;
		this.hauteur = toCopy.length;
		this.pixels = new NiveauGris[hauteur][largeur];

		for (int j = 0; j < this.hauteur; j++)
		{
			for (int i = 0; i < this.largeur; i++)
			{
				definirPoint(i, j, toCopy[j][i]);
			}
		}
	}



	public void fillWithWhite()
	{
		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				eteindre(i, j);
			}
		}
	}

	private boolean hasSameSize(ImageGrise img)
	{
		return (this.largeur() == img.largeur() && this.hauteur() == img.hauteur());
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				sb.append(pointEn(i, j).toString());
			}

			sb.append('\n');
		}

		return sb.toString();
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
		return this.pixels[y][x];
	}

	public void definirPoint(int x, int y, NiveauGris gris)
	{
		this.pixels[y][x] = gris;
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
		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				definirPoint(i, j, NiveauGris.randomizeNB());
			}
		}
	}

	public int compterPoints(NiveauGris gris)
	{
		int count = 0;

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				if (pointEn(i, j).equals(gris))
					count++;
			}
		}

		return count;
	}

	public ImageGrise eclaircir()
	{
		ImageTab ret = (ImageTab)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				ret.definirPoint(i, j, pointEn(i, j).eclaircir());
			}
		}

		return ret;
	}

	public ImageGrise inverser()
	{
		ImageTab ret = (ImageTab)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				ret.definirPoint(i, j, pointEn(i, j).inverser());
			}
		}

		return ret;
	}

	public ImageGrise assombrir()
	{
		ImageTab ret = (ImageTab)dupliquer();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				ret.definirPoint(i, j, pointEn(i, j).assombrir());
			}
		}

		return ret;
	}

	public ImageGrise dupliquer()
	{
		return (new ImageTab(this.pixels));
	}

	public ImageGrise ajouter(ImageGrise img)
	{
		if (! hasSameSize(img))
			return null;

		ImageTab ret = new ImageTab(largeur(), hauteur());

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				ret.definirPoint(i, j, pointEn(i, j).ajouter(img.pointEn(i, j)));
			}
		}

		return ret;
	}

	public ImageGrise soustraire(ImageGrise img)
	{
		if (! hasSameSize(img))
			return null;

		ImageTab ret = new ImageTab(largeur(), hauteur());

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				ret.definirPoint(i, j, pointEn(i, j).soustraire(img.pointEn(i, j)));
			}
		}

		return ret;
	}

	public ImageGrise XOR(ImageGrise img)
	{
		if (! hasSameSize(img))
			return null;

		ImageTab ret = new ImageTab(largeur(), hauteur());

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				ret.definirPoint(i, j, pointEn(i, j).XOR(img.pointEn(i, j)));
			}
		}

		return ret;
	}

	public ImageGrise intersection(ImageGrise img)
	{
		if (! hasSameSize(img))
			return null;

		ImageTab ret = new ImageTab(largeur(), hauteur());

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				if (! (pointEn(i, j).equals(img.pointEn(i, j))))
					ret.definirPoint(i, j, new NiveauGris(Color.WHITE));
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
				int comparison = pointEn(i, j).compareTo(white);
				count[comparison]++;
			}
		}

		int sum = 0;

		for (int i = 0; i < 5; i++)
		{
			sum += i * count[i];
		}

		float avg = (float)sum / (largeur() * hauteur());
		int toRet = Math.round(avg);

		return (new NiveauGris(toRet));
	}

	public ImageGrise augmenterContraste()
	{
		ImageTab ret = (ImageTab)dupliquer();
		NiveauGris avg = niveauMoyen();

		for (int j = 0; j < hauteur(); j++)
		{
			for (int i = 0; i < largeur(); i++)
			{
				int comparison = pointEn(i, j).compareTo(avg);

				if (comparison == 0)
					continue;
				else if (comparison < 0)
					ret.definirPoint(i, j, pointEn(i, j).eclaircir());
				else if (comparison > 0)
					ret.definirPoint(i, j, pointEn(i, j).assombrir());
			}
		}

		return ret;
	}



	public static void main(String[] args)
	{
		ImageTab it = new ImageTab(10, 5);
		it = generateRandomPixels(it);
		System.out.println(it.toString());

		System.out.println("-------------------------------------");
		System.out.println(it.pointEn(0, 0).toString());
		System.out.println(it.pointEn(1, 0).toString());
		System.out.println(it.pointEn(2, 0).toString());

		System.out.println("-------------------------------------");

		it.definirPoint(0, 0, new NiveauGris(Color.BLACK));
		it.definirPoint(1, 0, new NiveauGris(Color.BLACK));
		it.definirPoint(2, 0, new NiveauGris(Color.BLACK));
		it.allumer(9, 4);
		it.allumer(8, 4);
		it.eteindre(9, 3);
		it.eteindre(8, 3);
		System.out.println(it.toString());

		System.out.println("-------------------------------------");

		it.randomize();
		System.out.println(it.toString());

		System.out.println("-------------------------------------");

		it = generateRandomPixels(it);
		System.out.println(it.toString());
		System.out.println(it.inverser().toString());

		System.out.println("-------------------------------------");

		System.out.println(it.toString());
		it = (ImageTab)it.eclaircir();
		System.out.println(it.toString());
		it = (ImageTab)it.assombrir();
		System.out.println(it.toString());

		System.out.println("-------------------------------------");

		System.out.println(it.niveauMoyen().toString());

		System.out.println(it.toString());
		it = (ImageTab)it.augmenterContraste();
		System.out.println(it.toString());
		it = (ImageTab)it.augmenterContraste();
		System.out.println(it.toString());


	}

	public static ImageTab generateRandomPixels(ImageTab it)
	{
		java.util.Random r = new java.util.Random();

		for (int j = 0; j < it.hauteur(); j++)
		{
			for (int i = 0; i < it.largeur(); i++)
			{
				it.definirPoint(i, j, NiveauGris.randomize());
			}
		}

		return it;
	}

}