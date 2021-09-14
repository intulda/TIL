package dataStructure;

public class CircleQueue {

    private final int MAX = 10;
    private int front;
    private int rear;
    private int[] data;
    private int capacity;
    private int numElement;

    public static void main(String[] args) {
        CircleQueue c = new CircleQueue();
        c.create(4);
        for(int i=0; i<99; i++) {
            c.push(i);
            c.push(i + 2);
            c.push(i + 3);
            c.push(i + 4);

            c.pop();
            c.pop();
            c.pop();
            c.pop();
        }

        c.push(1);
        c.push(2);
        System.out.println(c.size());
        System.out.println(c.front());
        c.pop();
        System.out.println(c.front());
        c.pop();
        System.out.println(c.size());
    }

    void create(int y) {
        this.data = new int[MAX];
        this.capacity = y;
        this.front = 0;
        this.rear = 0;
        this.numElement = 0;
    }

    void push(int y) {
        if(this.numElement >= this.capacity) {
            System.out.println("Queue Overflow");
        } else {
            this.data[this.rear] = y;
            this.rear = (this.rear + 1) % MAX;
            this.numElement++;
        }
    }

    void pop() {
        if(this.numElement <= 0) {
            System.out.println("Queue Underflow");
        } else {
            this.data[this.front] = 0;
            this.front = (this.front + 1) % MAX;
            this.numElement--;
        }
    }

    int front() {
        if(this.numElement <= 0) {
            return -1;
        } else {
            return this.data[this.front];
        }
    }

    int size() {
        return this.numElement;
    }
}
