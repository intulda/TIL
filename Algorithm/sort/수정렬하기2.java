package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 백준 2751문제
 */
public class 수정렬하기2 {
    static int n;
    static int[] temp;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Integer.parseInt(bufferedReader.readLine());
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] data = new int[n + 10];
        temp = new int[n + 10];

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        mergeSort(data, 0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(data[i] + "\n");
        }

        System.out.println(sb);
    }

    static void mergeSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        } else {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            merging(arr, start, mid, mid + 1, end);
        }
    }

    static void merging(int[] arr, int start, int end, int start2, int end2) {
        int p, q;
        int _index = 0;
        p = start;
        q = start2;

        while (p <= end && q <= end2) {
            if (arr[p] <= arr[q]) {
                temp[_index++] = arr[p];
                p++;
            } else {
                temp[_index++] = arr[q];
                q++;
            }
        }

        if(p > end) {
            for(int i=q; i<=end2; i++) {
                temp[_index++] = arr[i];
            }
        } else {
            for(int i=p; i<=end; i++) {
                temp[_index++] = arr[i];
            }
        }

        for(int i=start; i<=end2; i++) {
            arr[i] = temp[i-start];
        }
    }
}
