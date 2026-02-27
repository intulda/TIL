package stack_queue;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    /**
     * 내가 짠 코드는 마지막 테스트 코드에 실패하였다. 도저히 모르겠어서 클로드에게 물어보니
     * 날짜 계산이 정확하지 않다고 하여, (100 - progress + speed - 1) / speed 공식으로 올림 계산을 하라고 한다.
     * 이 부분이 제대로 이해가 가지 않았는데, 딱 나누어 떨어지지않으면 하루가 더 필요한 상황이 오기때문에 그렇다고 설명받았다.
     * 자그만한 수학 공식을 외우는 것도 중요한 것 같다..
     */
    static int[] solution(int[] progresses, int[] speeds) {
        int[] answers = {};

        // 작업 진행도에서 각 스피드를 체크해 몇일 뒤 배포가 가능한건지 배열로 리턴해야함
        // 앞의 작업이 배포가 안되면 그만큼 뒤의 작업은 늘어난다
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int index = 0;
        int prevDay = 0;
        int currentDay = 0;

        while (index < progresses.length) {
            currentDay++;
            progresses[index] = progresses[index] + speeds[index];

            if (progresses[index] >= 100) {
                if (prevDay == 0) {
                    prevDay = currentDay;
                }

                if (prevDay >= currentDay) {
                    map.put(prevDay, map.getOrDefault(prevDay, 0) + 1);
                } else {
                    map.put(currentDay, map.getOrDefault(currentDay, 0) + 1);
                    prevDay = currentDay;
                }

                currentDay = 0;
                index++;
            }
        }

        answers = new int[map.size()];

        int _index = 0;
        for (int value : map.keySet()) {
            answers[_index++] = map.get(value);
        }

        return answers;
    }
}
