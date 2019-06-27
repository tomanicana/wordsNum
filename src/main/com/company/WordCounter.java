package main.com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {

    public Map<String, Integer> countWords(List<String> allWords) {
        HashMap<String, Integer> finalThing = new HashMap<>();
        for (String i : allWords) {
            Integer j = finalThing.get(i);
            finalThing.put(i, (j == null) ? 1 : j + 1);
        }
        return finalThing;
    }
}
