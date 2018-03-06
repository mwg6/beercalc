package beerCalculator;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class beerCalc {
	   private static void createAndShowUI() {
		   	//create the frame
		      JFrame frame = new JFrame("Beer Calculator");
		      //to the frame we add a content pane of beergui, situating it at the center
		      frame.getContentPane().add(new beerGui(), BorderLayout.CENTER);
		      //self evident
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      //allow java to arrange elements
		      frame.pack();
		      //Specify it doesn't need to boot anywhere
		      frame.setLocationRelativeTo(null);
		      //self evident
		      frame.setVisible(true);
		   }
		 
		   public static void main(String[] args) {
		      java.awt.EventQueue.invokeLater(new Runnable() {
		         public void run() {
		            createAndShowUI();
		         }
		      });
		   }
		

}