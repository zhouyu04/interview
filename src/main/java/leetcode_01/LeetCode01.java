package leetcode_01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class LeetCode01 {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15, 20};
        int target = 35;
        int[] ints = twoSum(nums, target);
        System.out.println(ints);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> exist = new HashMap();

        for (int i = 0; i < nums.length; i++) {


            if (exist.containsKey(target - nums[i])) {
                return new int[]{exist.get(target - nums[i]), i};
            }
            exist.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
