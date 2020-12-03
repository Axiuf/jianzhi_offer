/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;

/*
    这题考察的是树的遍历的基本知识以及递归
    重点在于树的前序遍历序列的第一元素为树的根节点，中序遍历以根节点为中心，左边为左子树，右边为右子树
    然后是递归算法的安排
    写一个递归算法，分为两部分，一部分是边界处理，这是实际做事的地方，一部分是递归的条件，这里决定了递归的发生
    这题边界处理的部分，要考虑传入的序列为0，则返回null，否则，取前序遍历的首元素放入树的节点内返回
    递归发生的条件问题，存在子树的情况下，依次把左右子树访入递归，返回值赋给左右子树。
    这里注意使用了Arrays.copyOfRange()方法，给出的范围是左闭区间右开区间的。
 */



public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++)
        {
            if (in[i] == pre[0])
            {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1),
                        Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length),
                        Arrays.copyOfRange(in, i+1,in.length));
                break;
            }
        }

        return root;
    }
}