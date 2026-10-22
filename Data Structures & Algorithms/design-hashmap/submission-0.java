class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] buckets;
    int numBuckets = 997;

    public MyHashMap() {
        buckets = new Node[numBuckets];
    }

    private Node getNode(int key) {
        int bucketIndex = key % numBuckets;
        Node bucketNode = buckets[bucketIndex];

        while (bucketNode != null) {
            if (bucketNode.key == key) {
                return bucketNode;
            }

            bucketNode = bucketNode.next;
        }

        return null;
    }

    private Node getPrevNode(int key) {
        int bucketIndex = key % numBuckets;
        Node bucketNode = buckets[bucketIndex];

        while (bucketNode != null && bucketNode.next != null) {
            if (bucketNode.next.key == key) {
                return bucketNode;
            }

            bucketNode = bucketNode.next;
        }

        return null;
    }    
    
    public void put(int key, int value) {
        Node node = getNode(key);

        if (node != null) {
            node.value = value;
            return;
        }

        node = new Node(key, value);
        int bucketIndex = key % numBuckets;
        Node tail = buckets[bucketIndex];

        if (tail == null) {
            buckets[bucketIndex] = node;
            return;
        }

        while (tail != null) {
            if (tail.next == null) {
                tail.next = node;
                return;
            }

            tail = tail.next;
        }
    }
    
    public int get(int key) {
        Node node = getNode(key);
        if (node == null) {
            return -1;
        }

        return node.value;
    }
    
    public void remove(int key) {

        // Case 1
        int bucketIndex = key % numBuckets;
        Node node = buckets[bucketIndex];
        if (node != null && node.key == key) {
            buckets[bucketIndex] = buckets[bucketIndex].next;
        }


        // Case 2
        Node prevNode = getPrevNode(key);

        if (prevNode != null) {
            prevNode.next = prevNode.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */