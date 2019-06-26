package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        // write your code here

        ArrayList<Character> arrayText = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("/Users/tamaranikolaeva/IdeaProjects/wordsNum/src/com/company/example.txt")));

            int c;
            while ((c = reader.read()) != -1) {
                arrayText.add((char) c);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //System.out.println(arrayText.toString());
        //есть массив с текстом и знаками препинания.
        //System.out.println(allWordsSize);

        String tryNotKill = new String();

        for (Character yy : arrayText) {
            if (yy.equals("\n")) {
                arrayText.remove(yy);
            }
        }

        for (char xx : arrayText) {
            boolean isBukva = Character.isLetter(xx);
            boolean isProbel = Character.isWhitespace(xx);

            if (isBukva) {
                tryNotKill = tryNotKill + xx;
            }

            if (isProbel) {
                tryNotKill = tryNotKill + xx;
            }
        }

        ArrayList<String> allWords = new ArrayList<>();

        for (String something : tryNotKill.split(" ")) {
            allWords.add(something);
        }
        //System.out.println(allWords.size());
        //System.out.println(tryNotKill);
        //System.out.println(allWords.toString());
        //System.out.println(allWords.get(14));
        //получили массив со словами, проверяемп на уникальность

        TreeMap<String, Integer> finalThing = new TreeMap<>();
        Integer howMuch;

        for (String word : allWords) {
            howMuch = finalThing.get(word);

            if (howMuch == null) {
                finalThing.put(word, 1);
            } else {
                finalThing.put(word, howMuch + 1);
            }
        }

        //запихали в карту все лова со значениями

        int countNum = 1;
        String slovo = null;


        for (Map.Entry e : finalThing.entrySet()) {
            int shlapa = (int) e.getValue();
            String huapa = (String) e.getKey();

            if (shlapa > countNum) {
                countNum = countNum + 1;
                slovo = huapa;

            }
        }
        System.out.println(allWords.toString());
        System.out.println("Всего слов: " + allWords.size());
        System.out.println("Наибольшее число повторений слова " + slovo +  ": " + countNum);

    }
}
