package leetcode_204;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class LeetCode204 {


    public static void main(String[] args) {
        LeetCode204 leetCode204 = new LeetCode204();
        int i = leetCode204.countPrimes(10);
        System.out.println(i);
    }

    public int countPrimes(int n) {

        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++) {

            if (isPrim[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {

            if (isPrim[i]) {
                count++;
            }
        }

        return count;
    }


}
