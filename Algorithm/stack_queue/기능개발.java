package stack_queue;

import java.util.ArrayList;
import java.util.Arrays;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {100, 100, 100};
        int[] speeds = {1, 1, 1};

        System.out.println(Arrays.toString(Solution.solution(progresses, speeds)));
    }

    /**
     * 내가 짠 코드는 마지막 테스트 코드에 실패하였다. 도저히 모르겠어서 클로드에게 물어보니
     * 날짜 계산이 정확하지 않다고 하여, (100 - progress + speed - 1) / speed 공식으로 올림 계산을 하라고 한다.
     * 이 부분이 제대로 이해가 가지 않았는데, 딱 나누어 떨어지지않으면 하루가 더 필요한 상황이 오기때문에 그렇다고 설명받았다.
     * 자그만한 수학 공식을 외우는 것도 중요한 것 같다..
     */
    public class Solution {
        public static int[] solution(int[] progresses, int[] speeds) {
            /**
             * ArrayList<Integer> list = new ArrayList<>();
             *         ArrayList<Integer> list2 = new ArrayList<>();
             *         ArrayList<Integer> result = new ArrayList<>();
             *
             *             for (int j : progresses) {
             *                 int remain_progress = 100 - j;
             *                 list.add(remain_progress);
             *             }
             *
             *             for (int i = 0; i < speeds.length; i++) {
             *                 int currentDay = 0;
             *
             *                 if (list.get(i) == 0) {
             *                     continue;
             *                 }
             *
             *                 for (int j = speeds[i]; j <= list.get(i); j += speeds[i]) {
             *                     currentDay++;
             *                 }
             *
             *
             *                 if (!list2.isEmpty() && list2.get(list2.size() - 1) >= currentDay) {
             *                     int last = result.get(result.size() - 1);
             *                     result.set(result.size() - 1, ++last);
             *                     continue;
             *                 }
             *
             *                 if (list2.isEmpty() || list2.get(list2.size() - 1) < currentDay) {
             *                     list2.add(currentDay);
             *                     result.add(1);
             *                 }
             *
             *             }
             *
             *             return result.stream().mapToInt(Integer::intValue).toArray();
             */
            ArrayList<Integer> result = new ArrayList<>();

            int[] days = new int[progresses.length];
            for (int i = 0; i < progresses.length; i++) {
                int remainProgress = 100 - progresses[i];
                if (remainProgress <= 0) {
                    days[i] = 0;
                } else {
                    days[i] = (remainProgress + speeds[i] - 1) / speeds[i];
                }
            }

            int i = 0;
            while (i < days.length) {
                int count = 1;
                int currentMaxDay = days[i];

                while (i + count < days.length && days[i + count] <= currentMaxDay) {
                    count++;
                }

                result.add(count);
                i += count;
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
