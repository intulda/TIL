package sort;

import java.util.Scanner;

public class QuickSort {

    /**
     * 원소를 하나 정하여, 해당 원소보다 작은 수와 큰 수를 나눈다.
     * pivot = 기둥/중심
     */
    static int n;
    static int[] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n + 10];
        for(int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }

        quickSort(numbers, 0, n-1);

        for(int i=0; i<n; i++) {
            System.out.printf("%d ", numbers[i]);
        }
        System.out.println("");
    }

    static void quickSort(int [] arr, int start, int end) {
        //arr을 start부터 end까지 정렬하려는 함수
        //기저조건일때 제대로 돌아갈때 짜야함
        if(start >= end) {
            return;
        }

        int pivot = arr[start];
        int[] left = new int[n + 10];
        int[] right = new int[n + 10];
        int leftIndex = getLeft(arr, start+1, end, pivot, left);
        int rightIndex = getRight(arr, start+1, end, pivot, right);

        for(int i=0; i<leftIndex; i++) {
            arr[start + i] = left[i];
        }

        arr[start + leftIndex] = pivot;

        for(int i=0; i<rightIndex; i++) {
            arr[start + leftIndex + 1 + i] = right[i];
        }

        quickSort(arr, start, start + leftIndex - 1);
        quickSort(arr, start + leftIndex + 1, end);
    }

    static int getLeft(int[] arr, int start, int end, int pivot, int[] result) {
        //arr의 start부터 end까지 숫자들 중에서 pivot보다 작거나 같은 값을 result에 채우는 함수
        int index = 0;
        for(int i=start; i<=end; i++) {
            if(arr[i] <= pivot) {
                result[index++] = arr[i];
            }
        }
        return index;
    }

    static int getRight(int[] arr, int start, int end, int pivot, int[] result) {
        //arr의 start부터 end까지 숫자들 중에서 pivot보다 큰 값을 result에 채우는 함수
        int index = 0;
        for(int i=start; i<=end; i++) {
            if(arr[i] > pivot) {
                result[index++] = arr[i];
            }
        }
        return index;
    }

}
