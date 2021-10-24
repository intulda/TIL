package function;

public class 셀프넘버 {

    static final int SIZE = 10_000;
    static boolean[] check;
    public static void main(String[] args) {
        check = new boolean[SIZE + 10];
        for (int i = 1; i < SIZE; i++) {
            int selfNumber = getSelfNumber(i);

            if (selfNumber < SIZE) {
                check[selfNumber] = true;
            }
        }

        for (int i = 1; i <= SIZE; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }

    static int getSelfNumber(int x) {
        int result = x;
        while (x != 0) {
            result += (x % 10);
            x /= 10;
        }
        return result;
    }
}
