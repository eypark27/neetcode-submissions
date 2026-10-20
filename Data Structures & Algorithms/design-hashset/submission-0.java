class MyHashSet {

    Node[] list;

    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public MyHashSet() {
        list = new Node[10000];
    }
    
    public void add(int key) {
        if (contains(key)) {
            return;
        }

        int index = key % 10000;

        if (list[index] == null) {
            list[index] = new Node(key);
        }

        else {
            Node n = list[index];
            while (n.next != null) {
                n = n.next;
            }

            n.next = new Node(key);
        }
    }
    
    public void remove(int key) {
        int index = key % 10000;

        if (list[index] == null) {
            return;
        }

        else if (list[index].value == key) {
            list[index] = list[index].next;
            return;
        }

        Node n = list[index];
        while (n.next != null && n.next.value != key) {
            n = n.next;
        }

        if (n.next != null) {
            n.next = n.next.next;
        }
    }
    
    public boolean contains(int key) {
        int index = key % 10000;
        Node n = list[index];

        while (n != null) {
            if (n.value == key) {
                return true;
            }

            n = n.next;
        }

        return false;        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */