package edu.csumb.csit.carrepairreservationsystem;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Contacts implements Serializable{
	
		
		private String name, number, month, time, day;
		private static int numberOfCreations = 0;
		private static int numberOfCancellations = 0;
		
		
		public Contacts(String name, String number, String month, String day, String time)
		{
			this.name = name;
			this.number = number;
			this.month = month; 
			this.day = day; 
			this.time = time;
			numberOfCreations++;
		}
		public Contacts()
		{
			this.name = "Test";
			this.number = "A burger";
			this.month = "December"; 
			this.day = "2"; 
			this.time = "8:00";
			
		}
		public String toString()
		{
			return (this.name + " " + this.number + " " + this.month + " " + this.day + " " + this.time);
		}
		public String monthString()
		{
			return this.month;
		}
		public String dayString()
		{
			return this.day;
		}
		public String timeString()
		{
			return this.time;
		}
		public boolean cancelMatch(String name, String number)
		{
			return this.name.equals(name) && this.number.equals(number);
		}
		public boolean conflict(String month, String day, String time)
		{
			return this.month.equals(month) && this.day.equals(day) && this.time.equals(time);
		}
		public void cancel()
		{
			numberOfCancellations++;
		}
		public int created()
		{
			return numberOfCreations;
		}
		public int cancellations()
		{
			return numberOfCancellations;
		}
}
