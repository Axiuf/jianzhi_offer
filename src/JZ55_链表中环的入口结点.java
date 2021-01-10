/*
    这道题目类似智力题？总之要是在面试中第一次见到还真的不一定能做出来。
    基本的思想为双指针法，通过两个指针的步长不一致来找到环的初始节点。
    首先让快指针每次走一步，慢指针每次走两步。在两个第一次相遇的地方停下来（若是链表中没有环的话，两个是不会相遇的）
    此时假设初始点A到环的头结点B距离为X，环头结点距离相遇点C的距离为Y，设慢指针走过的轨迹为ABC路程为X+Y，快指针走过的
    轨迹为ABCBC路程为2（X+Y），可知CB的距离为X
    这时再让快指针重新指向初始节点，并且步速为1，两个指针继续走下去，则相遇的地方为环的头结点。

    这里还有一种思路是哈希法，依次遍历整个链表，将每个节点的地址存储在HashSet中，第一次遇到相同的则返回。
    这里用hashCode()的值代替了地址值。
 */


/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

import java.util.HashSet;

public class Solution {

    public ListNode EntryNodeOfLoop_1(ListNode pHead)
    {
        if (pHead == null)
            return null;

        ListNode n1 = pHead;
        ListNode n2 = pHead;

        while (n1.next != null && n1.next.next != null)
        {
            n1 = n1.next.next;
            n2 = n2.next;

            if (n1 == n2)
            {
                n1 = pHead;
                while (n1 != n2)
                {
                    n1 = n1.next;
                    n2 = n2.next;
                }

                return n1;
            }
        }

        return null;
    }

    public ListNode EntryNodeOfLoop_2(ListNode pHead)
    {
        HashSet set = new HashSet();
        ListNode index = pHead;
        while (index != null)
        {
            if (set.contains(index.hashCode()))
            {
                return index;
            }
            else
            {
                set.add(index.hashCode());
                index = index.next;
            }
        }

        return null;
    }
}