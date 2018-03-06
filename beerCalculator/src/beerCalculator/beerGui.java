package beerCalculator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//our class beergui adds functionality to JPanel
public class beerGui extends JPanel{
	
	//first we need the table where all information will be displayed
	   beerTable beerTable = new beerTable();
	   
	//now we need user interaction buttons and input areas
	   beerButtonTop buttonPanelTop = new beerButtonTop();
	   beerPanelTop informationPanelTop = new beerPanelTop();
	   
	   beerButton buttonPanelBottom = new beerButton(); 
	   beerPanel informationPanel = new beerPanel();
	   
 	//aight constructor for the gui itself. Componenets needed are made above
	   public beerGui() {
		   //hey look, adding the top panel stuff to a panel on top!
		  JPanel topPanel = new JPanel();
		  topPanel.add(informationPanelTop);
		  topPanel.add(Box.createHorizontalStrut(10));
		  topPanel.add(buttonPanelTop);
	
		   //see above but replace top with bottom
	      JPanel bottomPanel = new JPanel();
	      bottomPanel.add(buttonPanelBottom);
	      bottomPanel.add(Box.createHorizontalStrut(10));
	      bottomPanel.add(informationPanel);
	       
		   //making the panel purtty. Adding the components as described
	      setLayout(new BorderLayout());
	      add(topPanel, BorderLayout.NORTH);
	      add(beerTable, BorderLayout.CENTER);
	      add(bottomPanel, BorderLayout.SOUTH);
	       
		   //make the buttons on bottom work. One day they'll be respectable members of society
	      buttonPanelBottom.addInfoBtnAddActionListener(new ActionListener() {
	          
	         public void actionPerformed(ActionEvent e) {
	        	try{
	     		//attempt get what the user inputs when they hit add
	            String name = informationPanel.Name();
	            String type = informationPanel.Type();
	            double quantity = informationPanel.Quantity();
	            String unit = informationPanel.Unit();
	             
				//attempt to pass that data to the table
	            beerTable.addRow(name, type, quantity, unit);
	         
	        	}
			 //if a number confuses the user we correct them gently
			 catch(NumberFormatException r){
	        		JOptionPane.showMessageDialog(null, "Please input a valid number for Quantity");
	        		}
	        	}
	         });
		   
		   //so now make the print button work
	      buttonPanelBottom.addPrintBtnAddActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		 //the below statement gives gallons to be made, total lbs of grain in the recipe, and a list of grain and hop names
	    		  int gals = informationPanelTop.getQuantity();
			 
	    		  double i = beerTable.sumColumn(2);
	    		  String grains = beerTable.getGrainNames();
	    		  String hops = beerTable.getHopNames();
			  
			  //and passes it to print with its own error handling
	    		  buttonPanelBottom.print(gals, i, grains, hops);
	    		 
	    	  }
	      });
		   //simple boy. destroys all user input
	      buttonPanelTop.addClearBtnAddActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		beerTable.clearTable();
	    	  }
	      });
	   }}
	   

