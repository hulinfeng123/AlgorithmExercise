package BinaryTree;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description 先写出二叉树的基本数据结构
 */
public class TreeNode {
    /*
        二叉树的深度遍历可借助栈实现
        广度优先遍历可利用队列的FIFO
     */
    Object val;
    TreeNode left, right;

    public TreeNode(Object val) {
        if (val instanceof Integer)
        this.val = (Integer)val;
    }

    public TreeNode() {
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}
