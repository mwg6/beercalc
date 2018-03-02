package beerCalculator;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class beerTable extends JPanel{
	
	   private String[] COLUMNS = {"Name", "Type", "Quantity", "Units" };
	   private DefaultTableModel model = new DefaultTableModel(COLUMNS, 0);
	   private JTable table = new JTable(model);
	   public int fileCount = 0;
	  
	   
	   public beerTable() {
	      setLayout(new BorderLayout());
	      add(new JScrollPane(table));
	   }
	    
	   public void addRow(String name, String type, double quantity, String units) {
	      Object[] row = new Object[4];
	      row[0] = name;
	      row[1] = type;
	      row[2] = quantity;
	      row[3] = units;
	      model.addRow(row);
	   }
	   public int getFileCount(){
		   return fileCount;
	   }
	   public JTable getJTable(){
		   return table;
	   }
	   public double sumColumn(int column){
		   int i =0;
		   double total = 0;
		   while(i<table.getRowCount()){
			   if(table.getValueAt(i, 3).equals("lb.")&&table.getValueAt(i, 1).equals("Grain")){
			   total = total + Double.parseDouble(table.getValueAt(i,2) +"");
			   i++;
			   }
			   else if(table.getValueAt(i, 1).equals("Hops")||table.getValueAt(i, 1).equals("Other")){
				   i++;
			   }
			   else if(table.getValueAt(i, 3).equals("oz.")){
				   total = total + (Double.parseDouble(table.getValueAt(i,2) +""))/16 + (Double.parseDouble(table.getValueAt(i,2) +""))%16;
				   i++;
			   }
			   else if(table.getValueAt(i, 3).equals("kg.")){
				   total = total + (Double.parseDouble(table.getValueAt(i,2) +""))*2.24;
				   i++;
			   }
			   else if(table.getValueAt(i, 3).equals("g.")){
				   total = total + (Double.parseDouble(table.getValueAt(i,2) +""))/.0224+(Double.parseDouble(table.getValueAt(i,2) +""))%.0224;
				   i++;
			   }
		   }
		   System.out.println(total);
		   return total;
	   }
}
