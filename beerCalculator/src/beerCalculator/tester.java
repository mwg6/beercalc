package beerCalculator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class tester {
	

	public void createWindow() {
		// create
		JFrame frame = new JFrame("Water Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 Object rowData[][] = { { "1-1", "1-2", "1-3", "1-4" },
			        { "2-1", "2-2", "2-3", "2-4"} };
			    Object columnNames[] = { "Name", "Type", "Quantity", "Units" };
			    DefaultTableModel model = new DefaultTableModel(columnNames,1);
			    JTable table = new JTable(model);

			    //Make type typeBox
			    TableColumn type = table.getColumnModel().getColumn(1);
			    JComboBox typeBox = new JComboBox();
			    typeBox.addItem("Grain");
			    typeBox.addItem("Hops");
			    typeBox.addItem("Other");
			    type.setCellEditor(new DefaultCellEditor(typeBox));
			    
			    //Make Units typeBox
			    TableColumn units = table.getColumnModel().getColumn(3);
			    JComboBox unitBox = new JComboBox();
			    unitBox.addItem("lbs.");
			    unitBox.addItem("oz.");
			    unitBox.addItem("Kg.");
			    unitBox.addItem("g.");
			    units.setCellEditor(new DefaultCellEditor(unitBox));
			    
			    //add button
			    JButton addRow = new JButton("add row");
			    frame.add(addRow,BorderLayout.SOUTH);
			    
			    //implement button utility
			    TextHandler a = new TextHandler();
			    addRow.addActionListener(a);
			    
			    JScrollPane scrollPane = new JScrollPane(table);
			    frame.add(scrollPane, BorderLayout.CENTER);
			    frame.setSize(300, 150);
			    frame.setVisible(true);
	}
private class TextHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
	}
}
	

	public static void main(String[] args) {
		tester a = new tester();
		a.createWindow();

	}

}
