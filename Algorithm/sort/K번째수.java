package sort;

import java.util.Arrays;

public class K번째수 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[] {1, 5, 2, 6, 3, 7, 4},
                new int[][] {
                        {2, 5, 3},
                        {4, 4, 1},
                        {1, 7, 3}
                }
        )));
    }

    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;

        for (int[] command : commands) {
            int start = command[0]; // 2
            int end = command[1]; // 5
            int index = command[2]; // 3

            int size = (end - start) + 1;
            int[] tempArray = new int[size];
            int tempIndex = 0;

            for (int i = 0; i < array.length; i++) {
                if (i >= start - 1  && i <= end - 1) {
                    tempArray[tempIndex++] = array[i];
                }
            }

            Arrays.sort(tempArray);
            answer[answerIndex++] = tempArray[index - 1];
        }

        return answer;
    }
}
