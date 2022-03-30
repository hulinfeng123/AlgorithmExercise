package BinaryTree;

import java.util.*;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description 层序遍历遍历二叉树
 */
public class BFS {

    List<List<Object>> result = new ArrayList<>();

    public List<List<Object>> levelOrder(TreeNode root){

        //checkFun01(root,0);
        QueToBFS(root);
        System.out.println("test");
        System.out.println("master");


        return result;
    }


    //DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        if (result.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Object> item = new ArrayList<>();
            result.add(item);
        }
        result.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    //队列实现
    public List<List<TreeNode>> QueToBFS(TreeNode root){
        List<List<TreeNode>> result = null;
        if(root==null)return null;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        while(!temp.isEmpty()){
            List<TreeNode> tempResult = new LinkedList<>();
            int size = temp.size();
            while(size>0) {
                TreeNode tempNode = temp.poll();
                tempResult.add(tempNode);
                if(tempNode.left!=null)
                    temp.offer(tempNode.left);
                if(tempNode.right!=null)
                    temp.offer(tempNode.right);
                size--;
            }
            result.add(tempResult);

        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree testTree = new BinaryTree();
        List<TreeNode> tree1 =
                testTree.createTree(new Object[]{3,4,2,null,72,6,1,null,24,1});
        List<Object> tree2 = new ArrayList<>();
        for (int i = 0; i < tree1.size(); i++) {
            tree2.add(tree1.get(i).val);
        }
        BFS bfs = new BFS();
        List<List<Object>> result = bfs.levelOrder(tree1.get(0));
        System.out.println(result);
    }
}

