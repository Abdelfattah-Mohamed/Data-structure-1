package eg.edu.alexu.csd.datastructure.hangman.cs26;

import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * @author Abdelftah
 *
 */

public class Hangman implements IHangman {
	/**
	 * to store dictionary words.
	 */
	private static String wor, word1;
	/**
	 * to store dictionary words.
	 */
	private static String[] newArray;
	/**
	 * store letter of the random word.
	 */
	@SuppressWarnings("unused")
	private static char[] chars;
	/**
	 * to print dashes.
	 */
	private static char[] chars1;
	/**
	 * to know wrong or write guess.
	 */
	private static int flag = 0;
	/**
	 * to store max number of guess.
	 */
	private static Integer max1 = null;

	@Override
	public void setDictionary(final String[] words) {
		// TODO Auto-generated method stub
		newArray = words;
	}

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		if (newArray == null) {
			return null;
		}
		Random rand = new Random();
		int h = rand.nextInt(newArray.length);
		if (newArray[h] != null) {
			wor = newArray[h];
			chars1 = new char[wor.length()];
			for (int i = 0; i < wor.length(); i++) {
				chars1[i] += '-';
			}
			chars = wor.toCharArray();
			return newArray[h];
		}

		return null;
	}

	@Override
	public String guess(final Character c) throws Exception {
		// TODO Auto-generated method stub
		if (wor.charAt(0) == ' ' || wor.length() == 0) {
			throw new RuntimeException();
		}
		if (c == null) {
			return "------";
		}
		if (wor == "") {
			throw new Exception();
		}
		if (max1 == null) {
			throw new UnsupportedOperationException();
		}

		if (c != null && max1 > 0 && word1 != wor) {
			for (int i = 0; i < wor.length(); i++) {
				if (Character.toUpperCase(c) == wor.charAt(i)) {
					chars1[i] = wor.charAt(i);
					flag = 1;
				} else if (Character.toLowerCase(c) == wor.charAt(i)) {
					chars1[i] = wor.charAt(i);
					flag = 1;
				} else if (c == wor.charAt(i)) {
					chars1[i] = wor.charAt(i);
					flag = 1;
				}

			}

			word1 = String.valueOf(chars1);
			if (flag == 1) {
				flag = 0;
				return word1;
			}
			max1--;
			if (max1 == 0) {
				return null;
			}
			return word1;
		}
		return null;

	}

	@Override
	public void setMaxWrongGuesses(final Integer max) {
		// TODO Auto-generated method stub
		if (max == null) {
			max1 = 1;
		} else {
			max1 = max;
		}
	}
}
