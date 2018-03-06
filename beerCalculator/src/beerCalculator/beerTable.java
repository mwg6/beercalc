package beerCalculator;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class beerTable extends JPanel{
	
	//We make the column headers here, and create a JTable with no initial rows
	   private String[] COLUMNS = {"Name", "Type", "Quantity", "Units" };
	   private DefaultTableModel model = new DefaultTableModel(COLUMNS, 0);
	   private JTable table = new JTable(model);
	  
	   //add our table within a scroll pane
	   public beerTable() {
	      setLayout(new BorderLayout());
	      add(new JScrollPane(table));
	   }
	    
	//method for adding a row. adds an array containing passed objects from user input
	   public void addRow(String name, String type, double quantity, String units) {
	      Object[] row = new Object[4];
	      row[0] = name;
	      row[1] = type;
	      row[2] = quantity;
	      row[3] = units;
	      model.addRow(row);
	   }
	
	//not sure if this is still used
	   public JTable getJTable(){
		   return table;
	   }
	
	// necessary for converting grain to lbs regardless of unit and returning the total of grain in pounds
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

		   return total;
	   }
	
	//makes a string of the names of all grains in the recipe
	   public String getGrainNames(){
 		  List<String> grainNames = new ArrayList<String>();
 		  int i =0;
 		  while(i<table.getRowCount()){
			   if(table.getValueAt(i, 1).equals("Grain")){

			   grainNames.add(table.getValueAt(i, 0).toString());
			   i++;

				   
			   }
			   else {
				   i++;
			   }
 		  }
 		 return grainNames.toString();
 		  
	   }
	
	//makes a string of all hops in the recipe
	   public String getHopNames(){
	 		  List<String> hopNames = new ArrayList<String>();
	 		  int i =0;
	 		  while(i<table.getRowCount()){
				   if(table.getValueAt(i, 1).equals("Hops")){

				   hopNames.add(table.getValueAt(i, 0).toString());
				   i++;

					   
				   }
				   else {
					   i++;
				   }
	 		  }
	 		 return hopNames.toString();
	 		  
		   }
	
	//destroys your work
	   public void clearTable(){
		   model.setRowCount(0);
	   }
}
