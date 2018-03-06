package beerCalculator;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JPanel;

public class beerButton extends JPanel {
	
	//add the necessary buttons for adding ingredients and generating the recipe
	   private JButton addInfoButton = new JButton("Add Ingredient");
	   private JButton printButton = new JButton("Make Recipe");
	   
	  //add the lovingly crafted buttons  
	   public beerButton() {
	      add(addInfoButton);
	      add(printButton);
	   }
	   
	//allow the buttons to feel the touch of the world and be moved by it
	   public void addInfoBtnAddActionListener(ActionListener listener) {
	      addInfoButton.addActionListener(listener);
	     
	   }

	   public void addPrintBtnAddActionListener(ActionListener listen) {
		      printButton.addActionListener(listen);
		     
		   }
	
	//give voice to print's actions
	   public void print(int batchSize, double lbs, String grains, String hops){
		   String fileName = "Recipe.txt";
		   try {
			PrintWriter outputStream = new PrintWriter(fileName);
			outputStream.println("Heat " + lbs*.375 + " gallons of water to strike (149-169 Faranheit");
			outputStream.println("Add the " + grains + " to the pot and steep for two hours, checking occasionally to ensure water temp is still in strike range");
			outputStream.println("If water is too cold add a quart of boiling water to the mash and stir.");
			outputStream.println("While the grains are steeping heat a further " + lbs*.5625 + " gallons of water to strike.");
			outputStream.println("At the end of two hours of steeping flush the mash water slowly (<1 quart a minute) from the mash tun");
			outputStream.println("You will need to do this 6-7 times, until the liquid becomes clear and no longer foggy. Gently pour the flushed water back on top of the grain bed in a gentle, circular motion.");
			outputStream.println("When the water is clear, begin flushing the mash tun at the same slow rate of <1quart a minute into a large vessel for boiling");
			outputStream.println("As a quart is drained into the pot, replace it with the water heated to strike, again using a gentle circular motion to pour the water and not disturb the grain bed.");
			outputStream.println("Boil the liquid down to " + batchSize + " gallons");
			outputStream.println("Remember to add your " + hops + " to the beer! Add sixty minutes before boiled down to " + batchSize + "for a more bitter, IPA-like flavor profile and 10-15 minutes before for more aromatics");
			outputStream.println("Cool the liquid to 80 degress faranheit once it has reached " + batchSize + " and put in your primary fermentation vessel");
			outputStream.println("Pitch the yeast, give a stir with a clean utensil, and let ferment for two wweks before bottling");
			outputStream.close(); //prevents data from getting lost in the RAM. Forces data from RAM to File
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	}

