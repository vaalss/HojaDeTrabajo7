import java.nio.file.Files; 
import java.nio.file.Path; 
import java.util.List; 
import java.util.Scanner; 

public class Main { 
    public static void main(String[] args) throws Exception { 
        BinaryTree<Association<String, String>> tree = new BinaryTree<>(); 
        List<Association<String, String>> dictionary = FileHelper.readDictionary("diccionario.txt"); 
        
        for (Association<String, String> association : dictionary) { 
            tree.insert(association); 
        } 
        
        System.out.println("Diccionario ordenado: "); 
        tree.inOrder(); 
        
        List<String> words = FileHelper.readText("texto.txt");
        System.out.println("\nTraducción:");
        translate(tree, words); 
    } 
    
    public static void translate(BinaryTree<Association<String, String>> tree, List<String> lines) { 
        for (String line : lines ) {
            String[] words = line.split("\\s+"); 
            
            for (String word : words) {
                Association<String, String> search = new Association<>(word, null);
                Association<String, String> result = tree.search(search);
                
                if (result != null) {
                    System.out.print(result.getValue() + " ");
                } else { 
                    System.out.print("*" + word + "*" + " ");
                } 
            } 
        } 
        System.out.println();
    } 
}