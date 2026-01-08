package string;

public class 문자열_다루기_기본 {
    public static void main(String[] args) {
        System.out.println(solution("a1234")); // false
        System.out.println(solution("1234")); // true
        System.out.println(solution("aaaaa")); // false
        System.out.println(solution("1")); // false
        System.out.println(solution("v")); // false
        System.out.println(solution("ab10a112b")); // false
        System.out.println(solution("ABCD223")); // false
        System.out.println(solution("00000000")); // false
        System.out.println(solution("1213141241294234832957")); // false
    }

    public static boolean solution(String str) {
        if (str.length() != 4 && str.length() != 6) {
            return false;
        }

        String pattern = "^[0-9]*$";
        return str.matches(pattern);
    }
}
