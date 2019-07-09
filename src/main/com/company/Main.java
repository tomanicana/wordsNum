package main.com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        ContentLoader contentLoader = new ContentLoader();
        String characters = contentLoader.loadData();

        WordExtractor wordExtractor = new WordExtractor();
        List<String> allWords = wordExtractor.extractWordArray(characters);

        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> finalThing = wordCounter.countWords(allWords);


        Map.Entry<String, Integer> maxEntry = finalThing.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();

        System.out.println(allWords.toString());
        System.out.println("Всего слов: " + allWords.size());
        System.out.println("Уникальных слов " + finalThing.size());
        System.out.println("Наибольшее число повторений слова " + maxEntry.getKey() + ": " + maxEntry.getValue());

    }






}
