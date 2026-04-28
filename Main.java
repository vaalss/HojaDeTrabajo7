import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List; 
import java.util.Scanner; 

public class Main { 
    public static void main(String[] args) throws Exception { 
        Scanner sc = new Scanner(System.in); 
        BinaryTree<Association<String, String>> tree = new BinaryTree<>(); 
        List<Association<String, String>> dictionary = FileHelper.readDictionary("diccionario.txt"); 
        
        for (Association<String, String> association : dictionary) { 
            tree.insert(association); 
        } 
        
        List<String> words = FileHelper.readText("texto.txt"); 
        
        int salir = -1; 
        while (salir == -1) { 
            System.out.println("\n1. Mostrar diccionario ordenado\n2. Traducir texto\n3. Salir"); 
            System.out.print("Seleccione la opción que desea realizar: "); 
            
            int opcion = sc.nextInt(); 
            sc.nextLine(); 
            
            switch(opcion) { 
                case 1: 
                    System.out.println("\n------ Diccionario ordenado ------");
                    tree.inOrder(); 
                    break; 
                case 2: 
                    System.out.println("\n------ Traducción ------"); 
                    translate(tree, words); 
                    break; 
                case 3: 
                    salir = 0; 
                    break; 
                default: System.out.println("Opción inválida"); 
            } 
        } 
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