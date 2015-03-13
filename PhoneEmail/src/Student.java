/* Title: Homework 2, Question 2: Student Class
 * Abstract: Build a class to work with StudentDemo
 * Author: Terrence Johnson
 * ID: 1202
 */

import java.util.Arrays;
import java.util.Scanner;

public class Student {
	
		private String firstName, lastName, id, grade;
		private double [] examScores; 
		private double average;
		
		public Student(String firstName, String lastName)
		{
			// Method called when initialized. 
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = "000 - 000";
			examScores = new double[4];
			this.examScores[0] = 0;
			this.examScores[1] = 0;
			this.examScores[2] = 0;
			this.examScores[3] = 0;
		}
		public void readInfo()
		{
			Scanner keyboard = new Scanner(System.in);
			
			System.out.print("Enter ID (xxx-xxx): ");
			id = keyboard.nextLine();
			while(!id.matches("\\d\\d\\d\\-\\d\\d\\d"))
			{
					System.out.print("Incorrect format. Try again: ");
					id = keyboard.nextLine();
			}
			System.out.print("Enter four scores: ");
			for(int i = 0; i < 4; i++)
			{
				examScores[i] = keyboard.nextDouble();
			}
			scoreCalc();
			
		}
		private void scoreCalc()
		{
			double temp = 100.0; 
			double score = 0.0;
			
			for(int i = 0; i < 4; i++)
			{
				if(this.examScores[i] < temp)
				{
					temp = this.examScores[i];
				}
				score += this.examScores[i];
			}
			this.average = (score - temp)/3;
			if(this.average >= 70)
			{
				this.grade = "PASS";
			}
			else
				this.grade = "FAIL";
		}
		public void displayInfo()
		{
			System.out.println("===== Student Information =====");
			System.out.println("      " + this.firstName + " " + this.lastName);
			System.out.println("      ID: " + this.id);
			System.out.println("      Scores: " + examScores[0] + ", " + examScores[1] + ", " + examScores[2] + ", " + examScores[3]);
			System.out.println("      Average: " + average + " (" + grade + ")");
		}
		
		public void updateScores(double exam1, double exam2, double exam3, double exam4)
		{
			this.examScores[0] = exam1;
			this.examScores[1] = exam2;
			this.examScores[2] = exam3;
			this.examScores[3] = exam4;
			scoreCalc();
		}
		public void updateID(String id)
		{
			Scanner keyboard = new Scanner(System.in);
			
			if(id.matches("//d//d//d[-]//d//d//d"))
			{
				this.id = id;		
			}
		}
		public boolean equals(Student aStudent)
		{
			return (this.firstName == aStudent.firstName && this.lastName == aStudent.lastName && this.id == aStudent.id);
		}

}
