/**
 * QuestionChaine : classe concrete qui definit les questions
 * dont les reponses sont des chaines de caracteres.
 *
 * @author S. Picault, d'apres idee de P. Mathieu
 */

public class QuestionChaine extends Question 
{
    /** la chaine attendue */
    protected String bonneReponse ;
    /** la chaine donnee par le joueur */
    protected String reponseDuJoueur ;

    /** constructeur : ses parametres sont l'enonce de la question,
     * la chaine correspondant a la reponse, et le nombre de points */
    public QuestionChaine(String q, String r, int p)
	{
		super(q, p) ;
		bonneReponse = r ;
    }

    /** methode permettant de lire la reponse du joueur */
    public void saisirReponseJoueur()
    {
		reponseDuJoueur = Clavier.readString() ;
    }

    /** methode retournant vrai si la reponse du joueur est correcte
     * (la comparaison ne prend pas en compte la difference minuscule/
     * majuscule) */
    public boolean bonneReponseTrouvee()
    {
		return reponseDuJoueur.equalsIgnoreCase(bonneReponse) ;
    }

    /** renvoie la reponse correcte */
    public String donnerBonneReponse() 
    {
    	return bonneReponse ;
   	}  
} 
