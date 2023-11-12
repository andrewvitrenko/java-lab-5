import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabStringBuilder {
    private final StringBuilder content;

    public LabStringBuilder(String source) {
        this.content = new StringBuilder(source);
    }

    public LabStringBuilder[] split(String separator) {
        ArrayList<LabStringBuilder> result = new ArrayList<>();

        Pattern pattern = Pattern.compile(separator);
        Matcher matcher = pattern.matcher(this.content.toString());

        while (matcher.find()) {
            String token = this.content.substring(matcher.start(), matcher.end());
            result.add(new LabStringBuilder(token));
        }

        return result.toArray(new LabStringBuilder[0]);
    }

    public void append(Object obj) {
        this.content.append(obj);
    }

    public void replaceAll(String regex, String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.content.toString());
        int offset = 0;

        while (matcher.find()) {
            int start = matcher.start() + offset;
            int end = matcher.end() + offset;
            this.content.replace(start, end, replacement);

            // Adjust offset for changes in length
            offset += replacement.length() - (end - start);
        }
    }

    public String toString() {
        return this.content.toString();
    }
}
