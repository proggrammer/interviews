package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompressDecompressString {
    public static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .forEach((character, count) -> compressed.append(character).append(count));

        return compressed.toString();
    }

    public static String decompressString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder decompressed = new StringBuilder();
        Pattern pattern = Pattern.compile("(\\D)(\\d+)");
        Matcher matcher = pattern.matcher(input);

        matcher.results().forEach(matchResult -> {
            char currentChar = matchResult.group(1).charAt(0);
            int count = Integer.parseInt(matchResult.group(2));
            decompressed.append(String.valueOf(currentChar).repeat(Math.max(0, count)));
        });

        return decompressed.toString();
    }
}
