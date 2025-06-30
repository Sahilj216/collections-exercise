public class Answer3 {
    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack(5);
        stack.push(5);
        stack.push(50);
        stack.push(2);
        stack.push(65);
        stack.push(1);
        System.out.println("Min: " + stack.getMin());  // 1
        stack.pop();
        System.out.println("Min: " + stack.getMin()); // 2
    }
}

class SpecialStack {
    class Pair {
        int val;
        int min;
        Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
        public int getVal() { return val; }
        public int getMin() { return min; }
    }

    private Pair[] stack;
    private int top = -1;
    private int maxSize;
    private int min = Integer.MAX_VALUE;

    SpecialStack(int size) {
        stack = new Pair[size];
        maxSize = size;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        min = (top == -1) ? data : Math.min(min, data);
        stack[++top] = new Pair(data, min);
    }

    public int pop() {
        if (isEmpty()) return -1;
        int popped = stack[top--].getVal();
        min = (top >= 0) ? stack[top].getMin() : Integer.MAX_VALUE;
        return popped;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int getMin() {
        return isEmpty() ? -1 : stack[top].getMin();
    }
}

