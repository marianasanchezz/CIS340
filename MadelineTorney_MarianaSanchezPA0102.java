//********************************************************************* 
//*
//*     CIS340               Spring 2023                Mariana Sanchez
//*  													Madeline Torney
//* 					Program Assignment PA01    
//*  
//*   					Bitcoin Transaction 
//* 
//* 				  Date Created: 01.27.2023   * 
//*                    Saved in:  PA01.java    
//********************************************************************* 

package PA01;

import javax.swing.JOptionPane;

public class MadelineTorney_MarianaSanchezPA0102 {

	public static void main(String[] args) {
		
		double currentValue = 0;
		double buy = 0;
		double sell = 0;
		double bitcoinValue = 0;
		double usdValue = 0;
		int transType = 0;
		
		
		// user input current number of coins + error message
		try {
		currentValue = Double.parseDouble(JOptionPane.showInputDialog(null, "Number of Bitcoins you own:"));
			if (currentValue < 1) {
				throw new Exception();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Invalid number of Bitcoins. Ending session.");
			System.exit(0);
		}
		
		// user input transaction type 0 buy 1 sell
		try {
		transType = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose a transaction type:\n0 - Buy\n1 - Sell"));
		
		if (transType != 0 && transType != 1) {
			throw new Exception();
		}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Invalid transaction type. Ending session.");
			System.exit(0);
		}
		
		// user input withdrawal / deposit amount + error messages
		if (transType == 0) {
			
			try {
				buy = Double.parseDouble(JOptionPane.showInputDialog(null, "USD you wish to spend on buying Bitcoins:"));
				if (buy <= 100) {
					throw new Exception();
				}
			} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid deposit. Must spend minimum of $100. Ending session.");
					System.exit(0);
				}
			
			// calculate BC value
			bitcoinValue = buy / 15000.00;
			usdValue = (bitcoinValue * 15000.00) + (currentValue * 15000.00);
			
			
			// display results
			JOptionPane.showMessageDialog(null, "Bitcoins for $" + String.format("%.2f", buy) + ": " + String.format("%.3f", bitcoinValue) 
					+ "\nTotal Bitcoin: " + String.format("%.3f", (currentValue + bitcoinValue))
					+ "\nAmount in USD: $" + String.format("%.2f", usdValue));
			
		} else {
			try {
				sell = Double.parseDouble(JOptionPane.showInputDialog(null, "USD you wish to receive on selling Bitcoins:"));
				if (sell > currentValue * 15000) {
					throw new Exception();
				}
			} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid withdrawal. You do not have enough Bitcoins. Ending session.");
					System.exit(0);
				}
			
			// calculate BC value
			bitcoinValue = sell / 15000;
			usdValue = Double.parseDouble(String.format("%.2f", ((currentValue * 15000.00) - (bitcoinValue * 15000.00)))) ;
			
			// display results
			JOptionPane.showMessageDialog(null, "Bitcoins for $" + String.format("%.2f", sell) + ": " + String.format("%.3f", bitcoinValue)
					+ "\nTotal Bitcoin left: " + String.format("%.3f", (currentValue - bitcoinValue))
					+ "\nAmount left in USD: $" + String.format("%.2f", usdValue));
		}
		
		

	}
	
}
