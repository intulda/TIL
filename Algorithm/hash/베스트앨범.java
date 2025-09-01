package hash;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 베스트앨범 {
    public static void main(String[] args) {
        /**
         * 문제 설명
         * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
         *
         * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
         * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
         * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
         * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
         *
         * 제한사항
         * genres[i]는 고유번호가 i인 노래의 장르입니다.
         * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
         * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
         * 장르 종류는 100개 미만입니다.
         * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
         * 모든 장르는 재생된 횟수가 다릅니다.
         */
        String[] genres = new String[] {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[] {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(Solution.solution(genres, plays)));
    }

    /**
     * stream이 아니더라도 전혀 못 푼 문제
     * 어디서 부터 만들어야할지 감이 안와서 못 푼 문제.
     * 해답을 찾은 뒤 다시 작성하면서 이해하는 느낌으로 학습 했다.
     * stream api에 어떤어떤 기능이 있는지 몰라 찾아보느라 더 힘들었던 것 같다.
     */
    static class Solution {
        public static class Song {
            int id;
            String genre;
            int plays;

            public Song(int id, String genre, int plays) {
                this.id = id;
                this.genre = genre;
                this.plays = plays;
            }
        }

        public static int[] solution(String[] genres, int[] plays) {
            // 1. 장르별 총 재생 횟수 계산
            Map<String, Integer> genrePlayCount = IntStream.range(0, genres.length)
                    .boxed()
                    .collect(Collectors.groupingBy(
                            i -> genres[i],
                            Collectors.summingInt(i -> plays[i])
                    ));

            // 2. 노래들을 Song 객체로 만들고, 장르별로 그룹화
            Map<String, List<Song>> songsByGenre = IntStream.range(0, genres.length)
                    .mapToObj(i -> new Song(i, genres[i], plays[i]))
                    .collect(Collectors.groupingBy(s -> s.genre));

            // 3. 장르 정렬 및 노래 선택
            return genrePlayCount.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .flatMap(entry -> songsByGenre.get(entry.getKey()).stream()
                            .sorted((s1, s2) -> {
                                if (s1.plays == s2.plays) {
                                    return s1.id - s2.id;
                                }
                                return s2.plays - s1.plays;
                            })
                            .limit(2)
                    )
                    .mapToInt(s -> s.id)
                    .toArray();
        }
    }
}

