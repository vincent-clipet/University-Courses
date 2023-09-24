public class TreeNode
{
	//
	private TreeNode no;
	private TreeNode yes;
	private String name;
	private int level;


    /**
     * Main loop
     */
	public static void main(String[] args)
	{
		//args[0] = "Est-ce un mammifere ?";
		//args[1] = "crocodile";
		//args[2] = "chien";

		//TODO: Dynamic

		TreeNode node = new TreeNode(args[0], 0);
		node.setLeaves(new TreeNode(args[1], 1), new TreeNode(args[2], 1));

		while (true)
		{
			System.out.println("Nouvelle question !");
			node.rechercherAnimal();
			System.out.println("-----------------------");
			//node.printFullTree(true);
			//System.out.println(node.toString());
			//System.out.println("-----------------------");
			System.out.println("\n" + node.toString());

			System.out.println(node.definir("chat"));
		}
	}



   /**
   * CONSTRUCTOR
   */
	public TreeNode(String name, int level)
	{
		this.name = name;
		this.level = level;
		this.no = this.yes = null;
	}



	//
	// METHODS
	//
    /**
     * Permet d'ajouter un nouvel animal dans l'arbre
     */
	private void apprendreAnimal(String what, String newQuestion, String answer)
	{
		boolean newAnswer = getAnswerFromString(answer);

		if (! newAnswer) // if (reponse.equals("non"))
		{
			this.yes = new TreeNode(this.name, this.level + 1);
			this.no = new TreeNode(what, this.level + 1);
		}
		else
		{
			this.no = new TreeNode(this.name, this.level + 1);
			this.yes = new TreeNode(what, this.level + 1);
		}

		this.name = newQuestion;
	}

    /**
     * Pose des questions à l'utilisateur pour trouver un animal précis. Si aucun résultat, déclenche l'apprentissage d'un nouvel animal.
     */
	public void rechercherAnimal()
	{
		System.out.println(getQuestion());
		String in = Clavier.readString();

		boolean answer = getAnswerFromString(in);
		TreeNode branch = getBranchFromAnswer(answer);

		if (branch == null)
		{
			if (! answer)
			{
				System.out.println("Qu'est-ce que c'est ?");
				String what = Clavier.readString();
				System.out.println("Donnez une question permettant de differencier '"+what+"' de '"+this.name+"'");	
				String newQuestion = Clavier.readString();
				System.out.println("Quelle doit etre la reponse pour un '"+what+"' ?");
				String newAnswer = Clavier.readString();
				apprendreAnimal(what, newQuestion, newAnswer);
			}
			else
				System.out.println("Bravo !");
		}
		else
		{	
			branch.rechercherAnimal();
		}
	}

    /**
     * Affiche l'arbre complet 
     */
	public void printFullTree(boolean parent)
	{
		StringBuffer sb = new StringBuffer(" ");

		for (int i = 0; i < this.level; i++)
			sb.append("|");

		sb.append("\\_");

		if (parent)
			sb.append(" y: ");
		else
			sb.append(" n: ");

		sb.append(this.name);

		System.out.println(sb.toString());

		if (! this.isLeaf())
		{
			this.no.printFullTree(false);
			this.yes.printFullTree(true);
		}
	}

    /**
     * Permet d'afficher le chemin dans l'arbre menant à un animal précis. Si aucun résultat, n'affiche rien.
     */
	public String definir(String animal)
	{	
		if (this.isLeaf())
		{
			if (this.name.equals(animal))
				return this.name;
			else 
				return null;
		}
		else
		{
			String answerNo = this.no.definir(animal);
			String answerYes = this.yes.definir(animal);

			if (answerNo == null && answerYes == null)
			    return null;
			else if (answerNo != null && this.no.isLeaf())
			    return " -> " + this.name + " => non : " + answerNo;
			else if (answerNo != null)
			    return " -> " + this.name + answerNo;
			else if (answerYes != null && this.yes.isLeaf())
			    return " -> " + this.name + " => oui : " + answerYes;
			else if (answerYes != null)
			    return " -> " + this.name + answerYes;
			else
			    return null;
		}
	}

    /**
     * Retourne la branche "yes" ou "no"
     */
	public TreeNode getBranchFromAnswer(boolean b)
	{
		if (b)
			return this.yes;
		else
			return this.no;
	}

    /**
     * Retourne un boolean selon l'input de l'utilisateur ('yes' ou 'no')
     */
	public boolean getAnswerFromString(String s)
	{
		if (s.startsWith("y") || s.startsWith("Y") || s.startsWith("o") || s.startsWith("O"))
			return true;
		else
			return false;
	}

    /**
     * Retourne 'true' si la node actuelle est une feuille
     */
	public boolean isLeaf()
	{
		//return this.yes == null || this.no == null;
		return ! hasQuestion();
	}

	public String getQuestion()
	{
		if (hasQuestion())
			return this.name;
		else
			return "Est-ce que c'est un " + this.name + " ?";
	}

    /**
     * Retourne "true" si l'élément actuel est une question (équivaut à '! isLeaf()' )
     */
	public boolean hasQuestion()
	{
		return this.name.contains("?");
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder(" " + this.name);

		if (this.no != null)
			sb.append(" " + this.no.toString());

		if (this.yes != null)
			sb.append(" " + this.yes.toString());

		return sb.toString();
	}



	//
	// GET & SET
	//
	public void setLeaves(TreeNode no, TreeNode yes)
	{
		this.no = no;
		this.yes = yes;
	}

	public String getName()
	{
		return this.name;
	}

}
