package eg.edu.alexu.csd.datastructure.hangman.cs26;
/**
 * @author Abdelftah
 *
 */
public class HangmanTester {

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception {
		Hangman hangman = new Hangman();
		// Read from file here
		// String dictionary[] = readFile();
		String[] dictionary = new String[]{};
		hangman.setDictionary(dictionary);
		hangman.selectRandomSecretWord();
		hangman.setMaxWrongGuesses(2);
		System.out.println(hangman.guess('y')); // will return --Y--
	}
}
