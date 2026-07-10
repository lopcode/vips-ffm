package vipsffm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavadocMarkdownConversion {

    private static final Pattern startRegex = Pattern.compile("[ \\t]*/\\*\\*[ \\t]*\n"); // /**
    private static final Pattern endRegex = Pattern.compile("[ \\t]*\\*/[ \\t]*\n"); // */
    private static final Pattern middleRegex = Pattern.compile("([\n^]+\\s+)\\*"); // *

    // attempts to crudely convert a code block from old javadoc style to new markdown style
    public static String convert(String original) {
        // [whitespace]/**[whitespace] | remove entirely
        // [whitespace]*/[whitespace]  | remove entirely
        // [whitespace]*[whitespace]   | replace with [whitespace]///[single space]

        var result = startRegex.matcher(original).replaceAll("");
        result = endRegex.matcher(result).replaceAll("");

        var matcher = middleRegex.matcher(result);
        var builder = new StringBuilder();
        while (matcher.find()) {
            var whitespace = matcher.group(1) == null ? "" : matcher.group(1);
            var replacement = Strings.removeSuffix(whitespace, " ") + "///";
            matcher.appendReplacement(builder, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(builder);
        return builder.toString();
    }
}
