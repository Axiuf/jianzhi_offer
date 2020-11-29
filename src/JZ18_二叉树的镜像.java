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
    递归算法，先交换左右子树，然后分别递归调用去交换左右子树的子树。
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}