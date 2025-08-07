class MyHashMap {
    private class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n; // total number of key-value pairs
    private int N; // total number of buckets
    private LinkedList<Node>[] buckets;

    
    public MyHashMap() {
        this.N = 4;
        this.buckets = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }
        this.n = 0;
    }

    private int bucketIndex(int key) {
        return Math.abs(key) % N;
    }

    private int dataIndex(LinkedList<Node> bucket, int key) {
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                return i;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        int bi = bucketIndex(key);
        LinkedList<Node> bucket = buckets[bi];
        int di = dataIndex(bucket, key);

        if (di != -1) {
            bucket.get(di).value = value;
        } else {
            bucket.add(new Node(key, value));
            n++;
        }
    }

    public int get(int key) {
        int bi = bucketIndex(key);
        LinkedList<Node> bucket = buckets[bi];
        int di = dataIndex(bucket, key);

        if (di != -1) {
            return bucket.get(di).value;
        } else {
            return -1; // Key not found
        }
    }

    public void remove(int key) {
        int bi = bucketIndex(key);
        LinkedList<Node> bucket = buckets[bi];
        int di = dataIndex(bucket, key);

        if (di != -1) {
            bucket.remove(di);
            n--;
        }
    }
}