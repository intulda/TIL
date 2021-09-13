package dataStructure;

public interface Stack {
    void create(int size);
    void push(int num);
    void pop();
    int top();
    int size();
}

class StackTest {
    public static void main(String[] args) {
        ArraysStack stack = new ArraysStack();
        stack.create(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.top());
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();

    }
}

class ArraysStack implements Stack {

    private int[] arr;
    private int top;
    private int capacity;

    @Override
    public void create(int size) {
        this.arr = new int[size + 10];
        this.capacity = size;
        this.top = 0;
    }

    @Override
    public void push(int num) {
        if(this.top >= this.capacity) {
            System.out.println("Stack Overflow");
        } else {
            this.arr[this.top++] = num;
        }
    }

    @Override
    public void pop() {
        if(top <= 0) {
            System.out.println("Stack Underflow");
        } else {
            this.arr[this.top - 1] = 0;
            this.top--;
        }
    }

    @Override
    public int top() {
        if(top <= 0) {
            return -1;
        } else {
            return arr[top - 1];
        }
    }

    @Override
    public int size() {
        return top;
    }
}
