import java.util.ArrayList;

public class Text {
    static final String SEPARATOR = "([^.!?\\\\s][^.!?]*[.!?])";

    private final Sentence[] sentences;

    public Text(String example) throws LabException {
        LabStringBuilder text = new LabStringBuilder(example);

        LabStringBuilder[] tokens = text.split(Text.SEPARATOR);

        if (tokens.length < 2) {
            throw new LabException("Not enough text");
        }

        this.sentences = this.parse(tokens);
    }

    private Sentence[] parse(LabStringBuilder[] tokens) throws LabException {
        Sentence[] sentences = new Sentence[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            LabStringBuilder token = tokens[i];
            Sentence sentence = new Sentence(token);

            sentences[i] = sentence;
        }

        return sentences;
    }

    public String[] findUniqueWords() {
        ArrayList<String> result = new ArrayList<>();

        Sentence firstSentence = this.sentences[0];
        Word[] words = firstSentence.getWords();

        for (Word word : words) {
            boolean isUnique = true;

            for (int i = 1; i < this.sentences.length; i++) {
                Sentence sentence = this.sentences[i];

                if (sentence.includes(word.toString())) {
                    isUnique = false;
                }
            }

            if (isUnique) {
                result.add(word.toString());
            }
        }

        return result.toArray(new String[0]);
    }

    public String toString() {
        String result = "";

        for (Sentence sentence : this.sentences) {
            // add space after sentence
            result += sentence + " ";
        }

        return result.trim();
    }
}
