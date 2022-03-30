package BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description
 */
public class BinaryTree {
    List<TreeNode> treeList;

    public List<TreeNode> createTree(Object[] treedata) {
        treeList = new ArrayList<>();

        //依次将数据入组
        for (int i = 0; i < treedata.length; i++) {
            treeList.add(new TreeNode(treedata[i]));
        }

        //给入组的数据建立父子左右关系
        for (int currNode = 0; currNode < treedata.length/2-1; currNode++) {
            //建立左子树
            treeList.get(currNode).left = treeList.get(currNode*2+1);
            //建立右子树
            treeList.get(currNode).right = treeList.get(currNode*2+2);
        }
        //二叉树的最后一个节点可能没有右孩子需要判断一下

        //获取最后一个父节点
        int parentNodeIndex = treedata.length/2 - 1;
        //如果节点个数是奇数则最后节点有右孩子
        if(treedata.length%2==1){
            treeList.get(parentNodeIndex).right = treeList.get(parentNodeIndex*2+2);
        }
        treeList.get(parentNodeIndex).left = treeList.get(parentNodeIndex*2+1);
        return treeList;
    }




    //前序遍历
    public List<Object> preorderTraversal(TreeNode baseNode){
        List<Object> result = new ArrayList<>();
        preorder(baseNode,result);
        return result;
    }
    public void preorder(TreeNode node,List<Object>result){
        if(node==null)return;
        result.add(node.val);
        preorder(node.left,result);
        preorder(node.right,result);
    }

    //中序遍历
    public List<Object> inorderTraversal(TreeNode baseNode){
        List<Object> result = new ArrayList<>();
        inorder(baseNode,result);
        return result;
    }
    public void inorder(TreeNode node,List<Object>result){
        if(node==null)return;
        inorder(node.left,result);
        result.add(node.val);
        inorder(node.right,result);
    }

    //后序遍历
    public List<Object> postorderTraversal(TreeNode baseNode){
        List<Object> result = new ArrayList<>();
        postorder(baseNode,result);
        return result;
    }
    public void postorder(TreeNode node,List<Object>result){
        if(node==null)return;
        postorder(node.left,result);
        postorder(node.right,result);
        result.add(node.val);
    }


    public static void main(String[] args) {
        Object[] data = new Object[]{1,3,1,63,75};
        BinaryTree bTree = new BinaryTree();
        bTree.createTree(data);
        List<Object> preorder = bTree.preorderTraversal(bTree.treeList.get(0));
        List<Object> inorder = bTree.inorderTraversal(bTree.treeList.get(0));
        List<Object> postorder = bTree.postorderTraversal(bTree.treeList.get(0));

        System.out.println(preorder.get(0));
        System.out.println(inorder);
        System.out.println(postorder);
        System.out.println(bTree.treeList.get(0).val);
    }


}