package bruteForce;

import java.util.Scanner;

public class Attackrange {
    /**
     * Q: 윤성이는 어렸을 적부터 수없이 몰려오는 적으로부터 기지를 방어하는 디펜스 유형의 게임을 플레이하는 것을 좋아했다. 그래서 간단한 디펜스 게임을 만들어 보려고 한다.
     * 당신은 윤성이를 도와, 디펜스 게임 내에서 플레이어가 설치하는 유닛의 사거리를 나타내는 기능을 구현하면 된다
     * I: 입력 첫째 줄에는 디펜스 게임의 맵 크기 N이 주어딘다. 맵은 N×N 크기의 2차원 형태이다. (N은 6이상 100이하의 짝수)
     * 둘째 줄에는 유닛이 설치될 위치 X, Y와 유닛의 사거리 R이 주어진다. X는 행의 번호, Y는 열의 번호를 의미한다. (X, Y는 1이상 N이하의 자연수, R은 N/2이하의 자연수)
     * O: 예제 출력과 같이 유닛의 사거리를 나타내어 출력한다. (유닛의 사거리가 아무리 길어도 맵을 벗어날 수는 없다.)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();
        int x = sc.nextInt();
        int r = sc.nextInt();

        int[][] map = new int[n + 10][n + 10];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                int nx = x - j;
                int ny = y - i;

                if(nx < 0) {
                    nx *= -1;
                }
                if(ny < 0) {
                    ny *= -1;
                }
                int dist = nx + ny;
                if(dist <= r) {
                    map[i][j] = dist;
                }
            }
        }
        map[y][x] = -1;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(map[i][j] == -1) {
                    System.out.print("x ");
                } else {
                    System.out.printf("%d ", map[i][j]);
                }
            }
            System.out.println("");
        }
    }
}
