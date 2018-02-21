package eg.edu.alexu.csd.datastructure.hangman.cs26;

public class Hangman_tester  {
	
	public static void main(String[] args) throws Exception {
        Hangman hangman = new Hangman();
        // Read from file here
        // String dictionary[] = readFile();
        String dictionary[] = new String[] { "ABCYZabcyz" };
        hangman.setDictionary(dictionary);
        hangman.selectRandomSecretWord();
        hangman.setMaxWrongGuesses(2);
        java.util.Scanner s = new java.util.Scanner(System.in);
        for(int i = 0 ; i<100 ;i++) {
        	char c = s.next().charAt(0);
            System.out.println(hangman.guess( c )); // will return --Y--
        }
    }

}
