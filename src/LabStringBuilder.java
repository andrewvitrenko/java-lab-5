import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabStringBuilder {
    private final StringBuilder stringBuilder;

    public LabStringBuilder(String source) {
        this.stringBuilder = new StringBuilder(source);
    }

    public LabStringBuilder[] split(String separator) {
        ArrayList<LabStringBuilder> result = new ArrayList<>();

        Pattern pattern = Pattern.compile(separator);
        Matcher matcher = pattern.matcher(stringBuilder);

        while (matcher.find()) {
            String token = stringBuilder.substring(matcher.start(), matcher.end());
            result.add(new LabStringBuilder(token));
        }

        return result.toArray(new LabStringBuilder[0]);
    }

    public String toString() {
        return this.stringBuilder.toString();
    }
}
