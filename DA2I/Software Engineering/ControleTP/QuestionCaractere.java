

public class QuestionCaractere extends Question
{

	//
	// --- Attributes ----------------------------
	//
    protected char bonneReponse ;
    protected char reponseDuJoueur ;
	
	
	
	//
	// --- Constructors ----------------------------
	//
	public QuestionCaractere(String q, char c, int p)
	{
		super(q, p);
		this.bonneReponse = c;
	}
	


	//
	// --- Methods ----------------------------
	//
	public String donnerBonneReponse()
	{
		return Character.toString(this.bonneReponse);
	}
	
	public boolean bonneReponseTrouvee()
	{
		return this.reponseDuJoueur == this.bonneReponse;
	}
	
	public void saisirReponseJoueur()
  	{
    	this.reponseDuJoueur = Clavier.readChar();
  	}

}
