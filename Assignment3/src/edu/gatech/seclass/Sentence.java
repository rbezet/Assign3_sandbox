package edu.gatech.seclass;

public class Sentence implements SentenceInterface {
	private String current_sentence;
	private String[] words;

	@Override
	// set the current sentence from input
	// also create the word array
	public void setSentence(String sentence) {
		this.current_sentence = sentence;
		this.words = sentence.split("\\s+");
	}

	@Override
	// return the current sentence
	public String getSentence() {
		return this.current_sentence;
	}

	@Override
	// return the number of words in the current sentence
	public int length() {
		return this.words.length;
	}

	@Override
	// return the word at position
	public String getWord(int position) throws IllegalArgumentException,
			PositionOutOfBoundsException {
		return this.words[position-1];
	}

	@Override
	// return each word from starPosition to endPosition
	public String[] getWords(int startPosition, int endPosition)
			throws IllegalArgumentException, PositionOutOfBoundsException {
		String[] innerWords = new String[this.words.length];
		int j = 0;
	    if(startPosition <= 0 || endPosition >  this.words.length) {
	         throw new PositionOutOfBoundsException();
	         } else {
		     for (int i = startPosition-1; i < endPosition; i++) {
		    	 innerWords[j++] = this.words[i];
		       }
	         }
        return innerWords;
	}

	@Override
	// return the the word positon of the (first) matching word
	public int indexOf(String word) {
		int match_index = -1;
		for (int i = 0; i < this.words.length; i++) {
			if (this.words[i].equals(word)) {
				match_index = i+1;
				break;
			}
		}
		return match_index;
	}

	@Override
	public void reverse() {
		String reverse_sentence = null;
		String[] reverse_words = new String[this.words.length];
		String spacer = " ";
		int j = 1;
		
		reverse_words[0] = this.words[this.words.length-1];
		reverse_sentence = this.words[this.words.length-1];
		for (int i = this.words.length-2; i >= 0; i--) {
			reverse_words[j++] = this.words[i];
			reverse_sentence = reverse_sentence + spacer + this.words[i];
		}
		this.current_sentence = reverse_sentence;
		this.words = reverse_words;
		 
	}

}
