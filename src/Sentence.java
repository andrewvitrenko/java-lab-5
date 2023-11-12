import java.util.ArrayList;

public class Sentence {
    static final String SEPARATOR = "\\b\\w+\\b|[\\p{Punct}]";
    private final Object[] tokens;

    public Sentence(LabStringBuilder sentence) throws LabException {
        LabStringBuilder[] items = sentence.split(Sentence.SEPARATOR);

        this.tokens = this.parse(items);

        Word[] words = this.getWords();

        // check that sentence has at least one word
        if (words.length == 0) {
            throw new LabException("Sentence should contain at least 1 word");
        }
    }

    /**
     * Parses sentence into array of Words and Punctuations
    */
    private Object[] parse(LabStringBuilder[] items) {
        Object[] tokens = new Object[items.length];

        for (int i = 0; i < items.length; i++) {
            LabStringBuilder item = items[i];
            boolean isWord = Word.isWord(item.toString());

            // creates a Word instance if token is word, and Punctuation if it is not
            if (isWord) {
                tokens[i] = new Word(item);
            } else {
                tokens[i] = new Punctuation(item);
            }
        }

        return tokens;
    }

    public Word[] getWords() {
        ArrayList<Word> words = new ArrayList<>();

        for (Object token : this.tokens) {
            if (Word.isWord(token.toString())) {
                words.add((Word) token);
            }
        }

        return words.toArray(new Word[0]);
    }

    public boolean includes(String elem) {
        for (Object token : this.tokens) {
            if (elem.equals(token.toString())) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String result = "";

        for (Object token : this.tokens) {
            if (Word.isWord(token.toString())) {
                // add space before word
                result += " ";
            }

            result += token;
        }

        return result.trim();
    }
}
