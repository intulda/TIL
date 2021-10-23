package string;

import java.util.*;

public class 문자열압축 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int size = word.length();
        char[] words = new char[size + 10];

        for (int i = 0; i < size; i++) {
            words[i] = word.charAt(i);
        }

        int count = 0;
        for (int i = 0 ; i < size; i++) {
            count++;
            if (words[i] != words[i + 1]) {
                if (count == 1) {
                    System.out.print(words[i]);
                } else {
                    System.out.print(count + "" +words[i]);
                }
                count = 0;
            }
        }


    }
}
