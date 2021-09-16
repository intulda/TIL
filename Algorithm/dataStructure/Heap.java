package dataStructure;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.push(3);
        pq.push(5);
        pq.push(88);

        System.out.println(pq.top());
        pq.pop();

        System.out.println(pq.top());
        pq.pop();

        System.out.println(pq.top());
        pq.pop();
    }
}


// 우선순위큐 [힙]을 배열로 구현하여 우선순위 큐 구현
class PriorityQueue {

    private final int MAX = 100;
    private int[] data;
    private int len;

    public PriorityQueue() {
        data = new int[MAX];
        len = 1;
    }

    public void push(int x) {
        data[len++] = x;
        int index = len - 1;

        while(index > 1) {
            if(data[index] < data[index / 2]) {
                int temp = data[index];
                data[index] = data[index / 2];
                data[index / 2] = temp;
            } else {
                break;
            }
            index /= 2;
        }
    }

    public void pop() {
        data[1] = data[len - 1];
        data[len - 1] = 0;
        len--;

        int index = 1;
        while(true) {
            //1. 자식들 중에서 우선순위가 높은 친구를 알아 내야함.
            //2. 나와 그 우선순위가 높은 친구를 비교해서 자리를 바꾸어야함.

            int pIndex = -1; //우선순위가 높은 순위의 노드 번호

            //(A) 자식이 모두 없는 경우
            if(len <= index * 2) {
                break;
            }
            //(B) 왼쪽 자식만 존재하는 경우
            else if((1 <= index * 2 && index * 2 < len) && len <= index * 2 + 1) {
                pIndex = index * 2;
            } else {
                //(C) 왼쪽 오른쪽 자식이 모두 존재하는 경우
                if(data[index * 2] < data[index * 2 + 1]) {
                    pIndex = index * 2;
                } else {
                    pIndex = index * 2 + 1;
                }
            }

            if(data[index] > data[pIndex]) {
                int temp = data[index];
                data[index] = data[pIndex];
                data[pIndex] = temp;
                index = pIndex;
            } else {
                break;
            }
        }

    }

    public int top() {
        return data[1];
    }
}