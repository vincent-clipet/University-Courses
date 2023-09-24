class PileTableau<E> implements Pile<E>
{

    private E[] elements;
    private int nbElements = 0;
    String nom;



    public PileTableau(String nom)
    {
	this.nom = nom;
	this.elements = (E[]) new Object[MAX_ELEMENTS];
    }

    public boolean vide()
    {
	return this.nbElements == 0;
    }

    public boolean pleine()
    {
	return this.nbElements == 100;
    }

    public boolean peutEmpiler(E x)
    {
	return ! this.pleine();
    }

    public E sommet()
    {
	return this.elements[this.nbElements - 1];
    }

    public E depile()
    {
	this.nbElements--;
	E ret = this.elements[this.nbElements];
	this.elements[this.nbElements] = null;
	
	return ret;
    }

    public void empile(E x)
    {
	this.elements[this.nbElements] = x;
	this.nbElements++;
    }

    public void vider()
    {
	while (this.nbElements >= 0)
	    depile();
    }

    public int nbElements()
    {
	return this.nbElements;
    }

    public void deplacerElementVers(Pile<E> p)
    {
	// System.out.println(this.nom + " --> " + ((PileTableau<E>)p).nom);
	p.empile(this.depile());
    }

    public String toString()
    {
	StringBuilder sb = (new StringBuilder()).append("------- ").append(this.nom).append(" -------").append('\n');
	
	for (int i = this.nbElements - 1; i >= 0; i--)
	    sb.append(i).append(": ").append(this.elements[i].toString()).append('\n');

	return sb.toString();

    }

    public String getNom()
    {
	return this.nom;
    }

}