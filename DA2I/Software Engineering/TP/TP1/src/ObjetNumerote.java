public class ObjetNumerote
{

    public static int counter = 1;
    private int num;

    public ObjetNumerote()
    {
	this.num = ObjetNumerote.counter;
	ObjetNumerote.counter++;
    }

    public String toString()
    {
	return "instance n°" + this.num;
    }

}