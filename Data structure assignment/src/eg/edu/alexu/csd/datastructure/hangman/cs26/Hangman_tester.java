package eg.edu.alexu.csd.datastructure.hangman.cs26;

public class Hangman_tester {

	public static void main(String[] args) throws Exception {
		Hangman hangman = new Hangman();
		// Read from file here
		// String dictionary[] = readFile();
		String dictionary[] = new String[] { "egypt" };
		hangman.setDictionary(dictionary);
		hangman.selectRandomSecretWord();
		hangman.setMaxWrongGuesses(0);
		System.out.println(hangman.guess('y')); // will return --Y--
		System.out.println(hangman.guess('p')); // will return --Y--
		System.out.println(hangman.guess('z')); // will return --Y--
		System.out.println(hangman.guess('z')); // will return --Y--
		System.out.println(hangman.guess('z')); // will return --Y--
	}
}