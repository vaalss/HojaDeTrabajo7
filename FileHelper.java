import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
   
    public static List<String> readFile(String filePath) throws IOException {
        return Files.readAllLines(Path.of(filePath));
    }

    public static List<Association<String, String>> readDictionary(String filePath) throws IOException {
        List<String> lines = readFile(filePath);
        List<Association<String, String>> list = new ArrayList<>();

        for (String line : lines) {
            line = line.replace("(", "").replace(")", "");
            String[] parts = line.split(",");

            String english = parts[0].trim().toLowerCase();
            String spanich = parts[1].trim().toLowerCase();

            list.add(new Association<String,String>(english, spanich));
        }

        return list;
    }

    public static List<String> readText(String filePath) throws IOException {
        List<String> lines = readFile(filePath);
        List<String> cleanLines = new ArrayList<>();

        for (String line: lines) {
            line = line.toLowerCase();

            line = line.replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("¡", "")
                .replace("¿", "")
                .replace("?", "");

            cleanLines.add(line);    
        }
        
        return cleanLines;
    }
}