package beerCalculator;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class beerPanelTop extends JPanel{
	
	String[] nums = {"1","2","3","4","5","6","7","8","9","10"};
   private JComboBox galOptions = new JComboBox(nums);

    
   public beerPanelTop() {
      add(new JLabel("Gallons:"));
      add(galOptions);
      add(Box.createHorizontalStrut(10));
   }
    
   public int getQuantity() {
      return Integer.parseInt(galOptions.getSelectedItem().toString());
   }
   
}



