package stack_queue;

import java.util.Stack;

/**
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
 * <p>
 * "()()" 또는 "(())()" 는 올바른 괄호입니다.
 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 * <p>
 * 제한사항
 * 문자열 s의 길이 : 100,000 이하의 자연수
 * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
 */
public class 괄호연습 {
    public static void main(String[] args) {
        System.out.println(solution("()()")); // 기대값 true
        System.out.println(solution("(())()")); // 기대값 true
        System.out.println(solution(")()(")); // 기대값 false
        System.out.println(solution("(()(")); // 기대값 false
    }

    static boolean solution(String s) {
        boolean answer;
        // 스택 문제
        // 여는 괄호가 있다면 닫는 괄호도 꼭 있어야함
        Stack<Character> stack = new Stack<>();

        for (char a : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(a);
                continue;
            }

            if (stack.peek() == '(' && a != ')') {
                stack.push(a);
            } else if (stack.peek() == '(' && a == ')') {
                stack.pop();
            }
        }

        answer = stack.empty();

        return answer;
    }
}
