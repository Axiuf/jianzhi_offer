/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

/*
    这题没什么好说的，就是考察基本的链表结构的熟练运用。
    值得一提是，这道题可以用递归的方法来写，虽然时间复杂度一样，空间复杂度反而更差了，但是可以锻炼对
    递归算法的熟练程度和思想。
    两个问题1.递归结束的条件，2.边界值的处理。
 */

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null)
        {
            return list2;
        }
        if (list2 == null)
        {
            return list1;
        }

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode newHead, newRear;

        if (head1.val <= head2.val)
        {
            newHead = head1;
            head1 = head1.next;
        }
        else
        {
            newHead = head2;
            head2 = head2.next;
        }
        newRear = newHead;
        while (head1 != null && head2 != null)
        {
            if (head1.val <= head2.val)
            {
                newRear.next = head1;
                newRear = newRear.next;
                head1 = head1.next;
            }
            else
            {
                newRear.next = head2;
                newRear = newRear.next;
                head2 = head2.next;
            }
        }
        if (head1 != null) newRear.next = head1;
        if (head2 != null) newRear.next = head2;

        return newHead;
    }
}