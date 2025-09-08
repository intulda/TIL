package stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] ex = new int[]{1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(Solution.solution(ex)));
    }

    public class Solution {
        public static int[] solution(int[] arr) {
            /* 기존 제출한 소스 */
           /* int[] answer = null;

            Stack<Integer> stack = new Stack<>();

            for (int j : arr) {
                if (stack.empty()) {
                    stack.add(j);
                    continue;
                }

                if (stack.peek() == j) {
                    continue;
                }
                stack.add(j);
            }

            answer = stack.stream()
                    .mapToInt(x -> x)
                    .toArray();

            return answer;*/

            /**
             * 클로드 에게 시킨 stream 리팩토링 한 소스
             * 불변성을 지키고, 사이드 이펙트를 줄였다
             * 순수함수로 인해 같은 입력에 대해 같은 출력보장
             * <p>
             * 클로드의 위로 말....
             * 다만 성능면에서는 원래 스택 버전이 더 효율적입니다.
             * 함수형 버전은 매번 새로운 객체를 생성하거나 컬렉션을 복사해야 하기 때문입니다.
             * 상황에 따라 가독성과 함수형 스타일을 택할지, 성능을 택할지 선택하면 됩니다.
             */
            return Arrays.stream(arr)
                    .boxed()
                    .collect(
                            ArrayList<Integer>::new,
                            (list, num) -> {
                                if (list.isEmpty() || !list.getLast().equals(num)) {
                                    list.add(num);
                                }
                            },
                            ArrayList::addAll
                    )
                    .stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }
}
