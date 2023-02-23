//*************************************************************************** 
//*  
//* CIS 340                   SP 2023                 Madeline Torney / Mariana Sanchez
//*  
//*                            PA0401
//*           			Diving competition 
//*  
//*
//*                  Date Created  2.22.23
//*  
//*              File Name:  MadelineTorney_MarianaSanchezPAO401
//*  
//*************************************************************************

package MadelineTorney_MarianaSanchezPA04;

import javax.swing.JOptionPane;

public class MadelineTorney_MarianaSanchezPA0401 {

	 public static class DivingCompetitor { // competitor constructor class
		String firstName = "";
		String lastName = "";
		int[] points = new int[7];
		static int difficultyLevel = 0;
		double avgPoints = 0;
		double finalScore = 0;
		
		public DivingCompetitor(String firstName, String lastName) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.points = generatePoints();
	        this.avgPoints = getAvg(this.points);
	        this.finalScore = getFinalScore();
	    }
		
	}
	
	public static int[] generatePoints() {
		int[] points = new int[7];
		
		for (int i = 0; i < points.length; i++) {
			points[i] = (int)(Math.random() * 10) + 1;
			System.out.print(points[i] + " ");
		}
		
		
		return points;
	}
	
	public static double getAvg(int[] points) {
		int sum = 0;
		double average = 0;
		
		// find minimum of points array
		int min = points[0];
			for (int i = 0; i < points.length; i++) {
				if (points[i] < min) {
					min = points[i];
				} else {
					continue;
				}
				
			} // end for loop
				
		// find maximum of points array
		int max = points[0];
			for (int i= 0; i < points.length; i++) {
				if (points[i] > max) {
					max = points[i];
				} else {
					continue;
				}
			} // end for loop
		
		for (int i = 0; i < points.length; i++) {
			sum += points[i];
		}
		
		average = (sum - (min + max)) / 5;
		
		return average;
	}
	
	public static double getFinalScore() {
		
	}
	
	public static String[] sortCompetitorsArr(String[] competitorsArr) {
		for (int i = 0; i < competitorsArr.length - 1; i++) {
		      // Find the minimum in the list[i..list.length-1]
		      String currentMin = competitorsArr[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < competitorsArr.length; j++) {
		        if (currentMin > competitorsArr[j]) {
		          currentMin = competitorsArr[j];
		          currentMinIndex = j;
		        }
		      }

		      // Swap list[i] with list[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		    	  competitorsArr[currentMinIndex] = competitorsArr[i];
		    	  competitorsArr[i] = currentMin;
		      }
		    }
		
		 return competitorsArr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numDivers = 0;
		boolean loop = false;
		int difficultyLevel = 0;
		
		// prompt user to enter number of divers
		while (loop == false) {
			try {
				numDivers = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of divers:"));
				if (numDivers <= 0) {
					throw new Exception();
				} else {
					loop = true;
				} // end else
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Invalid input. Enter a number between greater than 0.");
				loop = false;
			} // end try catch
		} // end while
		
		loop = false;
		DivingCompetitor[] competitorsArr = new DivingCompetitor[numDivers];
		
		// prompt user to enter difficulty level
		while (loop == false) {
			try {
				difficultyLevel = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter difficulty level:"));
				if (difficultyLevel <= 0 || numDivers >= 6) {
					throw new Exception();
				} else {
					loop = true;
				} // end else
			} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Invalid input. Enter a number between 1 and 5.");
						loop = false;
					} // end try catch
				} // end while
				
		loop = false;
		
		// read first name for divers & put in object array
		for (int i = 0; i < numDivers; i++) {
			competitorsArr[i] = new DivingCompetitor("", "");
			competitorsArr[i].difficultyLevel = difficultyLevel;
			while (loop == false) {
				try {
					competitorsArr[i].firstName = JOptionPane.showInputDialog(null, "Enter a diver's first name (" + (i+1) + "):");
					if (competitorsArr[i].firstName.isEmpty()) {
						throw new Exception();
					} else {
						loop = true;
					} // end else
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid input.");
					loop = false;
				} // end try catch
			} // end first name while
			
			loop = false;
				
				// read last name for divers
			while (loop == false) {
				try {
					competitorsArr[i].lastName = JOptionPane.showInputDialog(null, "Enter a diver's last name (" + (i+1) + "):");
					if (competitorsArr[i].lastName.isEmpty()) {
						throw new Exception();
					} else {
						loop = true;
					} // end else
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid input.");
					loop = false;
				} // end try catch
			} // end while
			
			loop = false;
			
		} // end for loop
		
		loop = false;
		
		
		
		
		
	}

}
