package beerCalculator;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class beerPanel extends JPanel{
			String[] typeOptions = {"Grain","Hops","Other"};
			String[] unitOptions = {"lb.","oz.", "kg.", "g."};
		   private JTextField name = new JTextField(10);
		   private JComboBox type = new JComboBox(typeOptions);
		   private JTextField quantity = new JTextField(10);
		   private JComboBox unit = new JComboBox(unitOptions);
		    
		   public beerPanel() {
		      add(new JLabel("Name"));
		      add(name);
		      add(Box.createHorizontalStrut(10));
		      add(new JLabel("Type"));
		      add(type);
		      add(new JLabel("Quantity"));
		      add(quantity);
		      add(Box.createHorizontalStrut(10));
		      add(new JLabel("Unit"));
		      add(unit);
		   }
		    
		   public String Name() {
		      return name.getText();
		   }
		    
		   public String Type() {
		      return type.getSelectedItem().toString();
		   }
		   public double Quantity() {
			      return Double.parseDouble(quantity.getText());
			   }
			    
			   public String Unit() {
				   return unit.getSelectedItem().toString();
			   }
		}

