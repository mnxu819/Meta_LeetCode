Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
双向链表+Map：1超过了capacity把表头删除 2get了话，把该元素插到表后 3新加元素也是放到表后

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node (int k, int v) {
        key = k;
        value = v;
    }     
}

class DoubleLinkedList {
    private Node dummy = new Node(-1, -1);
    private Node tail = dummy;
    //add node to tail of the list
    public void add(Node node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }
    public Node getHead() {
        return dummy.next;
    }
    public void remove(Node node) {
        //set next pointer
        node.prev.next = node.next;
        //set prev ponter, need to check if it's tail
        if (node.next !=  null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        node.prev = null;
        node.next = null;
    }
    public void moveToTail(Node node) {
        remove(node);
        add(node);
    }
}
class LRUCache {
    private int capacity = 0;
    private Map<Integer, Node> map = new HashMap<>();
    private DoubleLinkedList list = new DoubleLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.moveToTail(node);
            return node.value;
        } else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        //如果已经有了，移动这个key，更新value
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            list.moveToTail(node);
        } else {
            if (map.size() == capacity){
                Node head = list.getHead();
                map.remove(head.key);
                list.remove(head);
            } 
            Node node = new Node(key, value);
            map.put(key, node);
            list.add(node);      
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
