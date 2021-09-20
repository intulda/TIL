package bruteForce;

import java.util.Scanner;

public class Rook {
    /**
     * Q: 체스에서 룩이라는 기물은 막혀있지만 않으면 룩의 위치에서 같은 행, 같은 열에 해당하는 칸 중 하나로 한 번 이동할 수 있다. 단, 특정 칸이 막혀있다면 그 칸에서부터 더 나아갈 수는 없다. 만약 룩이 아래 그림과 같이 5행 4열에 존재하고 같은 행열에 기물이 없다면 5행이나 4열에 존재하는 칸 중 어디로든 갈 수 있다. 예를 들어, 5행 2열 혹은 1행 4열로 움직일 수 있다. 차례에 주어진 이동 횟수는 한 번이므로 이동이 완료되었다면 상대방의 차례로 넘어간다.
     * 체스는 킹만 잡히면 지게 되는 게임이다. 그 중에서도 알랩이는 룩으로 인해 게임을 지는 것을 극도로 싫어한다!
     * 주어진 체스판의 상태에서 현재 차례가 상대의 차례일 때, 이번 차례에 알랩이의 킹이 상대방의 룩에게 잡힐 가능성이 있는지 알아보자.
     * I: 8줄에 걸쳐 8x8 체스판의 상태가 주어진다. 이때 0은 기물이 없는 상태이고, 1은 알랩이의 킹을 의미하고, 2는 상대의 룩을 의미하며 3은 그 외 다른 기물들을 의미한다. (킹은 하나만 존재하며, 상대의 룩은 최대 2개까지 있을 수 있다. 그 외 기물들은 최대 29개까지 있을 수 있다.)
     * O: 킹이 룩에게 잡힐 가능성이 있으면 1, 아니면 0을 출력한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 8;
        int[] kingX = new int[2];
        int[] kingY = new int[2];
        int[][] arr = new int[size + 10][size + 10];
        int kingCnt = 0;

        for(int i=1; i<=size; i++) {
            for(int j=1; j<=size; j++) {
                int num = sc.nextInt();
                arr[i][j] = num;
                if(num == 2) {
                    kingX[kingCnt] = j;
                    kingY[kingCnt] = i;
                    kingCnt++;
                }
            }
        }

        //배열밖 장애물 설치
        for(int i = 0; i <= size + 1; i++) {
            arr[i][size + 1] = 3;
            arr[i][0] = 3;
            arr[0][i] = 3;
            arr[size + 1][i] = 3;
        }

        boolean check = false;

        for(int i=0; i<kingCnt; i++) {
            //위
            for(int j=kingY[i]; j>=0; j--) {
                if(arr[j][kingX[i]] == 1) {
                    check = true;
                } else if(arr[j][kingX[i]] == 3) {
                    break;
                }
            }

            //왼쪽
            for(int j=kingX[i]; j>=0; j--) {
                if(arr[kingY[i]][j] == 1) {
                    check = true;
                } else if(arr[kingY[i]][j] == 3) {
                    break;
                }
            }

            //아래
            for(int j=kingY[i]; j<=size; j++) {
                if(arr[j][kingX[i]] == 1) {
                    check = true;
                } else if(arr[j][kingX[i]] == 3) {
                    break;
                }
            }

            //오른쪽
            for(int j=kingX[i]; j<=size; j++) {
                if(arr[kingY[i]][j] == 1) {
                    check = true;
                } else if(arr[kingY[i]][j] == 3) {
                    break;
                }
            }

        }
        if(check) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
