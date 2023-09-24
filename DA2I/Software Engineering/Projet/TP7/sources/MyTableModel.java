import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.table.* ;
import javax.swing.event.* ;
import javax.swing.JComboBox;

/** Le modele de table (TableModel) decrit la structure et le contenu des donnees,
 *  tandis que JTable ne fait que donner une representation graphique de ces
 *  donnees. */
public class MyTableModel extends AbstractTableModel implements TableModelListener
{
    // nom des champs
    private String[] columnNames = {"Nom", "Prenom", "Formation", "Age", "Lillois ?"};
    
    // donnees brutes
    private Object[][] data = {
	{"Belorgey", "Nicolas",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Biencourt", "Cyril",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Bo", "Thomas",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Bouteiller", "Yannick",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Buresi", "Stephane",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Cauchy", "Matthieu",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Deloor", "Sebastien",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Descamps", "Jean-Philippe",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Dupont", "Mathieu",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Fruchart", "Remy",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Girondel", "Etienne",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Hammiche", "Tony",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Lafarge", "Thomas",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Leclercq", "Maxime",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Lenoir", "Remy",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Poirot", "Vianney",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Ramos", "Sergio",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Salerano", "Riccardo",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Sans", "Benjamin",
	 "DA2I", new Integer(20), new Boolean(false)}
    };	
    
    private final JComboBox listeFormations = new JComboBox(
    		new String[] { "LP DA2I", "IUT FI1", "IUT FI2", "IUT FC", "IUT AS" }
    	);
    
    
    
    public MyTableModel()
    {
	
    }
    
    
    public void tableChanged(TableModelEvent e)
    {
        int row = e.getLastRow();
        String columnName = this.getColumnName(e.getColumn());
        System.out.println("Ligne : " + row + " | colonne : '"+ columnName +"'");
    }
    
        
    

    // Redefinition de quelques methodes de AbstractTableModel 

    /** Nombre de colonnes dans la table */
    public int getColumnCount() 
    { 
		return columnNames.length ; 
    }

    /** Nombre de lignes dans la table */
    public int getRowCount() 
    { 
		return data.length ; 
    }
    
    /** Nom du champ correspondant a la colonne specifiee */
    public String getColumnName(int col) 
    { 
		return columnNames[col] ; 
    }
    
    /** Valeur du champ de la colonne col pour la ligne specifiee */
    public Object getValueAt(int row, int col) 
    { 
		return data[row][col] ; 
    }

	public void setValueAt(Object o, int row, int col)
    {
    	this.data[row][col] = o;
    	fireTableCellUpdated(row, col);
    }
    
    
    
    public Class getColumnClass(int i) 
    { 
		return (this.data[0][i]).getClass() ; 
    }
    
    public boolean isCellEditable(int row, int col)
    {
    	return col >= (this.data[0].length - 3);
    }
    
    
    
    public JComboBox getListeFormations()
    {
    	return this.listeFormations;
    }
    
}
