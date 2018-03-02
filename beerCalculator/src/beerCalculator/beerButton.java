package beerCalculator;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class beerButton extends JPanel {
	   private JButton addInfoButton = new JButton("Add Ingredient");
	   private JButton printButton = new JButton("Make Recipe");
	    
	   public beerButton() {
	      add(addInfoButton);
	      add(printButton);
	   }
	   	    
	   public void addInfoBtnAddActionListener(ActionListener listener) {
	      addInfoButton.addActionListener(listener);
	     
	   }

	   public void addPrintBtnAddActionListener(ActionListener listen) {
		      printButton.addActionListener(listen);
		     
		   }
	}

