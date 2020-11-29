/**
 public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;
     }
 }
 */

/*
    递归算法，树的深度等于左右子树深度较大者加上1。
 */

public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}