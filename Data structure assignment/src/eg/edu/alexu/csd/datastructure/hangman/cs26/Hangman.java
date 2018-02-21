package eg.edu.alexu.csd.datastructure.hangman.cs26;

import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

public class Hangman implements IHangman {

	private static String word, word_1, word_2;
	int length;
	String new_array[];
	char[] chars;
	char[] chars_1;
	int flag = 0;
	public int max_1;

	@Override
	public void setDictionary(String[] words) {
		// TODO Auto-generated method stub
		new_array = words;
	}

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		if (new_array == null) {
			return null;
		}
		Random rand = new Random();
		int h = rand.nextInt(new_array.length);
		if (new_array[h] != null) {
			word = new_array[h];
			length = word.length();
			chars_1 = new char[length];
			for (int i = 0; i < length; i++) {
				chars_1[i] = '-';
			}
			chars = word.toCharArray();
			word_2 = word_1 ;
			return new_array[h];
		}

		return null;
	}

	@Override
	public String guess(Character c) throws Exception {
		// TODO Auto-generated method stub
		if (word.charAt(0) == ' ') {
			throw new UnsupportedOperationException();
		}
		if (c == null) {
			return word_2;
		}
		if (max_1 == 1) {
			return null;
		}
		if (word == "") {
			throw new Exception();
		}

		if (c != null && max_1 != 1 && word_1 != word) {
			for (int i = 0; i < word.length(); i++) {
				if (c == word.charAt(i) || c + 32 == word.charAt(i) || c - 32 == word.charAt(i)) {
					chars_1[i] = word.charAt(i);
					flag = 1;
				}

			}

			word_1 = String.valueOf(chars_1);
			if (flag == 1) {
				flag = 0;
				return word_1;
			}
			max_1--;
			return word_1;
		}
		return null;

	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		max_1 = max;
	}
}
