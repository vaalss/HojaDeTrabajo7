/**
 * Valeria Hernández Maldonado 25086
 * Clase encargada de leer los archivos dados
 * envía el main uns lista con las lineas 
 * y asociaciones contenidas en el archivo
 */

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

            list.add(new Association<String,String>(english, spanich)); //crea cada una de las asociaciones dadas en el diccionario
        }

        return list;
    }

    public static List<String> readText(String filePath) throws IOException {
        List<String> lines = readFile(filePath);
        List<String> cleanLines = new ArrayList<>();

        for (String line: lines) {
            line = line.toLowerCase();

            line = line.replace(".", "") //limpia las lineas para poder traducir de forma correcta
                .replace(",", "")
                .replace("!", "")
                .replace("¡", "")
                .replace("¿", "")
                .replace("?", "");

            cleanLines.add(line);    
        }
        
        return cleanLines; //devuelve una lista con las lineas completas (solo letras, sin caractéres especiales)
    }
}