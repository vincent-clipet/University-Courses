package mesCollections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ArbreLexical implements Set<String> 
{

	private boolean estMot ;
	private ArbreLexical[] fils ;



	// cree un noeud vide de l'arbre lexical
	public ArbreLexical() {
		this.clear() ;
	}

	private void initFils()
	{
		fils = new ArbreLexical[26] ;
	} 

	// indice du tableau fils correspondant a une lettre 
	private int indexOf(char c)
	{
		return c - 'a' ;
	}

	// lettre correspondant a un indice du tableau fils
	private char charAt(int index)
	{
		return (char)('a' + index) ;
	}

	private boolean estMot()
	{
		return estMot ;
	}

	private void defMot(boolean b)
	{
		estMot = b ;
	}

	/** Affiche tous les mots contenus dans l'arbre lexical */
	public String toString()
	{ 
		StringBuffer b = new StringBuffer(); 
		this.printWith("", b) ; 
		return b.toString() ;
	}

	// cette methode passe en parametre un "prefixe" qui correspond
	// aux branches deja parcourues, et ajoute les nouveaux mots dans
	// le StringBuffer result
	private void printWith(String prefix, StringBuffer result) 
	{
		if (this.estMot())
			result.append(prefix + "\n") ;

		for (int i=0; i<fils.length; i++)
			if (fils[i] != null)
				fils[i].printWith(prefix + this.charAt(i), result) ;
	}

	private String motLePlusLong(String prefix)
	{
		String result = "" ;
		// 
		// a completer ! // TODO
		//
		return result ;		
	}

	// Retourne le meme tableau de 'char' sans les caracteres autres que des lettres
	private boolean containsInvalidChar(String word)
	{
		char[] c = word.toCharArray();

		for (char iter : c)
		{
			int i = indexOf(iter);

			if (i < 0 || i >= 26)
				return true;
		}

		return false;
	}

	/*private String deleteInvalidChars(String word)
	{
		StringBuilder sb = new StringBuilder();
		char[] c = word.toCharArray();

		for (char iter : c)
		{
			int i = indexOf(iter);

			if (i >= 0 && i < 26)
				sb.append(iter);
		}

		return sb.toString();
	}*/

	// Retourne 'true' si la chaine d'entree est vide ou nulle
	private boolean isEmptyOrNullString(String s)
	{
		return (s == null || s.length() == 0);
	}

	// Retourne 'true' si 'sa' est plus bas que 'sb' dans l'ordre alphabetique
	private boolean isAGreaterThanB(String sa, String sb)
	{
		if (sa.equals(sb))
			return false;

		int[] a = new int[sa.length()];
		int[] b = new int[sb.length()];

		for (int i = 0; i < a.length; i++)
			a[i] = indexOf(sa.charAt(i));

		for (int i = 0; i < b.length; i++)
			b[i] = indexOf(sb.charAt(i));

		for (int i = 0; i < b.length; i++)
		{
			if (a[i] > b[i])
				return true;
			else if (a[i] < b[i])
				return false;
			//else : a[i] = b[i]
		}

		return a.length > b.length;
	}

	//////////////////////////////////////////////////////////////////
	// 
	// ICI COMMENCE L'IMPLEMENTATION DE java.util.Set
	//
	//////////////////////////////////////////////////////////////////

	/** Ajoute un mot a l'arbre lexical. Le mot ne peut etre ajoute
	 * que s'il n'est pas deja present, et ne comporte aucun autre
	 * caractere que les 26 lettres de l'alphabet. Ces lettres sont
	 * stockees en minuscules. 
	 * @param word le mot a ajouter
	 * @return <code>true</code> si le mot a bien ete ajoute,
	 * <code>false</code> sinon
	 */
	public boolean add(String word)
	{
		if (isEmptyOrNullString(word))
			return false;

		if (containsInvalidChar(word))
			return false;

		//word = deleteInvalidChars(word.toLowerCase());

		if (this.contains(word))
			return false;

		return add2(word);
	}

	private boolean add2(String newWord)
	{		
		char firstLetter = newWord.charAt(0);
		int index = indexOf(firstLetter);
		boolean isLast = newWord.length() == 1;

		if (this.fils[index] == null)
			this.fils[index] = new ArbreLexical();

		if (isLast)
		{
			this.fils[index].defMot(true);
			return true;
		}
		else
			return this.fils[index].add2(newWord.substring(1));
	}

	/** Verifie l'existence de 'o' dans l'arbre 
	 * @param o le mot a verifier
	 * @return <code>true</code> si l'arbre contient bien 'o',
	 * <code>false</code> sinon
	 */
	public boolean contains(Object o)
	{
		if (! (o instanceof String))
			return false;

		String word = (String)o;

		if (isEmptyOrNullString(word))
			return false;

		char firstLetter = word.charAt(0);
		int index = indexOf(firstLetter);
		boolean mustFindSon = word.length() > 1;

		if (this.fils[index] == null)
			return false;

		if (mustFindSon)
			return this.fils[index].contains(word.substring(1));
		else
			return this.estMot();
	}

	/** Supprime l'element 'o' de l'arbre 
	 * @param o le mot a supprimer
	 * @return <code>true</code> si la suppression a ete effectuee,
	 * <code>false</code> sinon
	 */
	public boolean remove(Object o)
	{
		if (! (o instanceof String))
			return false;

		String word = (String)o;

		if (! this.contains(word)) // le mot n'existe pas
		{
			return false;
		}	
		else // on continue de s'enfoncer dans l'arbre
		{
			char firstLetter = word.charAt(0);
			int index = indexOf(firstLetter);

			if (word.length() == 1) // derniere lettre
			{
				this.defMot(false);
				return this.isEmpty();
			}
			else
			{
				String newWord = word.substring(1);
				boolean nextStepNeedsRemoval = this.fils[index].remove(newWord);

				if (nextStepNeedsRemoval) // besoin de supprimer le noeud 'fils[index]'
				{
					this.fils[index] = null;
					return this.isEmpty();
				}
				else // rien a faire
				{
					return false;
				}
			}
		}
	}

	/** Verifie l'existence de tous les elements de 'c' dans l'arbre 
	 * @param c la collection a verifier
	 * @return <code>true</code> si l'arbre contient bien tous les elements de 'o',
	 * <code>false</code> sinon
	 */
	public boolean containsAll(Collection<?> c)
	{
		Iterator<String> iter = (Iterator<String>)(c.iterator());

		while (iter.hasNext())
		{
			if (! this.contains(iter.next()))
				return false;
		}

		return true;
	}

	/** Ajoute tous les elements de 'c' dans l'arbre 
	 * @param c la Collection a ajouter
	 * @return <code>true</code> si tous les mots ont bien ete ajoutes a l'arbre,
	 * <code>false</code> sinon
	 */
	public boolean addAll(Collection<? extends String> c)
	{
		Iterator<String> iter = (Iterator<String>)(c.iterator());
		boolean ret = true;

		while (iter.hasNext())
		{
			if (! this.add(iter.next()))
				ret = false;
		}

		return ret;
	}

	/** Supprime tous les elements de 'c' de l'arbre
	 * @param c la collection de mots a supprimer
	 * @return <code>true</code> si tous les elements de 'c' ont ete supprimes de l'arbre,
	 * <code>false</code> sinon
	 */
	public boolean removeAll(Collection<?> c)
	{
		Iterator<String> iter = (Iterator<String>)(c.iterator());
		boolean ret = true;

		while (iter.hasNext())
		{
			if (! this.remove(iter.next()))
				ret = false;
		}

		return ret;
	}

	/** Supprime tous les elements de l'arbre qui ne sont pas dans 'c' 
	 * @param c la collection de mots a garder
	 * @return <code>true</code> si l'arbre a ete modifie,
	 * <code>false</code> sinon
	 */
	public boolean retainAll(Collection<?> c)
	{
		Iterator<String> iter = (Iterator<String>)(c.iterator());
		boolean ret = false;

		while (iter.hasNext())
		{
			if (! this.contains(iter.next()))
				iter.remove();
		}

		Iterator<String> iter2 = (Iterator<String>)(this.iterator());

		while (iter2.hasNext())
		{
			if (! c.contains(iter2.next()))
			{
				iter2.remove();
				ret = true;
			}
		}

		return ret;
	}

	/** Vide l'arbre actuel */
	public void clear()
	{
		this.defMot(false) ;
		this.initFils() ;
	}

	/** Retourne 'true' si l'arbre ne contient aucun element 
	 * @return <code>true</code> si l'arbre est vide,
	 * <code>false</code> sinon
	 */
	public boolean isEmpty()
	{
		for (int i = 0; i < 26; i++)
		{
			if (this.fils[i] != null)
				return false;
		}

		return true;

		//return size() == 0;
	}

	/** Retourne le nombre d'elements contenus dans l'arbre 
	 * @return le nombre de mots dans l'arbre
	 */
	public int size()
	{
		int count = 0;

		if (this.estMot())
			count++;

		for (int i = 0; i < 26; i++)
		{
			if (this.fils[i] != null)
				count += this.fils[i].size();
		}

		return count;
	}

	/** Teste l'egalite du contenu de l'arbre avec le contenu de 'o' 
	 * @param o la Collection a comparer
	 * @return <code>true</code> si l'arbre et la collection contiennent les memes elements
	 * <code>false</code> sinon
	 */
	public boolean equals(Object o) // TODO 
	{
		if (! (o instanceof Collection<?>))
			return false;

		Collection<?> c = (Collection<?>)o;

		if (c.size() != this.size())
			return false;

		return false;
	}

	public int hashCode()
	{
		String[] all = this.toArray(null);
		int hash = 0;

		for (String s : all)
			hash += s.hashCode();

		return hash;
	}

	/** Retourne un iterateur de chaines de caracteres qui permet
	 * d'avoir un acces sequentiel a tous les mots de l'arbre
	 * lexical. */
	public Iterator iterator()
	{
		return new ArbreIterator(this);
	}

	// Fonctionne
	private ArbreLexical getBranch(String word, int depth)
	{
		char firstLetter = word.charAt(0);
		int index = indexOf(firstLetter);
		depth--;

		if (depth > 0)
			return this.fils[index].getBranch(word.substring(1), depth);
		else
			return this.fils[index];
	}

	// Ne fonctionne pas
	/*private String getNextWord(String originalWord, String word)
	{
		System.out.println("mot : " + word);

		char[] charWord = word.toCharArray();
		int index = indexOf(charWord[0]);
		ArbreLexical arbre = getBranch(word, word.length());

		//System.out.println("empty : " + arbre.isEmpty());

		//if (! arbre.isEmpty())
		//{
		if (! arbre.estMot()) // TODO : marche ???
		{
			for (int i = index; i < 26; i++)
			{
				if (arbre.fils[i] != null)
				{
					String nextWord = getNextWord(originalWord, word + charAt(i));

					if (nextWord != null)
					{
						if (arbre.fils[i].estMot())
						{
							if (isAGreaterThanB(nextWord, originalWord))
								return nextWord;
						}
					}
				}
			}
		}
		else
		{
			return null;
		}

		return "ERREUR";
	}*/

	// Fonctionne
	/*private String getNext(String prevWord)
	{
		for (int i = prevWord.length(); i > 0; i--)
		{
			ArbreLexical a = getBranch(prevWord, i);
			int size = a.size();

			if (a.isEmpty())
				size = 0;

			System.out.println("----------------------");
			System.out.println(a.toString());
			System.out.println(size);

			if (size > 1)
				return getNextWord(prevWord, prevWord.substring(0, i));
		}

		return null;
	}*/


	// methode privee qui recense les mots et les place un a un dans t
	private int makeArray(String prefix, String[] t, int index)
	{
		int idx = index ;

		if (this.estMot())
		{
			t[index] = prefix ;	
			idx = index + 1 ;
		}

		for (int i=0; i<fils.length; i++)
			if (fils[i] != null) 
				idx = fils[i].makeArray(prefix + this.charAt(i), t, idx) ;

		return idx ;
	}

	public <T>T[] toArray(T[] t)
	{
		String[] result = new String[this.size()] ;
		this.makeArray("", result, 0) ;

		//for (String o2 : result)
		//System.out.println(o2);

		return (T[]) result ;
	}

	public Object[] toArray()
	{		
		return this.toArray(null) ; 
	}
}
