package main;
//import java.util.Comparator;

public class Word implements Comparable<Word>{

	private String word;
	
	private int uses;
	
	public Word(String word)
	{
		this.word = word;
		this.uses = 1;
	}
	
	public String word()
	{
		return this.word;
	}
	
	public int uses()
	{
		return uses;
	}
	public void useIncrease()
	{
		this.uses++;
	}
	public boolean equals(Word word1)
	{
		return this.word == word1.word && this.uses == word1.uses;
	}

	@Override
	public int compareTo(Word test) {
		// TODO Auto-generated method stub
		Integer use1 = this.uses;
		Integer use2 = test.uses;
		return use1.compareTo(use2);
	}

}
