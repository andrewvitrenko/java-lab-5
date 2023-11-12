public class Word {
    static final String SEPARATOR = "\\w";

    private final Letter[] letters;

    public Word(LabStringBuilder word) {
        LabStringBuilder[] tokens = word.split(Word.SEPARATOR);

        this.letters = this.parse(tokens);
    }

    private Letter[] parse(LabStringBuilder[] tokens) {
        Letter[] letters = new Letter[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            Letter letter = new Letter(tokens[i]);
            letters[i] = letter;
        }

        return letters;
    }

    public String toString() {
        LabStringBuilder result = new LabStringBuilder("");

        for (Letter letter : this.letters) {
            result.append(letter);
        }

        return result.toString();
    }

    public static boolean isWord(String token) {
        return token.matches("\\w+");
    }
}
