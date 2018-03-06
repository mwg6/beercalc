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
	   beerTable beerTable = new beerTable();
	   
	   beerButtonTop buttonPanelTop = new beerButtonTop();
	   beerPanelTop informationPanelTop = new beerPanelTop();
	   
	   beerButton buttonPanelBottom = new beerButton(); 
	   beerPanel informationPanel = new beerPanel();
	   
	   String fileName = "recipe";
	 
	   public beerGui() {
		  JPanel topPanel = new JPanel();
		  topPanel.add(informationPanelTop);
		  topPanel.add(Box.createHorizontalStrut(10));
		  topPanel.add(buttonPanelTop);
		   
	      JPanel bottomPanel = new JPanel();
	      bottomPanel.add(buttonPanelBottom);
	      bottomPanel.add(Box.createHorizontalStrut(10));
	      bottomPanel.add(informationPanel);
	       
	      setLayout(new BorderLayout());
	      add(topPanel, BorderLayout.NORTH);
	      add(beerTable, BorderLayout.CENTER);
	      add(bottomPanel, BorderLayout.SOUTH);
	       
	      buttonPanelBottom.addInfoBtnAddActionListener(new ActionListener() {
	          
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
	      buttonPanelBottom.addPrintBtnAddActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		 //the below statement gives total lbs of grain in the recipe
	    		  int gals = informationPanelTop.getQuantity();
	    		  double i = beerTable.sumColumn(2);
	    		  String grains = beerTable.getGrainNames();
	    		  String hops = beerTable.getHopNames();
	    		  buttonPanelBottom.print(gals, i, grains, hops);
	    		 
	    	  }
	      });
	      buttonPanelTop.addClearBtnAddActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		beerTable.clearTable();
	    	  }
	      });
	   }}
	   

