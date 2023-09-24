import java.util.ArrayList;

/**
 * Quiz : classe qui contient un ensemble de questions
 * et les pose au joueur. On calcule ensuite son score et on
 * le compare au score maximal atteignable.
 *
 * @author S. Picault, d'apres idee de P. Mathieu
 */

public class Quiz
{
    private ArrayList<Question> questions;
    // total : le score total theorique, score : le score du joueur
    private int total, score;

    /** constructeur pour un nombre de questions donne */
    public Quiz(int size) 
    {
		questions = new ArrayList<Question>(size);
    }

    /** constructeur pour 10 questions (nombre par defaut) */
    public Quiz()
    {
    	this(10); 
    }

    /** ajoute l'argument q a la liste des questions */
    public void ajouteQuestion(Question q) 
    {
		questions.add(q) ;
    }

    /** pose la question q au joueur : l'affiche, demande a la question q
     * de lire la reponse, de verifier la reponse, et met a jour le score
     * du joueur en cas de succes. En cas d'echec, demande a la question q
     * la reponse correcte */
    public void poserQuestion(Question q)
    {
    	boolean error = true;
    	
    	while (error)
    	{
			System.out.println(q);
			System.out.print("Reponse : ");
		
			try
			{
				q.saisirReponseJoueur();
				error = false;
			}
			catch (NumberFormatException exc)
			{
				System.out.println("Format d'entree incorrect, veuillez entrer une valeur valide.");
			}
		}
		
		if (q.bonneReponseTrouvee())
		{
			System.out.println("Exact !\n");
			score += q.getValeur();
		}
		else
			System.out.println("Faux, la reponse etait " + q.donnerBonneReponse() + "\n");
			
		total += q.getValeur();
    }

    /** jouer, c'est poser toutes les questions */
    public void jouer()
    {
		// on pose toutes les questions
		for (Question q : this.questions)
			poserQuestion(q) ;
			
		// et on affiche le score
		System.out.println("FIN DU QUIZ... Vous avez obtenu " + score + "/" + total);
    }

    /** exemple d'utilisation avec toutes les classes possibles */
    public static void main(String [] args) 
    {
		Quiz q = new Quiz();

		q.ajouteQuestion(new QuestionNumerique("Date de la Revolution francaise",1789,1));
		q.ajouteQuestion(new QuestionCaractere("Dans le code ASCII, quel caractere a le code 65",(char)65,2));
		q.ajouteQuestion(new QuestionChaine("Quelle est la couleur de la planete Mars",
				  "rouge", 2)) ;
		q.ajouteQuestion(new QuestionOuiNon("DOS est un systeme multi-taches","non",2));
		q.ajouteQuestion(new QuestionNumerique("Date de la mort de Louis XVI",1793,3));
		q.ajouteQuestion(new QuestionCaractere("Quelle lettre precede le M",'L',1));
		
		q.ajouteQuestion(new QuestionNumeriqueOuverte
				 ("Donnez un nombre impair",
				  new VerificateurNumerique () {
					  public boolean verifier(int x)
					    { return x % 2 == 1 ; }
				  }, "1, 3, 5, 7...", 2));
				  
		q.ajouteQuestion(
				new QuestionCaractereOuverte(
					"Donnez une consonne",
				  	new VerificateurCaractere ()
				  	{
						public boolean verifier(char x)
					    {
					    	return "AEIOUYaeiouy".indexOf(x) < 0 ;
					    }
				}, "Tout sauf a, e, i, o, u ou y", 1));
				  
		q.ajouteQuestion(new QuestionOuiNon
				 ("En logique FAUX implique VRAI","oui",3));
		
		q.jouer();
	}
}
