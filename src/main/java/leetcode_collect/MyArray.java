package leetcode_collect;

public class MyArray {

    public static void main(String[] args) {

        MyArray ma = new MyArray();
        int i = ma.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(i);
    }

    //在一个排序的数组中，找指定数，没有就插入到指定位置 然后返回索引值
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) {
            nums[0] = target;
        }

        //先把最大和最小比掉
        if (target < nums[0]) {
            nums[0] = target;
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            nums[nums.length - 1] = target;
            return nums.length;
        }


        //存储索引值
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {

            //和target对比
            if (nums[i] == target) {
                return i;
            }

            if (nums[i] > target) {
                temp = i;
                break;
            }
        }

        nums[temp] = target;
        return temp;
    }

    /**
     * 找中心索引就是索引两边的值相加相等
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {

        if (nums.length <= 2) {
            return -1;
        }

        //计算出总和

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //需要计算中心索引公式为，  前 n 个值得和 = （总和 - 索引位的值）/2
        int temp = 0;//记录前n 个值的和

        for (int i = 0; i < nums.length; i++) {
            if ((sum - nums[i]) % 2 != 0) {
                temp += nums[i];
                continue;
            }

            int h = (sum - nums[i]) / 2;
            if (h == temp) {
                return i;
            } else {
                temp += nums[i];
            }
        }
        return -1;

    }


}
