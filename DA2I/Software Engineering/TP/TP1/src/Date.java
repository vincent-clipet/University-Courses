/**
 * Class 'Date'
 */

public class Date
{

    /** current state of the Date */
    private int day, month, year;   

    /** List of existing months */ 
    public static final String[][] MONTHS = {
	{ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" },
	{ "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"}
    };

    /** Constructor */
    public Date(int day, int month, int year)
    {
	this.day = day;
	this.month = month;
	this.year = year;
    }

    /** prints current date */
    public String toString()
    {
	return this.day + " " + MONTHS[1][this.month -1] + " " + this.year;
    }

    /** prints current date, according to Locale */
    public String printLocalized(String locale)
    {
	if (locale.startsWith("-fr"))
	    return this.toString();
	else if (locale.startsWith("-en"))
	    return this.year + " " + MONTHS[0][this.month -1] + " " + this.day;
	else
	    return this.toString();
    }

}