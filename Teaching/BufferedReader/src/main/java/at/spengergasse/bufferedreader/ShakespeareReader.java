package at.spengergasse.bufferedreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShakespeareReader {

    public static String readShakespeare(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        StringBuilder sb = new StringBuilder();

        String line;
        line = reader.readLine();
        while (line != null) {
            if (line.isEmpty() || line.isBlank()) {
                sb.append('\n');
            } else {
                sb.append(line);
                sb.append(' ');
            }

            line = reader.readLine();
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    static void main() {
        try {
            System.out.println(readShakespeare("shakespeare.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
