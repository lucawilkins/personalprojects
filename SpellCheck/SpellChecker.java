import java.io.CharArrayReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {
    private static SpellingTree mytree;

    public static void main(String[] args) throws FileNotFoundException {
        mytree = new SpellingTree();

        readWords("Dictionary.txt");
        mytree.printWords("", mytree.getRoot());
        System.out.println("\n\n");
        System.out.println("Misspelled words: ");
        System.out.println("Number of misspelled words: " + checkWords("TestFile.txt"));

    }

    /**
     * checks if the words in filename are in mytree and prints misspelled words
     * @param filename: file containing words to be checked
     * @return number of words misspelled in filename
     * @throws FileNotFoundException
     */
    public static int checkWords(String filename) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(filename));
        int numMisspelled = 0;
        while (reader.hasNext()) {
            String word = removePunct(reader.next());

            if (!mytree.checkWord(word)) {
                numMisspelled++;
                System.out.println(word);
            }
        }
        return numMisspelled;
    }

    /**
     *
     * @param filename: file of words to be added to mytree
     * @throws FileNotFoundException
     */
    public static void readWords(String filename) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(filename));
        while (reader.hasNext()) {
            String word = reader.next();
            mytree.addWord(removePunct(word));
        }
    }

    /**
     *
     * @param word: String possibly with non-letter values i.e. punctuation, numbers, etc
     * @return the input word stripped of any characters that are not letters
     */
    public static String removePunct(String word) {
        String returnString = "";
        char c;

        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (Character.isLetter(c)) {
                returnString += Character.toLowerCase(c);
            }
        }
        return returnString;
    }
}
