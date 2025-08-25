package hash;

import java.util.HashSet;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};

        System.out.println(Solution.solution(nums));
    }

    /**
     * HashSet 까지는 바로 떠올랐는데, 경우의 수를 찾는 과정이 생각이 나질 않았다.
     * 조건이 내가 가질 수 있는 최대 수와, 종류의 수가 제한이 있기 때문에 Math.min 만으로 경우의 수 체크가 된다.
     */
    static class Solution {
        public static int solution(int[] nums) {
            int pickUpSize = nums.length / 2;

            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : nums) {
                hashSet.add(num);
            }
            int typeSize = hashSet.size();

            return Math.min(typeSize, pickUpSize);
        }
    }
}

