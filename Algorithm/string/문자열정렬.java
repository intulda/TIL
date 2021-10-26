package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class 문자열정렬{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] words = new String[size];

        for (int i = 0; i < size; i++) {
            words[i] = br.readLine();
        }

        Arrays.stream(words)
                .sorted()
                .forEach(System.out::println);
    }
}
