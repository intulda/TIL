package string;

public class 자릿수더하기 {
    public static void main(String[] args) {
        System.out.println(solution(123)); // 6
    }

    public static int solution(int number) {
//        String strNumber = number + "";
//        int size = strNumber.length();

        int answer = 0;
//        for (int i = 0; i < size; i++) {
//            char a = strNumber.charAt(i);
//            answer += Integer.parseInt(String.valueOf(a));
//        }

        while(number != 0) {
            answer += number % 10;
            number = number / 10;
        }

        return answer;
    }
}
