package eg.edu.alexu.csd.datastructure.hangman.cs26;

public class Hangman_tester {

	public static void main(String[] args) throws Exception {
		Hangman hangman = new Hangman();
		// Read from file here
		// String dictionary[] = readFile();
		String dictionary[] = new String[] { "aAbBzZ" };
		hangman.setDictionary(dictionary);
		hangman.selectRandomSecretWord();
		hangman.setMaxWrongGuesses(null);
		System.out.println(hangman.guess('y')); // will return --Y--
	}
}