/**
 * Valeria Hernández Maldonado 25086
 * Clase encargada de manejar las asociaciones, 
 * guardando en la clave la palabra en ingles, 
 * y en el valor la traducción de dicha palabra al español
 */

public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    
    private K key;
    private V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override //método auxiliar para armar correctamente el árbol, basandose en orden alfabético
    public int compareTo(Association<K, V> other ) {
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString() { //método auxiliar para mostrar las asociaciones correctamente en la terminal
        return "(" + key + ", " + value + ")";
    }
}