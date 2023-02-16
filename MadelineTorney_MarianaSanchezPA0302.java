//*************************************************************************** 
//*  
//* CIS 340                  SP 2023                 Madeline Torney / Mariana Sanchez
//*  
//*                            PA0302
//*             Electric Bill Revamp - using methods 
//*  
//*
//*                  Date Created  2.13.23
//*  
//*              File Name:  MadelineTorney.MarianaSanchezPAO3
//*  
//*************************************************************************

// issue is my arrays are size 100, need to fix b4 method call
package MadelineTorney_MarianaSanchezPA03;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea; 

public class MadelineTorney_MarianaSanchezPA0302 {

	public static double residentialElecBill(int month[], double energyUsed[], int ii) {
		double billAmt = 0.0;
		final double MONTHLY_RES_CHARGE = 6.75;

		if (month[ii] >= 6 && month[ii] < 10) {  // SUMMER
			if (energyUsed[ii] <= 500) { // First 500 KWH
				billAmt = MONTHLY_RES_CHARGE + (.04604 * energyUsed [ii]);
			}else { // Residential & above 500 KWH
				billAmt = MONTHLY_RES_CHARGE + (.04604 * 500) + (.09 * (energyUsed[ii] - 500));
			} // end inner

		}else if (month [ii]>= 10 || month[ii] < 6) { // WINTER
			billAmt  = MONTHLY_RES_CHARGE + (.04604 * energyUsed[ii]);
		}else {
			JOptionPane.showMessageDialog(null, "ERROR");
		}// end outer if-else statement
		
		return billAmt;
	}

	public static double commercialElecBill(int month[], double energyUsed[], int ii) {
		double billAmt = 0;
		final double MONTHLY_COM_CHARGE = 10.75;

		if (month[ii] >= 6 && month[ii] < 10) {  // SUMMER
			billAmt = MONTHLY_COM_CHARGE + (0.06450 * energyUsed[ii]);
		} else if (month [ii]>= 10 || month[ii] < 6) { // WINTER
			billAmt = MONTHLY_COM_CHARGE + (.03920 * energyUsed[ii]);
		} else {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		
		return billAmt;
	}

	public static double highestCostCalculator(double billAmt[]) {
		double max = billAmt[0];
		int ii; 
		
		for (ii= 0; ii < billAmt.length; ii++) {
			if (billAmt [ii] > max) {
				max = billAmt[ii];
			}
		}
		return max;
	}
	
	public static double lowestCostCalculator(double billAmt[]) {
		double min = highestCostCalculator(billAmt);
		int ii; 
		
		for (ii = 1; ii < billAmt.length; ii++) {
				if (billAmt[ii] != 0.0) {
					if (billAmt[ii] < min) {
						min = billAmt[ii];
				} else {
				continue;
			}
			}
		}
		return min;
	}
	
	public static String sortTotalCost(double billAmt[], String custInfoArr[]) {
		String displayStr = "";
		
		for (int i = 0; i < custInfoArr.length; i++) { // deleted the -1 of length TEST
			// Find the minimum in the list[i..list.length-1]
			double currentMin = billAmt[i];
			int currentMinIndex = i;
			String currentMinInfo = custInfoArr[i];
			

			for (int j = i + 1; j < billAmt.length; j++) {
				if (currentMin > billAmt[j]) {
					currentMin = billAmt[j];
					currentMinInfo = custInfoArr[j];
					currentMinIndex = j;
				}
			} // end inner for loop
			
			// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				billAmt[currentMinIndex] = billAmt[i];
				billAmt[i] = currentMin;

				// swap custInfoArr
				custInfoArr[currentMinIndex] = custInfoArr[i];
				custInfoArr[i] = currentMinInfo;
			}
			
			if (custInfoArr[i]!=null) { // getting rid of null values in array
				 displayStr += "\n" + custInfoArr[i] + "\t$" + String.format("%.2f", billAmt[i]); // DOES IT WORK RIGHT IDK }
			 }
	} // end outer for loop
		
		// display min and max values
		displayStr += "\n---------------------------\n"
				+ "Min: $" + String.format("%.2f", lowestCostCalculator(billAmt))
				+ "\tMax: $" + String.format("%.2f", highestCostCalculator(billAmt));
		
		
		return displayStr;
	}
	
