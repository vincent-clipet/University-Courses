public class AffichageSimple implements Affichage
{
	public AffichageSimple()
	{

	}

	public String affichage_tableau(Disque[] discs, int n)
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++)
			sb.append('\n').append(discs[i].diametre());

		return sb.toString();
	}

}
