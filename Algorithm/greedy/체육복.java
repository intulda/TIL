package greedy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class 체육복 {
    public static void main(String[] args) {
        //5	[2, 4]	[1, 3, 5]
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> reserveSet = new HashSet<>();
        for (int r : reserve) reserveSet.add(r);

        Set<Integer> lostSet = new HashSet<>();
        for  (int l : lost) lostSet.add(l);

        Set<Integer> overlap = new HashSet<>(reserveSet);
        overlap.retainAll(lostSet); // Set안에 중복 되는 자원만 남기기 retainAll()

        reserveSet.removeAll(overlap);
        lostSet.removeAll(overlap);

        for (int l : new TreeSet<>(lostSet)) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
            } else {
                n--;
            }
        }
        return n;
    }
}
