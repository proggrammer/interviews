package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Compress-decompress String - example aaabb -> a3b2
 */
public class CompressDecompressString {
    public static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(input);

        matcher.results().forEach(matchResult -> {
            String group = matchResult.group();
            compressed.append(group.charAt(0));
            if (group.length() > 1) {
                compressed.append(group.length());
            }
        });

        return compressed.toString();
    }

    public static String decompressString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder decompressed = new StringBuilder();
        Pattern pattern = Pattern.compile("(\\D)(\\d*)");
        Matcher matcher = pattern.matcher(input);

        matcher.results().forEach(matchResult -> {
            char currentChar = matchResult.group(1).charAt(0);
            int count = matcher.group(2).isEmpty() ? 1 : Integer.parseInt(matcher.group(2));
            decompressed.append(String.valueOf(currentChar).repeat(Math.max(0, count)));
        });

        return decompressed.toString();
    }
}
