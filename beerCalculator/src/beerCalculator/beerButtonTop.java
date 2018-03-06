package beerCalculator;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class beerButtonTop extends JPanel{
	private JButton clearButton = new JButton("Clear");
	  
	public beerButtonTop() {
	      add(clearButton);
	      
	   }
	   	    
	   public void addClearBtnAddActionListener(ActionListener listener) {
	      clearButton.addActionListener(listener);
	     
	   }
}
