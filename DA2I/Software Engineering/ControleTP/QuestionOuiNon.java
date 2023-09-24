/**
 * QuestionOuiNon : classe concrete qui definit les questions
 * dont les reponses sont soit "Oui", "yes", "vrai", "o", ..., soit
 * "Non", "no", "faux", "n", ...
 *
 * @author S. Picault, d'apres idee de P. Mathieu
 */

public class QuestionOuiNon extends QuestionChaine 
{
    
    public QuestionOuiNon(String q, String r, int p)
    {
    	super(q, r, p) ;
    }

    /** La seule difference avec QuestionChaine est que plusieurs
     * chaines sont equivalentes (yes, oui, y, vrai...), que ce soit
     * pour la reponse attendue ou pour la reponse du joueur */
    public boolean bonneReponseTrouvee() 
    { 
		if (reponseDuJoueur.equalsIgnoreCase("Yes") ||
			reponseDuJoueur.equalsIgnoreCase("Y") ||
			reponseDuJoueur.equalsIgnoreCase("vrai") ||
			reponseDuJoueur.equalsIgnoreCase("Oui") ||
			reponseDuJoueur.equalsIgnoreCase("O")
			)
			reponseDuJoueur="OUI";
		else
			reponseDuJoueur="NON";
		
		if (bonneReponse.equalsIgnoreCase("Yes") ||
			bonneReponse.equalsIgnoreCase("Y") ||
			bonneReponse.equalsIgnoreCase("vrai") ||
			bonneReponse.equalsIgnoreCase("Oui") ||
			bonneReponse.equalsIgnoreCase("O")
			)
			bonneReponse="OUI";
		else
			bonneReponse="NON";
			
		return super.bonneReponseTrouvee();	
    }  
} 
