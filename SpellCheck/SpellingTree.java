public class SpellingTree {
    private SpellingNode root;

    public SpellingTree() {
        root = new SpellingNode(' ');
    }

    public SpellingNode getRoot() {
        return root;
    }

    /**
     *
     * @param word: String to be added to the tree
     */
    public void addWord(String word) {
        if (checkWord(word)) {
            return;
        }
        SpellingNode c = root;
        for (int i = 0; i < word.length(); i++) {
            if (c.getChildAt(word.charAt(i)) == null) { // checks if c has a child in the correct index
                c.addChild(word.charAt(i)); // adds child if it doesn't exist
            }
            c = c.getChildAt(word.charAt(i));
        }
        c.setCorrect(); // at the end of the word, sets correctWord to true
    }

    /**
     *
     * @param word: String that is looked for in the tree
     * @return true if word is in the tree
     */
    public boolean checkWord(String word) {
        SpellingNode c = root;
        for (int i = 0; i < word.length(); i++) {
            if (c.getChildAt(word.charAt(i)) == null) {
                return false;
            } else {
                c = c.getChildAt(word.charAt(i));
            }
        }
        return c.getCorrect();
    }

    /**
     * prints the words in the tree in alphabetical order
     * @param subWord: string keeping track of letters passed in the tree
     * @param c: current node
     */
    public void printWords(String subWord, SpellingNode c) {
        if (c.getCorrect()) {
            System.out.println(subWord);
        }
        for (int i = 0; i < c.getChildren().length; i++) {
            if (c.getChildren()[i] != null) {
                printWords((subWord + c.getChildren()[i].getValue()), c.getChildren()[i]);
            }
        }
    }
}
