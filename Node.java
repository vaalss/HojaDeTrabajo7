/**
 * Valeria Hernández Maldonado 25086
 */

public class Node<E> {
    E data;
    Node<E> left;
    Node<E> right;

    public Node(E data) {
        this.data = data;
        this.left = null; //inicia sin hijos
        this.right = null;
    }
}
