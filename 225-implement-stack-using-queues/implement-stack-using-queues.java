import java.util.*;

class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        for (int i = 1; i <= q.size() - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    public int top() {
        for (int i = 1; i <= q.size() - 1; i++) {
            q.add(q.remove());
        }

        int val = q.peek();

        // Restore the queue after getting the top element
        q.add(q.remove());

        return val;
    }

    public boolean empty() {
        return q.isEmpty();
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

