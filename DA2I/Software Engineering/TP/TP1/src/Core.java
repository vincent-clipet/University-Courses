/**
 * Class 'Core'
 */

public class Core
{
    /** Main method */
    public static void main(String[] args)
    {
	/** reading keyboard input 3 times */
	int day = Clavier.readInt();
	int month = Clavier.readInt();
	int year = Clavier.readInt();

	/** creates new instance of 'Date' */
	Date date = new Date(day, month, year);

	/** prints current date */
	System.out.println(date.printLocalized(args[0]));
    }

}