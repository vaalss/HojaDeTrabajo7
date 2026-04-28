/**
 * Valeria Hernández Maldonado 25086
 * Clase encargada de manejar los inputs del usuario
 * y traducir el contenido del archivo "texto.txt"
 */

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
            tree.insert(association); //crea el árbol con base al diccionario
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
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    public static void translate(BinaryTree<Association<String, String>> tree, List<String> lines) {
        for (String line : lines ) {
            String[] words = line.split("\\s+");
            
            for (String word : words) { //buscada cada una de las palabras en el árbol
                Association<String, String> search = new Association<>(word,    null);
                Association<String, String> result = tree.search(search);

                if (result != null) {
                    System.out.print(result.getValue() + " ");
                } else {
                    System.out.print("*" + word + "*" + " "); //si no se encuentra la palabra se deja indicada
                }
            }
            System.out.println(); //salto de línea al final de cada línea del archivo original
        }
        

    }

}