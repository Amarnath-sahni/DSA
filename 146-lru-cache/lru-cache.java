class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private int capacity;
    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;


    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy nodes
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {

        if(!map.containsKey(key)) {
            return -1;
        }


        Node node = map.get(key);


        // Move to front because it is recently used
        remove(node);
        addFirst(node);


        return node.value;
    }


    public void put(int key, int value) {


        // If key already exists
        if(map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            remove(node);
            addFirst(node);

        }
        else {

            Node node = new Node(key, value);

            map.put(key, node);

            addFirst(node);


            // Capacity exceeded
            if(map.size() > capacity) {

                Node lru = tail.prev;

                remove(lru);

                map.remove(lru.key);
            }
        }
    }



    // Add node after head
    private void addFirst(Node node) {

        Node nextNode = head.next;


        head.next = node;
        node.prev = head;


        node.next = nextNode;
        nextNode.prev = node;
    }



    // Remove node from list
    private void remove(Node node) {

        Node prevNode = node.prev;
        Node nextNode = node.next;


        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}