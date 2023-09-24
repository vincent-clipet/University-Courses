public interface Pile<E>
{

    int MAX_ELEMENTS = 100;

    boolean vide();
    boolean pleine();
    boolean peutEmpiler(E x);
    E sommet();
    E depile();
    void empile(E x);
    void vider();
    int nbElements();
    void deplacerElementVers(Pile<E> p);
    String toString();

}