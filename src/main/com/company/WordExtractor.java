package main.com.company;

import com.google.common.io.CharStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordExtractor {

    public List<String> extractWordArray(String input){

        String s1 = unsuccessfulAttemptToCleanTheString(input);
        String s = extractWords(s1);
        return toWordArray(s);
    }


    private List<String> toWordArray(String tryNotKill) {
        return Arrays.asList(tryNotKill.split(" "));
    }

    private String extractWords(String input) {

        StringBuilder result = new StringBuilder();
        input.chars().mapToObj(i -> (char) i).filter(character -> Character.isLetter(character) || Character.isWhitespace(character)).forEachOrdered(result::append);
        return result.toString();
    }

    private String unsuccessfulAttemptToCleanTheString(String text) {
        return text.replaceAll("\n", "");
    }
}
