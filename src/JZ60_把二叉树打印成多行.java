import java.util.*;

/*
    这里考察的就是二叉树的层次遍历。把思维逻辑理清楚就好了。另外还有一个问题就是Java中的队列的使用。
    我这里用的是ArrayList直接遍历，所以不涉及到先进先出的问题，直解按照下标遍历了。看了下差不多实现的思路都是类似的。
 */

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

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<ArrayList<Integer> >();

        ArrayList<ArrayList<Integer> > ret = new ArrayList<>();
        ArrayList<TreeNode> node = new ArrayList<>();

        node.add(pRoot);
        while (!node.isEmpty())
        {
            ArrayList<TreeNode> next = new ArrayList<>();
            ArrayList<Integer> value = new ArrayList<>();
            for (int i = 0; i < node.size(); i++)
            {
                value.add(node.get(i).val);
                if (node.get(i).left != null) next.add(node.get(i).left);
                if (node.get(i).right != null) next.add(node.get(i).right);
            }

            ret.add(value);
            node = next;
        }

        return ret;
    }

}