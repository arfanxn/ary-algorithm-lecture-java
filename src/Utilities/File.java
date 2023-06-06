package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {

    // readAsStrBuffer reads a file and returns a buffered string from the given file path location
    public static StringBuffer readAsStrBuffer (String path) {
        StringBuffer sb = new StringBuffer();
        java.io.File file = new java.io.File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb;
    }
}
