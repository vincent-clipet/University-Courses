public abstract class Question
{

	//
	// --- Attributes ----------------------------
	//
	protected String nom;
	protected int nb;
  
  
	//
	// --- Constructors ----------------------------
	//
	public Question(String nom, int nb)
	{
	  this.nom = nom;
	  this.nb = nb;
	}


  	//
	// --- Methods ----------------------------
	//
	public abstract String donnerBonneReponse();
	public abstract boolean bonneReponseTrouvee();
	public abstract void saisirReponseJoueur();
  
	public String toString()
	{
		return "Question (" + getValeur() + " point(s)" + ") : " + getNom() + " ? ";
	}
  
  
  
   	//
	// --- Get & Set ----------------------------
	//
	public String getNom()
	{
	  return this.nom;
	}
	  
	public int getValeur()
	{
	  return this.nb;
	}
	
}
