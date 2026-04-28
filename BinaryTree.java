/**
 * Valeria Hernández Maldonado 25086
 * Clase encargada de la estructura del árbol, 
 * así como los métodos de inserción, búsqueda y
 * el ordenamiento adecuado de dicho árbol
 */


public class BinaryTree<E extends Comparable> {

    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(E value) {
        root = insert(root, value);
    }

    //método recursivo
    private Node<E> insert(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.data) < 0) {
            current.left = insert(current.left, value);
        } else if (value.compareTo(current.data) > 0){
            current.right = insert(current.right, value);
        }

        return current;
    }

    public E search(E value) {
        return search(root, value);
    }

    //método recursivo
    private E search(Node<E> current, E value) {
        if (current == null) {
            return null;
        }

        if (value.compareTo(current.data) == 0) {
            return current.data;
        }

        if (value.compareTo(current.data) < 0) {
            return search(current.left, value);
        } else {
            return search(current.right, value);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

}