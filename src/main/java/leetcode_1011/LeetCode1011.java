package leetcode_1011;

import java.util.Arrays;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 */
public class LeetCode1011 {

    public static void main(String[] args) {

        int[] ints = {3,2,2,4,1,4};

        int max = findMax(ints);

        while (greaterThenD(max, ints, 3)) {
            max++;
        }

        System.out.println("最少载重：" + max);
    }


    public static boolean greaterThenD(int maxLoad, int[] weights, int d) {

        int curLoad = maxLoad;
        for (int weight : weights) {

            if (d <= 0) {
                return true;
            }

            curLoad -= weight;

            if (curLoad < 0) {
                curLoad = maxLoad - weight;
                d--;
            }
        }
        return d <= 0;
    }

    public static int findMax(int[] weights) {

        return Arrays.stream(weights).max().orElse(1);
    }


}
