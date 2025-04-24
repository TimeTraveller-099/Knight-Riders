class Node {
    int key; 
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class DLL {
    Node head, tail;
    public static int size = 0;

    public DLL() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void addFirst(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

        size += 1;
    }

    public Node removeLast() {
        if (size == 0)
            return null;

        Node node = tail.prev;

        // Removing the Last Node
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;

        size -= 1;
        return node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    DLL dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        dll = new DLL();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            dll.removeNode(node);
            dll.addFirst(node);

            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);

        if (cache.containsKey(key)) { // Update the DLL and the node.value
            Node currNode = cache.get(key);
            dll.removeNode(currNode);
        } else if (cache.size() == capacity) { // If cache size is full
            Node lastNode = dll.removeLast();
            // Removing the 'Least Recently Used' Node from the Cache
            cache.remove(lastNode.key);
        }
        cache.put(key, node);
        dll.addFirst(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
