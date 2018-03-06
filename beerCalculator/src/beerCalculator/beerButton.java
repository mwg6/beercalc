package beerCalculator;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class beerButton extends JPanel {
	//create the two buttons needed on the bottom for addition and printing
	   private JButton addInfoButton = new JButton("Add Ingredient");
	   private JButton printButton = new JButton("Make Recipe");
	   
	//add these buttons
	   public beerButton() {
	      add(addInfoButton);
	      add(printButton);
	   }
	   
		//enable them to be touched by the world and feel it in their hearts
	   public void addInfoBtnAddActionListener(ActionListener listener) {
	      addInfoButton.addActionListener(listener);
	     
	   }

	   public void addPrintBtnAddActionListener(ActionListener listen) {
		      printButton.addActionListener(listen);
		     
		   }
	}

