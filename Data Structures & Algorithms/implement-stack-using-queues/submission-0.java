class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    boolean using1;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        using1 = true;
    }
    
    public void push(int x) {
        Queue<Integer> qOld = q1;
        Queue<Integer> qNew = q2;

        if (!using1) {
            qOld = q2;
            qNew = q1;
        }

        qNew.add(x);
        while (!qOld.isEmpty()) {
            qNew.add(qOld.remove());
        }

        using1 = !using1;
    }
    
    public int pop() {
        if (using1) {
            return q1.remove();
        }

        return q2.remove();
    }
    
    public int top() {
        if (using1) {
            return q1.peek();
        }

        return q2.peek();
    }
    
    public boolean empty() {
        if (using1) {
            return q1.isEmpty();
        }

        return q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */