package hash;

import java.util.HashMap;

public class 의상 {
    public static void main(String[] args) {
        String[][] closets = new String[][] {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };


        System.out.println(Solution.solution(closets));
    }

    /**
     * 해시 맵에 카운트를 세는 것 까지는 생각했으나, 안 입었을때의 경우를 1로 만드는 과정을 생각하지 못했다.
     * 알고보면 너무 간단한 문제인데... 이런 과정이 생각이 안나는 걸 어떤식으로 채워줘야할지 모르겠다.
     * 각 항목의 경우의수도 그냥 카운트끼리 곱하면 되는데 이런 간단한 것 조차 생각하지 못하는게ㅠ..
     */

    static class Solution {
        public static int solution(String[][] closets) {
            int answer = 1;

            HashMap<String, Integer> hashMap = new HashMap<>();

            // 종류로 해시맵 카운트 저장
            for (String[] closet : closets) {
                hashMap.put(closet[1], hashMap.getOrDefault(closet[1], 1) + 1);
            }

            System.out.println(hashMap.toString());

            // 경우의 수
            for (Integer count : hashMap.values()) {
                answer *= count;
            }

            return answer - 1;
        }
    }
}
