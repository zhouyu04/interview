package dymic;

/**
 * 凑零钱动态规划解法；
 * 给k种面值的硬币，面值分别为c1,c2,c3...,每种硬币无限,最小面值为一块
 * 再给出一个金额amount，问最少需要多少硬币组合出来
 */
public class CoinAmount {

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        CoinAmount ca = new CoinAmount();
        int i = ca.coinChange(coins, 11);

        System.out.println(i);

    }


    //传入一个硬币的数组和一个金额amount得出一个最小的值
    public int coinChange(int[] coins, int amount) {

        //定义一个很大的数
        int res = Integer.MAX_VALUE;

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        //内层遍历硬币组
        for (int coin : coins) {
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }

        return res;
    }


}
