package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};

        Arrays.sort(nums);

        System.out.println(Solution.solution(nums));
    }

    /**
     * HashSet 까지는 바로 떠올랐는데, 경우의 수를 찾는 과정이 생각이 나질 않았다.
     * 조건이 내가 가질 수 있는 최대 수와, 종류의 수가 제한이 있기 때문에 Math.min 만으로 경우의 수 체크가 된다.
     */
    static class Solution {
        public static int solution(int[] nums) {
            //내가 최대로 구할 수 있는 포켓몬의 수
            int pickUpPokemon = nums.length / 2;

            // 중복제거
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            return Math.min(set.size(), pickUpPokemon);
        }
    }
}

