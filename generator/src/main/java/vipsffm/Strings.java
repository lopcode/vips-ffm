package vipsffm;

/**
 * Small string helpers matching the semantics of the Kotlin stdlib functions the generator was
 * originally written with, to keep generated output identical
 */
public class Strings {

    public static String removePrefix(String value, String prefix) {
        if (value.startsWith(prefix)) {
            return value.substring(prefix.length());
        }
        return value;
    }

    public static String removeSuffix(String value, String suffix) {
        if (value.endsWith(suffix)) {
            return value.substring(0, value.length() - suffix.length());
        }
        return value;
    }

    public static String removeSurrounding(String value, String prefix, String suffix) {
        if (value.length() >= prefix.length() + suffix.length() && value.startsWith(prefix) && value.endsWith(suffix)) {
            return value.substring(prefix.length(), value.length() - suffix.length());
        }
        return value;
    }

    public static String substringBefore(String value, String delimiter) {
        var index = value.indexOf(delimiter);
        return index == -1 ? value : value.substring(0, index);
    }

    public static String substringAfter(String value, String delimiter) {
        var index = value.indexOf(delimiter);
        return index == -1 ? value : value.substring(index + delimiter.length());
    }

    public static String substringBefore(String value, char delimiter, String missingDelimiterValue) {
        var index = value.indexOf(delimiter);
        return index == -1 ? missingDelimiterValue : value.substring(0, index);
    }

    public static String substringAfter(String value, char delimiter, String missingDelimiterValue) {
        var index = value.indexOf(delimiter);
        return index == -1 ? missingDelimiterValue : value.substring(index + 1);
    }

    public static String substringBeforeLast(String value, char delimiter) {
        var index = value.lastIndexOf(delimiter);
        return index == -1 ? value : value.substring(0, index);
    }

    public static String substringAfterLast(String value, char delimiter) {
        var index = value.lastIndexOf(delimiter);
        return index == -1 ? value : value.substring(index + 1);
    }

    public static String trim(String value, char... chars) {
        var start = 0;
        var end = value.length();
        while (start < end && indexOfChar(chars, value.charAt(start)) >= 0) {
            start++;
        }
        while (end > start && indexOfChar(chars, value.charAt(end - 1)) >= 0) {
            end--;
        }
        return value.substring(start, end);
    }

    private static int indexOfChar(char[] chars, char target) {
        for (var i = 0; i < chars.length; i++) {
            if (chars[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
