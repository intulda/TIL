package dataStructure;

import java.util.Scanner;

//배열
public class 트리순회결과출력 {
    static int n;
    static final int MAX = 100;
    static Tree[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tree = new Tree[MAX];
        //tree[i] = 노드 i의 정보를 담고있음
        //tree[i].left = 노드 i의 왼쪽 노드 번호
        //tree[i].right = 노드 i의 오른쪽 노드 번호

        for(int i=0; i<n; i++) {
            Tree temp = new Tree();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            temp.setLeft(b);
            temp.setRight(c);
            tree[a] = temp;
        }

        preorder(0);
        inorder(0);
        postorder(0);
    }

    //전위 순회
    static void preorder(int x) {
        //x를 루트로 하는 서브트리를 전위순회 하여 출력하는 함수.
        //0 1 3 4 2 5
        //          0
        //      1       2
        //   3    4   -1  5
        //-1 -1 -1 -1   -1 -1

        // 0 1 3 4 2 5

        if(tree[x].getLeft() == -1 && tree[x].getRight() == -1) {
            System.out.print(x + " ");
        } else {
            System.out.print(x + " ");
            if(tree[x].getLeft() != -1) {
                preorder(tree[x].getLeft());
            }

            if(tree[x].getRight() != -1) {
                preorder(tree[x].getRight());
            }
        }
    }

    //중위 순회
    static void inorder(int x) {
        //x를 루트로하는 서브트리를 중위순회 하여 출력하는 함수
        //3 1 4 0 2 5
        //         0
        //      1       2
        //   3    4   -1  5
        //-1 -1 -1 -1   -1 -1
        if(tree[x].getLeft() == -1 && tree[x].getRight() == -1) {
            System.out.print(x + " ");
        } else {
            if(tree[x].getLeft() != -1) {
                inorder(tree[x].getLeft());
            }

            System.out.print(x + " ");

            if(tree[x].getRight() != -1) {
                inorder(tree[x].getRight());
            }
        }
    }

    //후위 순회
    static void postorder(int x) {
        if(tree[x].getLeft() == -1 && tree[x].getRight() == -1) {
            System.out.print(x + " ");
        } else {
            if(tree[x].getLeft() != -1) {
                postorder(tree[x].getLeft());
            }

            if(tree[x].getRight() != -1) {
                postorder(tree[x].getRight());
            }

            System.out.printf(x + " ");
        }
    }
}

class Tree {
    private int left;
    private int right;

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}

