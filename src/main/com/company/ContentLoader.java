package main.com.company;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContentLoader {

    public String loadData() {
        try {
            String fileName = prepareFileName();
            File file = new File(fileName);
            return Files.asCharSource(file, Charsets.UTF_8).read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String prepareFileName() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Укажите файл для чтения");
            return reader.readLine();
        }
    }
}
