package string;

import java.util.*;
import java.util.stream.Collectors;

public class 파이낸셜Q1 {

    public static void main(String[] args) {
        String[] strs = {"A B C D", "A D", "A B D", "B D"};
        int k = 2;
        int solution = new Solution().solution(strs, k);
        System.out.println(solution);
    }

    static class Solution {
        public int solution(String[] id_list, int k) {
            int answer = 0;
            //한사람이 가질 수 있는 최대 갯수 2개(k)
            //각 날짜에 포함되는지 안되는지 체크 해야함
            //k번 이상 포함 될 경우 2개 고정
            Map<String, Integer> map = new HashMap<>();
            Map<String, Integer> flag = new HashMap<>();
            List<List<String>> collect = Arrays.stream(id_list)
                    .map(str -> Arrays.asList(str.split(" ")))
                    .collect(Collectors.toList());

            for (int i = 0; i < collect.size(); i++) {
                for (int j = 0; j < collect.get(i).size(); j++) {
                    for (int p = 0; p < collect.get(i).size(); p++) {
                        if (flag.get(collect.get(i).get(j)) == null && collect.get(i).get(j).equals(collect.get(i).get(p))) {
                            int cnt = map.get(collect.get(i).get(j)) == null ? 0 : map.get(collect.get(i).get(j));
                            cnt++;
                            map.put(collect.get(i).get(j), cnt);
                            flag.put(collect.get(i).get(j), 1);
                        }
                    }
                }
                flag.clear();
            }

            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                int count = map.get(iterator.next());
                if (count > k) {
                    answer += k;
                } else {
                    answer += count;
                }
            }

            return answer;
        }
    }
}
