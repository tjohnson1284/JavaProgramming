package main;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;

public class WordList {
	
	private ArrayList<Word> wordList;
	
	public WordList()
	{
		wordList = new ArrayList<Word>();
	}
	public void addWord(String word)
	{
		
		for(int i = 0; i < wordList.size(); i++)
		{
			if(wordList.get(i).word().equals(word))
			{
				wordList.get(i).useIncrease();
				return;
			}
		}
		Word temp = new Word(word);
		wordList.add(temp);
	}
	public void printList()
	{
		
		for(int i = 0; i < wordList.size(); i++)
		{
			System.out.println("Word: " + wordList.get(i).word() +  " Number of times used: " + wordList.get(i).uses());
		}
	}
	public void readData(String fileName)
	{
		Scanner readFile = null;
		String word;
		
		try
		{
			readFile = new Scanner(new FileInputStream(fileName));
			File file = new File(fileName);
			if(file.length() == 0)
			{
				System.out.println("File empty");
				readFile.close();
				return;
			}
			
			while(readFile.hasNext())
			{
				word = readFile.next();
				addWord(word);
			}
					
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File" + fileName + "was not found, or could not be opened.");
			return;
		}
		readFile.close();
	}
	public void sortData()
	{
		Collections.sort(wordList);
		Collections.reverse(wordList);
	}
	
	public int wordSize()
	{
		return wordList.size();
	}
}
