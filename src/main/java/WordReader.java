import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordReader {
    List<String> words;

    public WordReader() {
        String fileName = "words.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        File file;
        BufferedReader reader;

        words = new ArrayList<String>();

        String [] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        try {
            for(String s : Arrays.asList(letters)) {
                file = new File(classLoader.getResource(s+".txt").getFile());

                reader = new BufferedReader(new FileReader(file));

                String line = reader.readLine();

                while (line != null) {
                    words.add(line.toLowerCase().trim());
                    line = reader.readLine();
                }

                reader.close();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> getWords() {
        return words;
    }
}
