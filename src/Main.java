import java.util.Arrays;

public class Main {
    static final String example = "Lorem ipsum dolor sit amet, consectetur adipiscing elit? " +
            "Duis ullamcorper facilisis enim, vel bibendum leo scelerisque ut! " +
            "Nunc ac massa ac nulla sagittis pharetra id eget ipsum. " +
            "In hac habitasse platea dictumst. " +
            "Sed eget bibendum ligula. " +
            "Aliquam ultricies sed odio ut porta. " +
            "Aenean diam justo, hendrerit auctor nulla id, molestie mattis metus. " +
            "Quisque eu nisl vitae magna laoreet elementum. " +
            "Nulla cursus, arcu nec dapibus gravida, turpis sem feugiat est, non laoreet sapien odio quis mauris. " +
            "In vel neque at justo auctor vulputate. " +
            "Praesent malesuada urna sed erat eleifend, eget faucibus enim egestas. " +
            "Phasellus interdum a tellus a posuere. " +
            "Maecenas quis lectus sit amet lectus elementum blandit.";

    public static void main(String[] args) {

        try {
            Text text = new Text(Main.example);

            String[] result = text.findUniqueWords();

            if (result.length > 0) {
                System.out.printf("result - %s\n", Arrays.toString(result));
            } else {
                System.out.println("0 words found");
            }
        } catch (LabException e) {
            System.out.println("Lab exception - " + e.getMessage());
        }
    }
}