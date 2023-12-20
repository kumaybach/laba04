package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BSTNodeTest {
    public static Map<Integer, String> map = new LinkedHashMap<>();
    public static BSTNode root;

    @Test
    void test1() {
        map.put(7, "Value 7");
        map.put(21, "Value 21");
        map.put(8, "Value 8");
        map.put(18, "Value 18");
        map.put(10, "Value 10");
        map.put(23, "Value 23");
    }

    @Test
    void test2() {
        root = new BSTNode(23, "Value 23");
        for (int key : map.keySet()) {
            root.insert(root, key, map.get(key));
        }
        assertEquals(map.size(), root.count(root));
    }

    @Test
    void test3() {
        BSTNode node;

        node = root.search(root, 100);
        assertNull(node);

        node = root.search(root, 8);
        assertEquals("Value 8", node.getValue());

        node = root.search(root, 7);
        assertEquals("Value 7", node.getValue());
    }

    @Test
    void test4() {
        BSTNode node;

        root = new BSTNode(21, "Value 21");
        for (int key : map.keySet()) {
            if (key == 18) {
                continue;
            }
            root.insert(root, key, map.get(key));
        }
        assertEquals(map.size() - 1, root.count(root));

        root.insert(root, 18, "Value 18");
        node = root.search(root, 18);
        assertEquals("Value 18", node.getValue());

        root.insert(root, 18, "Value 18 new value");
        assertEquals(map.size(), root.count(root));
        node = root.search(root, 18);
        assertEquals("Value 18 new value", node.getValue());
    }

    @Test
    void test5() {
        BSTNode node;
        root = root.delete(root, 18);
        assertEquals(map.size() -1, root.count(root));
        node = root.search(root, 18);
        assertNull(node);
    }
}