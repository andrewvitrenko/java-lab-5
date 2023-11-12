public class Letter {
    private final char letter;

    public Letter(LabStringBuilder letter) {
        this.letter = letter.toString().charAt(0);
    }

    public String toString() {
        return Character.toString(this.letter);
    }
}
