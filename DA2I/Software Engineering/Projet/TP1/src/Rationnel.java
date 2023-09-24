/** 
 * Class 'Rationnel'
 */

public class Rationnel
{
    
    private int a;
    private int b;
    private int n;

    /** Creates a new instance of 'Rationnel', with parameters n, a & b */
    public Rationnel(int n, int a, int b)
    {
	this.a = a;
	this.b = b;
	this.n = n;
	shorten();
    }

    /** Creates a new instance of 'Rationnel', with parameters 0, a & b */
    public Rationnel(int a, int b)
    {
	this(0, a, b);
    }

    /** Creates a new instance of 'Rationnel', with parameters n, 0 & 1 */
    public Rationnel(int n)
    {
	this(n, 0, 1);
    }

    /** Returns true if current 'Rationnel' is nul */
    public boolean isNul()
    {
	return (this.n * this.b + this.a) == 0;
    }

    /** Calculates inverse of the current 'Rationnel' */
    public Rationnel getInverse()
    {
	int tmpA = this.b;
	int newB = this.n * this.b + this.a;
	int newN = tmpA / newB;
	int newA = tmpA % newB;

	return new Rationnel(newN, newA, newB);
    }

    /** Calculates sum between two 'Rationnel' */
    public Rationnel getSum(Rationnel r)
    {
	int newN = this.n + r.getN();
	int newA = this.a * r.getB() + this.b * r.getA();
	int newB = this.b * r.getB();

	return new Rationnel(newN, newA, newB);
    }

    /** Calculates product between two 'Rationnel' */
    public Rationnel getProduct(Rationnel r)
    {
	int newN = this.n * r.getN();
	int newA = (this.n * r.getA() * this.b) + (this.a * r.getN() * r.getB()) + (this.a * r.getA());
	int newB = this.b * r.getB();

	return new Rationnel(newN, newA, newB);
    }

    /** Compares two 'Rationnel' */
    public 
	    if (this.a == this.b)
	    {
		this.a = 0;
		this.n += 1;
		break;
	    }
	    
	    pgcd = Rationnel.getPGCD(this.a, this.b);
	}
    }

    /* Makes current 'Rationnel' positive */
    private void transformIntoPositive()
    {
	if (this.b < 0)
	{
	    this.a *= -1;
	    this.b *= -1;
	}

	if (this.a < 0)
	{
	    this.n = this.n + (this.a / this.b - 1);
	    this.a = this.b + this.a % this.b;
	}
    }

    /** Serializing */
    public String toString()
    {
	StringBuilder sb = new StringBuilder();

	if (n != 0)
	    sb.append(this.n + " + ");

	if (a == 0)
	    sb.append("0");
	else
	    sb.append(this.a + "/" + this.b);

		return sb.toString();
    }

    public int getN()
    {
	return this.n;
    }

    public int getA()
    {
	return this.a;
    }

    public int getB()
    {
	return this.b;
    }

}