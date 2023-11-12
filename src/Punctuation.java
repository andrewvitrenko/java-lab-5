public class Punctuation {
    private final char punctuation;

    public Punctuation(LabStringBuilder sequence) {
        this.punctuation = sequence.toString().charAt(0);
    }

    public String toString() {
        return Character.toString(this.punctuation);
    }
}
