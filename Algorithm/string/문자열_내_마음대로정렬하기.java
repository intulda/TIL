package string;

import java.util.Arrays;

public class 문자열_내_마음대로정렬하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1))); // ["car", "bed", "sun"]
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2))); //["abcd", "abce", "cdx"]
    }
    public static String[] solution(String[] words, int n) {
        Arrays.sort(words, (a, b) -> {
            // 비교 문자가 같다면 word 자체비교 조건
            if (a.charAt(n) ==  b.charAt(n)) {
                // Comparator
                return a.compareTo(b);
            }

            return a.charAt(n) - b.charAt(n);
        });
        return words;
    }
}
