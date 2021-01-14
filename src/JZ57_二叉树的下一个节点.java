/*
    备注一下：这里的next()指向结点的父节点。
    这里比较直接的但是麻烦的做法是，首先根据给出的结点找到二叉树的根节点，然后利用得到的根节点通过递归的方式得到
    整个二叉树的中序遍历的结果，存在一个ArrayList中，然后遍历整个ArrayList，找到指定结点的下一个节点。

 */


/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/

import java.util.ArrayList;

public class Solution {
    private ArrayList<TreeLinkNode> list = new ArrayList<>();

    public TreeLinkNode GetNext_1(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;

        TreeLinkNode root = pNode;
        while (root.next != null)
            root = root.next;


        getList(root);

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) == pNode)
            {
                return i == list.size() - 1?null:list.get(i + 1);
            }
        }

        return null;
    }

    private void getList(TreeLinkNode root)
    {
        if (root.left != null)
            getList(root.left);

        list.add(root);

        if (root.right != null)
            getList(root.right);
    }

    /*
        这里第二种解法的关键是分情况讨论，要清楚的中序遍历会面临的几种情况。对中序遍历有很深的理解。
        1. 首先，碰到一个节点，要考虑中序遍历的下一个节点，是会把它当做根节点，在它的右子树中去寻找，找到右子树中最左边的
        一个节点，如果没有，则返回右结点。这是第一步要考虑到事情，也是最简单的一个事情。
        2. 然后，这个节点已经没有了右子树，则把它当做子节点，到它的上面，也就是根节点去寻找。那么找到什么时候为止呢，要找到
        一个当前节点为父节点的左子节点的时候，返回这个父节点。
        3. 最后的情况，既没有右子树，父节节点又不满足要求，这种就是最右节点的情况，直接返回空指针即可。
     */

    public TreeLinkNode GetNext_2(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;

        TreeLinkNode ret;

        if (pNode.right != null)
        {
            ret = pNode.right;
            while (ret.left != null)
            {
                ret = ret.left;
            }
            return ret;
        }

        ret = pNode;
        while (ret.next != null)
        {
            if (ret.next.left == ret)
                return ret.next;
            ret = ret.next;
        }

        return null;
    }
}