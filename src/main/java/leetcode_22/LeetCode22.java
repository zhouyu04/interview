package leetcode_22;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode22 {


    public static void main(String[] args) {

        LeetCode22 leetCode22 = new LeetCode22();

        List<String> strings = leetCode22.generateParenthesis(3);

        for (String s : strings) {
            System.out.println(s);
        }


    }

    public List<String> generateParenthesis(int n) {

        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {

        if (current.length == pos) {
            //验证
            if (valid(current)) {
                result.add(new String(current));
            }

        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }


    }


    public boolean valid(char[] current) {
        int balance = 0;

        for (char c : current) {

            if (c == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return (balance == 0);
    }

}
