package graph;

import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

//벡터로
public class 인접리스트 {
    static final int MAX = 100;
    public static void main(String[] args) {
        /**
         * 1: 2 3 4
         * 2: 1 4
         * 3: 1 5
         * 4: 1 2 5
         * 5: 3 4
         *
         *
         * 5 6
         * 1 2
         * 1 3
         * 1 4
         * 2 4
         * 3 5
         * 4 5
         */
        Scanner sc = new Scanner(System.in);
        Vector<Integer>[] vector = new Vector[MAX];
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(vector[a] == null) {
                vector[a] = new Vector<>();
            }

            vector[a].add(b);

            if(vector[b] == null) {
                vector[b] = new Vector<>();
            }
            vector[b].add(a);
        }

        for(int i=1; i<=n; i++) {
            System.out.print(i + "(" +vector[i].size() + ")");
            for(int j=0; j<vector[i].size(); j++) {
                System.out.print(vector[i].get(j));
            }
            System.out.println("");
        }
    }
}
