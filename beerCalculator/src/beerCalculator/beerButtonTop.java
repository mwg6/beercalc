package beerCalculator;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class beerButtonTop extends JPanel{
	
	//top button to banish mistakes
	private JButton clearButton = new JButton("Clear");
	  
	//put it on this model
	public beerButtonTop() {
	      add(clearButton);
	      
	   }
	 //let it sing	    
	   public void addClearBtnAddActionListener(ActionListener listener) {
	      clearButton.addActionListener(listener);
	     
	   }
}
