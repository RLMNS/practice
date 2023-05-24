import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static Pattern pattern = Pattern.compile("(\\b[^\\s]+\\b)");
    public static void main(String[] args) {
        String text = args[0];

        List<String> paragraphs = Arrays.stream(text.split("[\r\n]+")).filter(Predicate.not(String::isBlank))
                .map(String::trim).toList();

        paragraphs.forEach(paragraph -> {
            System.out.println("Paragraph: " + paragraph);
            System.out.println("Word count: " +
                    getMatches(paragraph).size());
            System.out.println();
        });
    }

    private static List<String> getMatches(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.isEmpty()) return list;
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
