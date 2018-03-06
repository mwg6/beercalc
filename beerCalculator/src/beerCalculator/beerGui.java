package beerCalculator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

//our class beergui adds functionality to JPanel (extends)
public class beerGui extends JPanel{
	
	//first create the fields for the program. We need objects from other classes for this mess to work so make them
	   beerTable beerTable = new beerTable();
	   beerButton buttonPanel = new beerButton(); 
	   beerPanel informationPanel = new beerPanel();
	 
	//now the constructor
	   public beerGui() {
		   //a beerGui will have a JPanel to hold the buttons from buttonPanel at the bottom. It will also 
		   //hold the information panel and make them spaced out
	      JPanel bottomPanel = new JPanel();
	      bottomPanel.add(buttonPanel);
	      bottomPanel.add(Box.createHorizontalStrut(10));
	      bottomPanel.add(informationPanel);
	       
		   
	      setLayout(new BorderLayout());
	      add(beerTable, BorderLayout.CENTER);
	      add(bottomPanel, BorderLayout.SOUTH);
	       
	      buttonPanel.addInfoBtnAddActionListener(new ActionListener() {
	          
	         public void actionPerformed(ActionEvent e) {
	        	try{
	     
	            String name = informationPanel.Name();
	            String type = informationPanel.Type();
	            double quantity = informationPanel.Quantity();
	            String unit = informationPanel.Unit();
	             
	            beerTable.addRow(name, type, quantity, unit);
	         
	        	}catch(NumberFormatException r){
	        		JOptionPane.showMessageDialog(null, "Please input a valid number for Quantity");
	        		}
	        	}
	         });
	      buttonPanel.addPrintBtnAddActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		 //the below statement gives total lbs of grain in the recipe
	    		  double i = beerTable.sumColumn(2);
	    		  System.out.println("Use " + i*.375 + " gallons of water heated to the range of 149-169 faranheit for the mash. Check occasionally that the water is still warm. Let grain soak for two hours. During this time heat " + i*0.5625 + ". Flow 6 quarts of water through the mash tun until the water becomes clear. ");
	    		  
	    	  }
	      });
	   }}
	   

