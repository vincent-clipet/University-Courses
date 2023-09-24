

import java.util.Scanner;
import java.util.ArrayList;
import mesCollections.ArbreLexical;

class LireDico
{

	public static void main (String[] args)
	{
		ArbreLexical arbre = new ArbreLexical();
		ArrayList<String> liste = new ArrayList<String>();


		// ----------------------
		// Ajout des donnees
		// ----------------------

		Scanner scan = new Scanner(System.in);
		String s = scan.next();

		while (! s.equals("STOP"))
		{
			boolean b = arbre.add(s);
			liste.add(s);
			s = scan.next();
		}

		// arbre.size() : 35491
		// liste.size()) : 37952
		// Ces 2 nombres ne peuvent etre egaux :
		// l'ArrayList peut contenir n'importe quelle chaine de caractere en n'importe quel nombre;
		// alors que l'ArbreLexical ne peut pas contenir de doublons, ni de mot contenant d'autres caracteres que des lettres standards (ex "-", "ç")





		// ----------------------
		// Temps de lecture
		// ----------------------

		long start, end;

		start = System.currentTimeMillis();
		System.out.println(arbre);
		end = System.currentTimeMillis();
		long diffArbre = end - start;

		start = System.currentTimeMillis();
		System.out.println(liste);
		end = System.currentTimeMillis();
		long diffListe = end - start; 





		// ----------------------
		// Recherche
		// ----------------------

		start = System.currentTimeMillis();

		for (int i = 0; i < 50000; i++)
			arbre.contains("zygomatique");

		end = System.currentTimeMillis();
		long diffRechercheArbre = end - start;

		start = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++)
			liste.contains("zygomatique");

		end = System.currentTimeMillis();
		long diffRechercheListe = end - start;

		// Nombre d'iterations augmentees a 50000 pour mieux voir les differences de temps






		System.out.println("arbre.size() = " + arbre.size()); // 35491
		System.out.println("liste.size() = " + liste.size()); // 37952		

		System.out.println("Affichage ArbreLexical : " + diffArbre + " ms"); // ~865 ms
		System.out.println("Affichage ArrayList : " + diffListe + " ms"); // ~870 ms

		System.out.println("Recherche ArbreLexical : " + diffRechercheArbre + " ms"); // ~8 ms
		System.out.println("Recherche ArrayList : " + diffRechercheListe + " ms"); // ~2406 ms
	}

	// On peut voir que la recherche est bien plus rapide dans l'ArbreLexical, car pas besoin de l'iterer integralement pour trouver le resultat.

}
