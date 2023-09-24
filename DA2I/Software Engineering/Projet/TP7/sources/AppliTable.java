import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.table.* ;
import javax.swing.event.* ;

/** L'application permettant de manipuler une JTable */
public class AppliTable extends JFrame 
{    

    public static void main(String [] a) 
    {
		// pour avoir une fenetre decoree au style Swing
		JFrame.setDefaultLookAndFeelDecorated(true);
		AppliTable i = new AppliTable();
		i.setVisible(true) ;
	}



	private JTable table ;
	private JTable table2;
	private JPanel dessin ;
	
	
	
	public AppliTable()
	{
		super("La loi des JTables") ;

		// action a effectuer lorsqu'on ferme la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// definition du gestionnaire de placement 
		getContentPane().setLayout(new FlowLayout()) ;



		// on cree la table a partir d'un modele de table maison
		MyTableModel tableModel = new MyTableModel();
		table = new MyJTable(tableModel);
		
		// CellEditor
		table.getColumnModel().getColumn(2).setCellEditor(
			new DefaultCellEditor(tableModel.getListeFormations())
		);
		tableModel.addTableModelListener(tableModel);
		
		// CellRenderer
    	table.getColumnModel().getColumn(2).setCellRenderer(
			new DefaultTableCellRenderer()
			{
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
				{
					super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					//setToolTipText((String)table.getValueAt(row, 0));
					setToolTipText("Formation");
			 	 	return this;
				}
			}
    	);
    	
    	
    	
    	// CustomJTable
    	CustomTableModel customTableModel = new CustomTableModel();
		table2 = new CustomJTable(customTableModel);
		
		
		
		// JButton
		JButton button = new JButton("Calculer");
		button.addActionListener(new ButtonActionListener(tableModel, customTableModel));


		// et on la place dans un JScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(600, 200));
		JScrollPane scrollPane2 = new JScrollPane(table2);
		table2.setPreferredScrollableViewportSize(new Dimension(200, 200));

		getContentPane().add(scrollPane) ;
		getContentPane().add(scrollPane2) ;
		getContentPane().add(button);
		setBounds(400,200,800,400) ;
	}
}
