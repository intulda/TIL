package hash;

import java.util.Arrays;

public class 전화번호_목록 {

    public static void main(String[] args) {
        String[] data = new String[] {"119", "97674223", "1195524421"};
        System.out.println(Solution.solution(data));
    }

    /**
     * 해시가 주제인 내용에서.. for 문으로 풀었는데 답이 다 통과되었다.
     * 이렇게 풀어도 제출에서 통과가 되면 되는건지는 의문이다...
     */
    static class Solution {
        public static boolean solution(String[] phone_book) {
            boolean answer = true;
            int size = phone_book.length;

            Arrays.sort(phone_book);

            for (int i = 0; i < size - 1; i++) {
                if (phone_book[i + 1].startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
            }

            return answer;
        }
    }
}
