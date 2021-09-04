package search;

import java.util.Scanner;

public class BinarySearch {

    static int[] numbers;
    public static void main(String[] args) {
        //O(log n)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        numbers = new int[n + 10];
        for(int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }

        int index = binarySearch(numbers, 0, n - 1, m);
        if(index == -1) {
            System.out.println("숫자가 없습니다.");
        } else {
            System.out.println(index + "번째에 숫자가 있습니다.");
        }

    }

    static int binarySearch(int[] arr, int start, int end, int value) {
        if(start > end) {
            return -1;
        } else if(start == end) {
            if(arr[start] == value) {
                return start;
            } else {
                return -1;
            }
        } else {
            int mid = (start + end) / 2;
            if(arr[mid] == value) {
                return mid;
            } else if(arr[mid] > value) {
                return binarySearch(arr, start, mid, value);
            } else {
                return binarySearch(arr, mid + 1, end, value);
            }
        }
    }
}
