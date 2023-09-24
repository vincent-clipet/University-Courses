package mesCollections;

import java.util.Iterator;

class ArbreIterator implements Iterator
{

	private ArbreLexical arbre;
	private String lastWord;
	private int index;



	public ArbreIterator(ArbreLexical al)
	{
		this.arbre = al;
		this.index = 0;
		this.lastWord = null;
	}


	/** Retourne 'true' si la collection en cours d'iteration contient encore des objets 
	 * @return <code>true</code> si la collection contient encore des objets,
	 * <code>false</code> sinon
	 */
	public boolean hasNext()
	{
		return this.index + 1 == this.arbre.size();
	}

	/** Itere a l'objet suivant de la collection 
	 * @return L'objet suivant
	 */
	public Object next()
	{


		return null;
	}

	/** Supprime de la collection le dernier element parcouru par l'iterateur via 'next()' */
	public void remove()
	{
		this.arbre.remove(this.lastWord);
	}


}
