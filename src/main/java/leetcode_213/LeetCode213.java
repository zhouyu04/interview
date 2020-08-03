package leetcode_213;

import java.util.Arrays;

public class LeetCode213 {

    public static void main(String[] args) {
        LeetCode213 leetCode213 = new LeetCode213();

        int[] nums = {1, 2, 3, 1};

        int rob = leetCode213.rob(nums);
        System.out.println(rob);

    }

    public int rob(int[] nums) {

        //从头到lenth-1
        int[] ints = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] ints2 = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(myRob(ints), myRob(ints2));


    }

    public static int myRob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

}
