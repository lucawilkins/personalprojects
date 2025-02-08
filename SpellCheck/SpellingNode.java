public class SpellingNode {
    private char value;
    private SpellingNode[] children;
    private boolean correctWord;

    public SpellingNode(char value) {
        this.value = value;
        children = new SpellingNode[26];
        correctWord = false;
    }

    public char getValue() {
        return value;
    }

    public SpellingNode[] getChildren() {
        return children;
    }

    public void setCorrect() {
        correctWord = true;
    }

    public boolean getCorrect() {
        return correctWord;
    }

    /**
     * adds a node into the children array
     * @param letter value of the new node
     * @return true if the letter is added
     */
    public boolean addChild(char letter) {
        int letterVal = (letter - 97);
        if (children[letterVal] == null) {
            SpellingNode child = new SpellingNode(letter);
            children[letterVal] = child;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param letter char
     * @return the Spelling node in the children array with the value letter
     */
    public SpellingNode getChildAt(char letter) {
        return children[letter - 97];
    }

}
