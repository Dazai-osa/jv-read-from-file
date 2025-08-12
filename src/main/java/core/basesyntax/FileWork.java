package core.basesyntax;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder fileText = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                fileText.append(value);
                value = bufferedReader.readLine();
            }
            String[] arrTexts = bufferedReader.toString().toLowerCase().split("\\W+");
            StringBuilder splitText = new StringBuilder();
            for (String arrText : arrTexts) {
                if (arrText.startsWith("w")) {
                    splitText.append(arrText).append(" ");
                }
            }
            String[] result = splitText.toString().split(" ");
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i].replaceAll("^a-zA-Z", " ");
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t found the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }
    }
}
