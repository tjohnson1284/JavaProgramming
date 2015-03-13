/* Title: Homework 2, Question 2: Student Class
 * Abstract: Build a class to work with StudentDemo
 * Author: Terrence Johnson
 * ID: 1202
 */

import java.util.Scanner;

public class PhoneEmail {

	public static void main(String[] args) {
		//
		String phoneNumber;
		String email;
		String choice = "Y";
		
		
		Scanner keyboard = new Scanner(System.in);
		
		while(choice.equals("Y") || choice.equals("y"))
		{	
			System.out.println("Enter a phone number: ");
			phoneNumber = keyboard.next();
			if(!phoneNumber.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d"))  // uses a regular expression to verify that the string only contains numbers and is the proper length
			{
				System.out.println("Phone number is invalid.");
			}
			phoneNumber = ("(" + phoneNumber.substring(0, 3) + ") "+ phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 10));
			System.out.println("Phone number is: " + phoneNumber);
			System.out.println("Enter a valid email: ");
			email = keyboard.next();
			String emailcomparison = email.substring(email.length() - 4, email.length());  // adds the last part of an email address comparison
			
			if(!emailcomparison.equals(".gov") && !emailcomparison.equals(".edu") && !emailcomparison.equals(".com") &&
					email.matches("(?=.*[@])"))
			{
				System.out.println("Email is invalid.");
			}
			
			System.out.println("Try again? (Y/N)");
			choice = keyboard.next();
		}
		System.out.println("Bye.");
	}
}
