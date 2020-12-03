/*
    这题考概念和递归。
    平衡二叉树的定义，任意节点左右子树的高度差不大于1，并且左右子树均是平衡二叉树。
    这里要注意的是高度和深度的差别和相似之处。深度是从上往下，自身算作1，加上子树较大的深度的一个即可。
    之前做过计算树的深度的题目，递归来写。这里可获得某个子树的深度之后，就按照定义写递归即可。
 */



public class Solution
{
    public int TreeDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root)
    {
        if (root == null)
            return true;
        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
}