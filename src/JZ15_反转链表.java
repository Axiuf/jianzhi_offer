/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

/*
    经典的翻转链表的题目，核心在于设置三个指针，分别指向头结点，下一个节点，下下个节点。
    然后就是注意边界问题和循环条件的问题。
    这题没啥好说的，已经完全理解了，后面就是要熟练的写出来就可以。
 */

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode Old = head;
        ListNode New = Old.next;
        Old.next = null;
        ListNode temp;
        while (New != null)
        {
            temp = New.next;
            New.next = Old;
            Old = New;
            New = temp;

        }

        return Old;
    }
}