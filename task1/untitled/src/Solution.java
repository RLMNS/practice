import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String text = "\n" +
                "Hong Kong CNN  — \n" +
                "\n" +
                "\n" +
                "         \n" +
                "\n" +
                "        Even in 40. 0 a land known for (gargantuan),record-breaking infrastructure, this project is turning heads.\n                   " +
                "At 15 miles long (24 kilometers), eight lanes wide and featuring artificial islands and an undersea tunnel, China’s $6.7 billion Shenzhen-Zhongshan Bridge is nothing if not ambitious.\n" +
                "\n" +
                "To much fanfare in the country’s state media, the bridge’s builders recently claimed a new world record by paving in a single day more than 243,200 square feet (22,600 square meters) of asphalt, the equivalent of more than 50 basketball courts.\n" +
                "\n" +
                "Yet strange as it may sound, this is not the world’s longest sea bridge. That honor belongs to its 34-mile long neighbor, the Hong Kong-Zhuhai-Macao Bridge – just 20 miles away.\n" +
                "\n" +
                "To some observers, the building of these giant bridges in such close proximity is testament both to China’s growing ambitions on the global stage and the problems it faces in realizing them. ";

        List<String> paragraphs = Arrays.stream(text.split("[\r\n]+")).filter(Predicate.not(String::isBlank))
                .map(String::trim).toList();

        paragraphs.forEach(paragraph -> {
            System.out.println("Paragraph: " + paragraph);
            System.out.println("Word count: " +
                    getMatches(paragraph, "(\\b[^\\s—#$%&'()*+,./:;<=>?@\\[\\]\\^_\\{\\|\\}]+\\b)"));
            System.out.println();
        });
    }

    public static List<String> getMatches(String s, String regex) {
        List<String> list = new ArrayList<>();
        if (s == null || regex == null || s.isEmpty()) return list;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
