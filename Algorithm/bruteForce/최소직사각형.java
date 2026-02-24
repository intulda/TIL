package bruteForce;

public class 최소직사각형 {
    public static void main(String[] args) {
        System.out.println(
                solution(new int[][]{
                        {60, 50},
                        {30, 70},
                        {60, 30},
                        {80, 40}
                })
        );
    }

    static int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];
            int temp = 0;

            if (width < height) {
                temp = width;
                width = height;
                height = temp;
            }

            if (maxWidth < width) {
                maxWidth = width;
            }

            if(maxHeight < height) {
                maxHeight = height;
            }
        }

        return maxWidth * maxHeight;
    }
}
