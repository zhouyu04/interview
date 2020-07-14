package leetcode_1118;

/**
 * 指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
 * <p>
 * 闰年是公历中的名词。闰年分为普通闰年和世纪闰年，闰年的定义：
 * <p>
 * 普通闰年：公历年份是 4 的倍数，且不是 100 的倍数的，为闰年（如 2004 年就是闰年）。
 * <p>
 * 世纪闰年：公历年份是整百数的，必须是 400 的倍数才是世纪闰年（如 1900 年不是世纪闰年，2000 年是世纪闰年）。
 */
public class LeetCode1118 {

    public static void main(String[] args) {

        int day = getDay(1900, 2);
        System.out.println(day);
    }


    public static int getDay(int year, int month) {

        int[] y1 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//闰年
        int[] y2 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //重点其实是判断闰年
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return y1[month - 1];
        } else {
            return y2[month - 1];
        }
    }


}
