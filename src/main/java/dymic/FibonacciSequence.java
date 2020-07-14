package dymic;

/**
 * 斐波那契数列
 * 用动态规划解
 */
public class FibonacciSequence {


    public static void main(String[] args) {
        int res = getRes(18);
        System.out.println(res);
    }

    //传一个N，需要解出f(N)的值
    public static int getRes(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int pre = 1;
        int cur = 1;
        for (int i = 3; i <= n; i++) {

            int sum = pre + cur;

            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
