package test.frequencyTest;


import static org.junit.Assert.*;
import main.Word;

import org.junit.Test;


public class WordTest {

	@Test
	public void test() {
		Word word1, word2, word3;
		
		word1 = new Word("Test");
		assertEquals(1, word1.uses());
		word1.useIncrease();
		word1.useIncrease();
		
		assertEquals(3, word1.uses());
		assertEquals("Test", word1.word());
		assertNotSame("false", word1.word());
		
		word2 = new Word("Test");
		
		assertEquals(false, word1.equals(word2));
		
		word2.useIncrease();
		word2.useIncrease();
		
		assertEquals(true, word1.equals(word2));
		
		word3 = new Word("fail");
		
		assertEquals(false, word1.equals(word3));
		
		
	}

}
