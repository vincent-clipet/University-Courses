package salaires;

public class EmployeNormal
{

	//
	// --- Attributes ----------------------------
	//
	private double temps_travail, taux_horaire, majoration, heures; 
	private String nom;



	//
	// --- Constructors ----------------------------
	//
	public EmployeNormal(String nom)
	{
		this.temps_travail = 35;
		this.taux_horaire = 7.5;
		this.majoration = 1.25;
		this.nom = nom;
	}



	//
	// --- Methods ----------------------------
	//
	public double salaireHebdo()
	{
		if (heures > temps_travail)
			return (temps_travail * taux_horaire + (heures - temps_travail) * taux_horaire * majoration);
		else
			return heures * taux_horaire;

	}
	
	public String toString()
	{
		return this.nom;
	}



	//
	// --- Get & Set ----------------------------
	//
	public void setTravail(double h)
	{
		this.heures = h;
	}




}
