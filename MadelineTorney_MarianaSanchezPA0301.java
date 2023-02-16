//*************************************************************************** 
//*  
//* CIS 340                   SP 2023                 Madeline Torney / Mariana Sanchez
//*  
//*                            PA0301
//*           			Storage charge estimate 
//*  
//*
//*                  Date Created  2.15.23
//*  
//*              File Name:  MadelineTorney_MarianaSanchezPAO3
//*  
//*************************************************************************

package pa;

import javax.swing.JOptionPane;

public class MadelineTorney_MarianaSanchezPA0301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] storageArr = {"100GB", "1TB", "10TB"};
		String[] choicesArr = {"Yes", "No"};
		int months = 0;
		int student = 0;
		int storage = 0;
		boolean isStudent = false;
		boolean isMonths = false;
		
		// user select storage options
		
		storage = JOptionPane.showOptionDialog(null, // 100gb - 0; 1tb - 1; 10tb - 2
				"How much storage do you require?", 
				"Storage", 
				0, 
				3, 
				null, 
				storageArr,
				storageArr);
		
		// try catch number of months
		
		while (isMonths == false) {
			try {
				months = Integer.parseInt(JOptionPane.showInputDialog("Number of months:"));
				if (months < 1) {
					isMonths = false;
					throw new Exception();
				} else {
					isMonths = true;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Invalid input.");
			}
		}
		
		// user select student option
			
		student = JOptionPane.showOptionDialog(null, // yes - 0; no - 1
				"Are you a student?", 
				"Choose an option", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, 
				null, 
				choicesArr, 
				0);
		
		// turn integer student into boolean for parameter
		
		if (student == 0) { // set isStudent boolean
			isStudent = true;
			storageCharges(storage, months, isStudent);
		} else if (student == 1) {
			isStudent = false;
			storageCharges(storage, months);
		}
		
	} // end main class
	
	public static void storageCharges(int storage, int months) { // regular user method
		double charge = 0;
		double total = 0;
		
		// calculate bill and display output
		
		if (storage == 0) { // 100GB
			charge = 1.99;
			total = months * charge;
			JOptionPane.showMessageDialog(null, 
					"Your storage charge (100GB) for " + months + " months is $" + String.format("%.2f", total));
		} else if (storage == 1) { // 1TB
			charge = 9.99;
			total = months * charge;
			JOptionPane.showMessageDialog(null, 
					"Your storage charge (1TB) for " + months + " months is $" + String.format("%.2f", total));
		} else { // 10TB
			charge = 99.99;
			total = months * charge;
			JOptionPane.showMessageDialog(null, 
					"Your storage charge (10TB) for " + months + " months is $" + String.format("%.2f", total));
		}
		
		
	}
	
	public static void storageCharges(int storage, int months, boolean isStudent) { // student method
		double charge = 0;
		double total = 0;
		String choice = "";
		
		// calculate bill and display output
		
		if (storage == 0) { // 100GB
			charge = 1.99;
			total = (months * charge) * 0.9;
			JOptionPane.showMessageDialog(null, 
					"Your storage charge (100GB) for " + months + " months is $" + String.format("%.2f", total));
		} else if (storage == 1) { // 1TB
			charge = 9.99;
			total = (months * charge) * 0.9;
			JOptionPane.showMessageDialog(null, 
					"Your storage charge (1TB) for " + months + " months is $" + String.format("%.2f", total));
		} else { // 10TB
			charge = 99.99;
			total = (months * charge) * 0.9;
			JOptionPane.showMessageDialog(null, 
					"Your storage charge (10TB) for " + months + " months is $" + String.format("%.2f", total));
		}
	}

}
