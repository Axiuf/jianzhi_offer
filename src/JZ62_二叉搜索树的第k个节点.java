/*
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
    这道题的本质是二叉搜索树的中序遍历。二叉搜索树的中序遍历序列即为一个非递减序列，按顺序取第k个即可。
    传统的中序遍历的方法是递归，要么可以全部递归完存在一个数组中，要么在递归的中途设置断点。
    设置断点的思路是，所有不符合要求的递归程序中，返回值均为null，只要符合第k个了，所有的返回值均为这个节点。
 */

public class Solution {
    private int i = 1;

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot !=  null)
        {
            TreeNode Tl = KthNode(pRoot.left, k);
            if (Tl != null) return Tl;
            if (i == k) return pRoot;
            else i++;
            TreeNode Tr = KthNode(pRoot.right, k);
            if (Tr != null) return Tr;
        }

        return null;
    }
}