package leetcode_100;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class LeetCode100 {

    public static void main(String[] args) {

        CusTreeNode p = new CusTreeNode(1);
        CusTreeNode q = new CusTreeNode(1);

        p.left = new CusTreeNode(2);
        p.right = new CusTreeNode(3);

        q.left = new CusTreeNode(2);
        q.right = new CusTreeNode(3);

        boolean sameTree = isSameTree(p, q);
        System.out.println(sameTree);
    }


    public static boolean isSameTree(CusTreeNode p, CusTreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (q == null || p == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}


class CusTreeNode {
    int val;
    CusTreeNode left;
    CusTreeNode right;

    public CusTreeNode(int val) {
        this.val = val;
    }
}