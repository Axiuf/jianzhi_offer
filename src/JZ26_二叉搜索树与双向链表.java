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
    这道题有点意思。给定一个二叉搜索树的根节点，要转化为一个非递减的双向链表。
    其实思路也是有的，但是一开始并不是很清晰。首先，从一棵二叉搜索树想得到一个非递减的序列，
    很自然的会想到用递归的中序遍历方法来写。那么怎么从一个非递减的序列变成一个双向链表呢？
    对于一个二叉搜索树来讲，每个节点的左节点指向原左子树的最右结点，右结点指向原右子树的最左节点即可。
    本题的基本思路就是这样。想清楚了思路再去写的话就会快很多，效率也比较高。
 */


public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        Traversal(pRootOfTree);
        return findLeft(pRootOfTree);
    }

    void Traversal(TreeNode pRootOfTree)
    {
        if (pRootOfTree == null) return;
        Traversal(pRootOfTree.left);
        pRootOfTree.left = findRight(pRootOfTree.left);
        if (pRootOfTree.left != null) pRootOfTree.left.right = pRootOfTree;
        Traversal(pRootOfTree.right);
        pRootOfTree.right = findLeft(pRootOfTree.right);
        if (pRootOfTree.right != null) pRootOfTree.right.left = pRootOfTree;
        return;
    }

    TreeNode findRight(TreeNode node)
    {
        while (node != null && node.right != null)
            node = node.right;
        return node;
    }

    TreeNode findLeft(TreeNode node)
    {
        while (node != null && node.left != null)
            node = node.left;
        return node;
    }
}