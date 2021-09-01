package sort;


import java.util.Scanner;

public class MergeSort {
    static int n;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n + 10];
        for(int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }

        mergeSort(numbers, 0, n - 1);

        for(int i=0; i<n; i++) {
            System.out.printf("%d ", numbers[i]);
        }
        System.out.println("");
    }


    static void mergeSort(int[] numbers, int start, int end) {
        //배열의 start부터 end가지를 합병정렬하는 하는 함수
        if(start >= end) {
            return;
        } else {
            //1. 왼쪽 절반을 합병정렬
            //2. 오른쪽 절반을 합병정렬
            //3. 합친다.
            int middle = (start + end) / 2;
            mergeSort(numbers, start, middle);

            // 0 3 / 2 = 1


            mergeSort(numbers, middle+1, end);

            //arr[start~mid], arr[mid+1~end] 는 정렬이 이미 되어있음
            merging(numbers, start, middle, middle+1, end);
        }
    }

    static void merging(int[] arr, int start, int end, int start2, int end2) {
        int p, q; //p와 q의 현재 최솟값을 가리키는 변수들
        int[] temp = new int[100]; //합쳐진 결과를 저장하는 임시변수
        int _temp_idx = 0;

        p = start;
        q = start2;

        while(p<=end && q<=end2) {
            if(arr[p] <= arr[q]) {
                temp[_temp_idx++] = arr[p];
                p++;
            } else {
                temp[_temp_idx++] = arr[q];
                q++;
            }
        }

        if(p > end) {
            for(int i=q; i<=end2; i++) {
                temp[_temp_idx++] = arr[i];
            }
        } else {
            for(int i=p; i<=end; i++) {
                temp[_temp_idx++] = arr[i];
            }
        }

        for(int i=start; i<=end2; i++) {
            numbers[i] = temp[i-start];
        }
    }
}
