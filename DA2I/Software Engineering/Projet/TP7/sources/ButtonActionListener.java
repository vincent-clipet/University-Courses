import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.table.* ;
import javax.swing.event.* ;

public class ButtonActionListener()
{

	private MyTableModel tableModel;
	private CustomTableModel customTableModel;
	
	

	public ButtonActionListener(MyTableModel tableModel, CustomTableModel customTableModel)
	{
		this.tableModel = tableModel;
		this.customTableModel = customTableModel;
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		for (int j = 0; j < this.tableModel.getRowCount(); j++)
		{
			int age = (Integer)(getValueAt(j, 3));
			System.out.println("age : " + age);
		}
	}
}
