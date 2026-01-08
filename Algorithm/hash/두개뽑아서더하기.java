package hash;

import java.util.Arrays;
import java.util.HashSet;

public class 두개뽑아서더하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1}))); // [2,3,4,5,6,7]
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7}))); // [2,5,7,9,12]
        System.out.println(Arrays.toString(solution(new int[]{0, 0}))); // [0]
        System.out.println(Arrays.toString(solution(new int[]{0, 100}))); // [100]

    }

    public static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
