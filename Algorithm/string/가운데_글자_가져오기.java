package string;

public class 가운데_글자_가져오기 {

    public static void main(String[] args) {
        System.out.println(solution("abcde")); // "c"
        System.out.println(solution("qwer")); // "we"
    }

    public static String solution(String str) {
        int size = str.length();
        char[] w = str.toCharArray();

        if (size % 2 == 0) {
            return w[size / 2 - 1] + String.valueOf(w[size / 2]);
        }

        return String.valueOf(w[size / 2]);
    }
}
