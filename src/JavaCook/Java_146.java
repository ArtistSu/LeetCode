package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_146 {
    /**
     * @TimeComplexity O(1)
     * @SpaceComplexity O(capacity)
     */
    class LRUCache {

        // Define doubly linkedlist
        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> cache;
        private final Node head;
        private final Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                moveToHead(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToHead(newNode);

                if (cache.size() > capacity) {
                    Node tailNode = removeTail();
                    cache.remove(tailNode.key);
                }
            }
        }

        private void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private Node removeTail() {
            Node prevNode = tail.prev;
            removeNode(prevNode);
            return prevNode;
        }
    }
}