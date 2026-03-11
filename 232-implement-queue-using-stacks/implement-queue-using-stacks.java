import java.util.Stack;

class MyQueue {

    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
       while(!first.isEmpty()){
        second.push(first.pop());
       }
       first.push(x);
       while(!second.isEmpty()){
        first.push(second.pop());
       }
    }

    public int pop() {
       return first.pop();
    }

    public int peek() {
       return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }
}