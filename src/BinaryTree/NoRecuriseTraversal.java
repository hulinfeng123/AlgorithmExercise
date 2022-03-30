package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description 使用非递归的方式实现前中后序遍历，利用数据结构栈
 */
public class NoRecuriseTraversal {
    public List<Object> preorder(TreeNode node) {
        //前序遍历的顺序为中左右，但是入栈的顺序是中右左
        List<Object> result = new ArrayList<>();
        if (node == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            result.add(tempNode.val);
            if (tempNode.right != null)
                stack.push(tempNode.right);
            if (tempNode.left != null)
                stack.push(tempNode.left);
        }
        return result;
    }

    public List<Object> inorder(TreeNode node) {
        //中序遍历与前序遍历不同
        //中序遍历需要先逐层地访问节点，然后再依次将数据加入到数组中
        List<Object> result = new ArrayList<>();
        if (node == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            //不断深入左侧直至为null
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                //为空后首先出栈的是最左子节点，加入数值
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public List<Object> postorderTraversal(TreeNode root) {
        List<Object> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
