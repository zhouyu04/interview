package leetcode_130;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class LeetCode130 {

    public static void main(String[] args) {
        LeetCode130 leetCode130 = new LeetCode130();

        int[] ints = {12};
        //
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}};

        leetCode130.solve(board);


        for (int i = 0; i < board.length; i++) {//遍历高度
            for (int j = 0; j < board[0].length; j++) {//遍历宽度

                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }


    /**
     * 深度优先搜索解法-递归
     * @param board
     */
    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;//获取高度
        int n = board[0].length;//获取宽度

        for (int i = 0; i < m; i++) {//遍历高度
            for (int j = 0; j < n; j++) {//遍历宽度

                boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n - 1;//这是四个边

                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        //替换完之后将#换成O

        for (int i = 0; i < m; i++) {//遍历高度
            for (int j = 0; j < n; j++) {//遍历宽度

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }


    }


    public void dfs(char[][] board, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            //数据不合理
            return;
        }

        if (board[i][j] == 'X' || board[i][j] == '#') {
            //要么不用替换要么已经替换
            return;
        }

        board[i][j] = '#';

        dfs(board, i - 1, j);//上
        dfs(board, i + 1, j);//下
        dfs(board, i, j - 1);//左
        dfs(board, i, j + 1);//右


    }


}
