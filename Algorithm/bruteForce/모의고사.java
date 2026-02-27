package bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class 모의고사 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1,2,3,4,5}))); // [1]
        System.out.println(Arrays.toString(solution(new int[] {1,3,2,4,2}))); // [1, 2, 3]
        System.out.println(Arrays.toString(solution(new int[] {1,4,5,2,3,4,4,1,2,3,4,5,1,2}))); // [2, 3]
    }

    static int[] solution(int[] answers) {
        int[] giveUp1 = {1, 2, 3, 4, 5};
        int[] giveUp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveUp3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == giveUp1[i % giveUp1.length]) score[0]++;
            if (answers[i] == giveUp2[i % giveUp2.length]) score[1]++;
            if (answers[i] == giveUp3[i % giveUp3.length]) score[2]++;
        }

//        int max = Math.max(score[0], Math.max(score[1], score[2]));
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < score.length; i++) {
//            if (score[i] == max) {
//                list.add(i + 1);
//            }
//        }
//
//        return list.stream()
//                .mapToInt(Integer::intValue)
//                .toArray();
        int max = IntStream.of(score).max().orElse(0);

        return IntStream.range(0, score.length)
                .filter(i -> score[i] == max)
                .map(i -> i + 1)
                .toArray();
    }
}
