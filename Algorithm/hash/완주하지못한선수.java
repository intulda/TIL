package hash;

import java.util.HashMap;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        Solution.solution(participant, completion);
    }

    /**
     * 처음엔 for을 사용해서 null로 변경한 뒤 null 체크를 하는 방식으로 했는데 2중 for문을 써서 체크하는 바람에 O(n^2) 때문에 시간초과가 났다.
     * 찾아보다가 본의 아니게 정답을 봐버려서, 왜 이렇게 했는지 이해하는 방향으로 생각했다.
     * getOrDefault 라는 함수가 HashMap에 존재하는 걸 처음알게 되었음.
     * getOrDefault 는 찾는 키값이 있으면 해당 값을 뱉어주고, 없다면 내가 정한 defaultValue를 넘겨줄 수 있는 함수다.
     *
     * [세팅]
     * 먼저 참가자들의 이름을 키 값으로 전부 참여했다는 의미로 hashMap에 1이라는 값으로 넣어줘 세팅한다.
     * [비지니스 로직]
     * 그 다음 완주한 선수들의 이름을 돌면서 값을 찾아 -1 로 빼주게 되면 완주한 사람들은 0, 완주하지 못한 사람들은 그 이상의 값으로 남게 된다.
     * [결과]
     * 0이 아닌 사람을 돌면서 찾아 값을 리턴해주면 된다.
     *
     * 주제가 hash 였는데 먼저 손 부터 나가 코딩하는 습관때문에 가장 익숙한 for 문을 찾는게 내 문제 중 하나 인 것 같다.
     */

    static class Solution {
        static String solution(String[] participant, String[] completion) {
            String answer = "";

            HashMap<String, Integer> hashMap = new HashMap<>();

            for (String participate : participant) {
                hashMap.put(participate, hashMap.getOrDefault(participate, 0) + 1);
            }

//        {"mislav": 2},
//        {"stanko": 1},
//        {"ana": 1}

            for (String participate : completion) {
                hashMap.put(participate, hashMap.getOrDefault(participate, 0) - 1);
            }

//        {"mislav": 1},
//        {"stanko": 0},
//        {"ana": 0}

            for (String participate : hashMap.keySet()) {
                if (hashMap.get(participate) != 0) {
                    answer = participate;
                }
            }

            return answer;
        }
    }
}


