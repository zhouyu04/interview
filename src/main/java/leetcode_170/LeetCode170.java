package leetcode_170;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。
 * <p>
 * add 操作 -  对内部数据结构增加一个数。
 * find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。
 */
public class LeetCode170 {

    private List<Integer> nums;
    private boolean is_sorted;

    /**
     * Initialize your data structure here.
     */
    public LeetCode170() {
        nums = new ArrayList<>();
        is_sorted = false;
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        nums.add(number);
        this.is_sorted = false;
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {

        if (!is_sorted) {
            Collections.sort(nums);
        }

        int low = 0;
        int high = this.nums.size() - 1;

        while (low < high) {

            int twosum = nums.get(low) + nums.get(high);

            if (twosum < value) {
                low++;
            } else if (twosum > value) {
                high--;
            } else {
                return true;
            }
        }
        return false;
    }

}
