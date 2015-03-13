package main;


public class WordFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordList test;
		
		test = new WordList();
		
		test.readData("c:\\test3.txt");
		test.sortData();
		test.printList();
	}

}
