import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.table.* ;
import javax.swing.event.* ;

/** Le modele de table (TableModel) decrit la structure et le contenu des donnees,
 *  tandis que JTable ne fait que donner une representation graphique de ces
 *  donnees. */
public class CustomTableModel extends AbstractTableModel implements TableModelListener
{
    // nom des champs
    private String[] columnNames = {"Tranche d'age", "Effectif" };
    
    // donnees brutes
    private Object[][] data = {
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)},
		{"20 ans", new Integer(20)}
	};
	
	
    
    public CustomTableModel()
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
    	return false;
    }
    
}
