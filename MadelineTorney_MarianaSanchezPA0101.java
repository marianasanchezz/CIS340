//*************************************************************************** 
//*  
//* CIS 340                  SP 2023                 Madeline Torney
//*  												 Mariana Sanchez
//*                            PAO101
//*       Practicing try / catch and validation techniques
//*  
//*
//*                       Date Created  1.25.23
//*  
//*           File Name:  MadelineTorney_MarianaSanchezPAO1
//*  
//*************************************************************************** 

package PA01;

import javax.swing.JOptionPane;

public class MadelineTorney_MarianaSanchezPA0101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int actualDay = 0, actualMonth = 0, expDay = 0, expMonth = 0;
		boolean validValueA = false, validValueE = false;
		double fine;
		int daysPast, monthsPast;
		

		while (validValueA == false) { // ACTUAL DATE ... Prompt and validations
			try {
				actualDay = Integer.parseInt(JOptionPane.showInputDialog("Enter actual return day:"));
				if ((actualDay <= 0)|| (actualDay >31)) {
					validValueA = false; // initial day validation
					JOptionPane.showMessageDialog(null, "Invalid day, please try again");
					continue;
				}
				else { // enter if day is 1<31... now verify day with month
					try {
						actualMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter actual return month:"));
						if (((actualMonth == 1) || (actualMonth == 3)|| (actualMonth == 5)||(actualMonth == 7)||
								(actualMonth == 8)||(actualMonth == 10)||(actualMonth == 12)) && (actualDay <= 31)) { // 31 DAYS
							validValueA = true;
						} else if ((((actualMonth == 2)) && (actualDay == 28) || (actualDay <= 29))) { // 29 DAYS
							validValueA = true;
						} else if (((actualMonth == 4) || (actualMonth == 6)|| (actualMonth == 9)|| (actualMonth == 11)) && (actualDay <= 30)) { //30 DAYS
							validValueA = true;
						} else {
							JOptionPane.showMessageDialog(null,"Date does not match month, try again");
							validValueA = false;
							continue;
						}
					} catch (NumberFormatException ec) { // catch for month after verifying somewhat valid date
						JOptionPane.showMessageDialog(null, "Invalid input, try again."); 
					} // end inner try catch
				} // end of else
			}catch (NumberFormatException ex) { // catch for day
				JOptionPane.showMessageDialog(null, "Invalid day input, try again."); // does he want us to identify what the issue is?
			} // end outer try catch
		} // end of while loop, validation and gathering of ACTUAL date

		

		while (validValueE == false) { //EXPECTED DATE ... Prompt and validations
			try {
				expDay = Integer.parseInt(JOptionPane.showInputDialog("Enter expected return day:"));
				if ((expDay <= 0)|| (expDay >31)) {
					validValueE = false; // initial day validation
					JOptionPane.showMessageDialog(null, "Invalid day, please try again");
					continue;
				}
				else { // enter if day is 1<31 ... now verify day with month
					try {
						expMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter expected return month:"));
						if (((expMonth == 1)|| (expMonth == 3)|| (expMonth == 5)||(expMonth == 7)||
								(expMonth == 8)||(expMonth == 10)||(expMonth == 12)) && (expMonth <= 31)) { // 31 DAYS
							validValueE = true;
						} else if ((((expMonth == 2)) && (expMonth == 28) || (expMonth <= 29))) { // 29 DAYS
							validValueE = true;
						} else if (((expMonth == 4) || (expMonth == 6)|| (expMonth == 9)|| (expMonth == 11)) && (expMonth <= 30)) { // 30 DAYS
							validValueE = true;
						} else {
							JOptionPane.showMessageDialog(null,"Date does not match month, try again");
							validValueE = false;
							continue;
						}
					} catch (NumberFormatException eb) { // catch for month data type after verifying day is between 1 < 31
						JOptionPane.showMessageDialog(null, "Invalid input, try again."); 
					} // end inner try catch for month value
				} // end of if else
			}catch (NumberFormatException ep) { // catch for expected day value
				JOptionPane.showMessageDialog(null, "Invalid day input, try again."); // does he want us to identify what the issue is?
			}
		} // end of while loop, validation and gathering of EXPECTED date
		
		String output = "";
		
		if ((actualMonth <= expMonth) && (actualDay <= expDay)){ // returned before deadline
			fine = 0.0;
			daysPast = 0;
			output = String.format("Number of days late: %d \nFine amount: $%.2f", daysPast, fine);
		} else if ((actualMonth == expMonth) && (actualDay >= expDay)) { // returned within same month, but after the expected day
			daysPast = actualDay - expDay;
			fine = 1.0 * (daysPast * (0.15));	
			output = String.format("Number of days late: %d \nFine amount:(%d * 15 cents)= $%.2f", daysPast, daysPast, fine);
		} else if (actualMonth >= expMonth) { // returned after the expected month
			monthsPast = actualMonth - expMonth;
			fine = 1.0 *(5.0 * monthsPast);
			output = String.format("Number of months late: %d \nFine amount: (%d * 500 cents)= $%.2f", monthsPast, monthsPast, fine);
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
	
		JOptionPane.showMessageDialog(null, output);
		
		
		
	} // end main

} //end class
