package string;

public class 문자열_내_p와_y의_개수 {

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY")); // true
        System.out.println(solution("Pyy")); // false
    }

    public static boolean solution(String s) {
        char[] w = s.toLowerCase().toCharArray();
        int pCount = 0;
        int yCount = 0;

        for (int i = 0; i < w.length; i++) {
            if (w[i] == 'p') {
                pCount++;
            }

            if (w[i] == ('y')) {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}
