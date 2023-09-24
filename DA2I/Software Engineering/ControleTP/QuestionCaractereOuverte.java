

public class QuestionCaractereOuverte extends QuestionCaractere
{

	//
	// --- Attributes ----------------------------
	//
	protected String bonneReponse2 ;
	VerificateurCaractere algorithme;
	
	
	
	//
	// --- Constructors ----------------------------
	//
	public QuestionCaractereOuverte(String q, VerificateurCaractere v, String q2, int p)
	{
		super(q, ' ' , p);
		this.algorithme = v;
		this.bonneReponse2 = q2;
	}
	


	//
	// --- Methods ----------------------------
	//	
	public String donnerBonneReponse()
	{
		return this.bonneReponse2;
	}
	
	public boolean bonneReponseTrouvee()
	{
		return this.algorithme.verifier(this.reponseDuJoueur);
	}
	
}
