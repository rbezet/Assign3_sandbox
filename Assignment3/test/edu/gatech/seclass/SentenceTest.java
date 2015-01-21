package edu.gatech.seclass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.PositionOutOfBoundsException;
import edu.gatech.seclass.Sentence;

public class SentenceTest {

    private Sentence sentence;

    @Before
    public void setUp() throws Exception {
        sentence = new Sentence();
    }

    @After
    public void tearDown() throws Exception {
        sentence = null;
    }

    // test getWord returns the correct word
    @Test
    public void testGetWord1() throws IllegalArgumentException,
            PositionOutOfBoundsException {
        sentence.setSentence("This is a short sentence");
        String word = sentence.getWord(2);
        assertEquals("is", word);
    }

   // check that the word contains no "white space" (i.e. is a single word)
    @Test
    public void testGetWord2() throws IllegalArgumentException,
            PositionOutOfBoundsException {
        sentence.setSentence("This sentence is a longer sentence than the other");
        String word = sentence.getWord(5);    	
        assertFalse(word.contains(" "));
    }

    // test that getWords returns the correct words
    @Test
    public void testGetWords1() throws IllegalArgumentException,
            PositionOutOfBoundsException {
        sentence.setSentence("Check the correct words were returned");
        String[] testWords = sentence.getWords(2, 5);
        assertEquals(testWords[0], "the");
        assertEquals(testWords[1], "correct");
        assertEquals(testWords[2], "words");
        assertEquals(testWords[3], "were");
    }

    // test getWords throws the expected exception
    @Test(expected = PositionOutOfBoundsException.class)
    public void testGetWords2() throws IllegalArgumentException,
            PositionOutOfBoundsException {
        sentence.setSentence("Another short sentence");
        sentence.getWords(3, 4);
    }

    // test that getWords returns the correct length
    @Test
    public void testGetLength1() {
        sentence.setSentence("This sentence is a longer sentence than the other");
        assertTrue(sentence.length() == 9);
    }

    // Test that the length is not 0
    @Test
    public void testGetLength2() {
        sentence.setSentence("This sentence is a shorter sentence");
        assertFalse(sentence.length() == 0);
    }

    @Test
    public void testIndexOf1() {
        sentence.setSentence("This is a short sentence");
        assertEquals(5, sentence.indexOf("sentence"));
    }

    // test index is -1 for a an invalid word search
    @Test
    public void testIndexOf2() {
        sentence.setSentence("This is a short sentence");
        assertEquals(-1, sentence.indexOf("long"));
    }

    @Test
    public void testReverse1() {
        sentence.setSentence("This is a short sentence");
        sentence.reverse();
        assertEquals("sentence short a is This", sentence.getSentence());
    }

    // verify the reversed sentence length matches the length of the original sentence
    @Test
    public void testReverse2() {
        sentence.setSentence("This sentence has some characters in it");    	
    	int lengthOne = sentence.length();
    	sentence.reverse();
    	assertEquals(lengthOne, sentence.length());
    }
}
