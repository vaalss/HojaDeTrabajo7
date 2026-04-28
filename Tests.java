/**
 * Valeria Hernández Maldonado 25086
 * Clase de implementación de pruebas unitarias
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    private BinaryTree<Association<String, String>> tree;

    @Before
    public void setup() {
        tree = new BinaryTree<>();
    }

    @Test
    public void insertionAndSearch() {
        tree.insert(new Association<>("dog", "perro"));
        tree.insert(new Association<>("house", "casa"));
        tree.insert(new Association<>("woman", "mujer"));

        Association<String, String> result = tree.search(new Association<>("dog", null));

        assertNotNull(result);
        assertEquals("perro", result.getValue());
    }

    @Test
    public void testSearchNotFound() {
        tree.insert(new Association<>("cat", "gato"));

        Association<String, String> result = tree.search(new Association<>("cow", null));

        assertNull(result);
    }
}
