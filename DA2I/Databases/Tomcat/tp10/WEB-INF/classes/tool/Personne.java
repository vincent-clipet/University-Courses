package tool;
import java.sql.*;

public class Personne
{

	//
	// --- Attributes ----------------------------
	//
	private int id;
	private String nom;
	private String prenom;
	private String sexe;
	private String tel;
	private String fonction;
	
	
	
	//
	// --- Constructors ----------------------------
	//
	public Personne(int id, String nom, String prenom, String sexe, String tel, String fonction)
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.tel = tel;
		this.fonction = fonction;
	}
	


	//
	// --- Methods ----------------------------
	//
	public String getHTML()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("<table>\n")
		.append("\t<tr>\n\t\t<td>ID</td><td>" + this.id + "</td></tr>")
		.append("\t<tr>\n\t\t<td>Nom</td><td>" + this.prenom + " " + this.nom + "</td></tr>")
		.append("\t<tr>\n\t\t<td>Sexe</td><td>" + this.sexe + "</td></tr>")
		.append("\t<tr>\n\t\t<td>Tel.</td><td>" + this.tel + "</td></tr>")
		.append("\t<tr>\n\t\t<td>Poste</td><td>" + this.fonction + "</td></tr>")
		.append("</table>");
		
		return sb.toString();
	}
	
	
	

	//
	// --- Get & Set ----------------------------
	//
	public int getId() { return this.id; }	
	public String getNom() { return this.nom; }
	public String getPrenom() { return this.prenom; }
	public String getSexe() { return this.sexe; }
	public String getTel() { return this.tel; }
	public String getFonction() { return this.fonction; }

	public void setId(int id) { this.id = id; }	
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setSexe(String sexe) { this.sexe = sexe; }
	public void setTel(String tel) { this.tel = tel; }
	public void setFonction(String fonction) { this.fonction = fonction; }

}