	public static void display(String displayStr) {
		String output="Number\tType\tEnergy Used\tMonth\tBill Amount"; // display headers
		output += "\n" + displayStr;
		
		// actual output display here
		JOptionPane.showMessageDialog(null, new JTextArea(output),"Electric Bill",JOptionPane.INFORMATION_MESSAGE); 
	}
	public static void main(String[] args) {

	// declare / initialize variables
	boolean success = false;
	String [] customerName = new String[100]; // initialize all these arrays to fit 100 customers 
	int [] customerType = new int [100];
	double [] energyUsed = new double [100];
	int month [] = new int [100];
	double billAmt [] = new double [100];


	String [] customerTypeStr = new String [100];  // for displaying C or R
	String custInfoArr[] = new String [customerName.length]; // declaring this overhead array to put all info into one spot
	int cont = JOptionPane.YES_OPTION;
	int ii;

	for (ii = 0; cont == JOptionPane.YES_OPTION; ii++) { // each customer has 5 arrays
		// type of customer input
		while (success == false) {
			try {
				customerType[ii] = Integer.parseInt(JOptionPane.showInputDialog(null, "Customer Type:\n0 - Residential\n1 - Commercial"));  
				if (customerType[ii] != 0 && customerType[ii] != 1) {
					JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
					success = false;
				} else if (customerType[ii] == -1) {
					System.exit(0);
				} else {
					success = true;
					break;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
			} // end try catch
		} // end while

		success = false;

		// name of customer input
		while (success == false) {
			customerName[ii] = JOptionPane.showInputDialog(null, "Enter name (first and last):");
			if (customerName[ii] == null) {
				JOptionPane.showMessageDialog(null, "Please enter a name.");
				success = false;
			} else {
				success = true;
				break;
			}
		} // end while

		success = false; 

		// energy used in kWh input
		while (success == false) {
			try {
				energyUsed[ii] = Double.parseDouble(JOptionPane.showInputDialog(null, "Energy used in kWh:"));
				if (energyUsed[ii] < 1) {
					JOptionPane.showMessageDialog(null, "Energy cannot be less than 1. Try again.");
					success = false;
				} else {
					success = true;
					break;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
			} // end try catch 
		} // end while

		success = false;

		// month (1-12) input
		while (success == false) {
			try {
				month[ii] = Integer.parseInt(JOptionPane.showInputDialog(null, "Month (1 - 12):"));
				if (month[ii] < 1 || month[ii] > 12) {
					JOptionPane.showMessageDialog(null, "Invalid month. Try again.");
					success = false;
				} else {
					success = true;
					break;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
			} // end try catch
		} // end while
		


		// determine bill amounts using methods
		if (customerType[ii] == 0) {
			billAmt[ii] = residentialElecBill(month, energyUsed, ii);
		}
		else if (customerType[ii] == 1) {
			billAmt[ii] = commercialElecBill(month, energyUsed, ii); 
		}
		else {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		
		
		
		cont = JOptionPane.showConfirmDialog(null, "Would you like to enter another customer?"); // if no option is selected, for loop will break
		if (cont == -1) {
			System.exit(0);
		}

		success = false;
		
		// for display
		if (customerType[ii] == 0) {
			customerTypeStr[ii]= "Residential";
		} else {
			customerTypeStr[ii] = "Commercial";
		}
		
		custInfoArr[ii] = "\n" +customerName[ii] + "\t" + customerTypeStr[ii] + "\t" + energyUsed[ii] + " kWh\t" + month[ii];
	
		
	} // end of outer FOR loop (continue?, iterate arrays)


	display(sortTotalCost(billAmt,custInfoArr));
	
	
	
} // end main method

} // end public class


