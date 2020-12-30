/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

/*
    这题的基本思路还是双指针移动然后比较。首先想到这个并不难，但是很快发现两个链表的长度不等时，会互相错过。之前想到的方
    案是对两个链表分别遍历一一比较，一看就很蠢的暴力解法。实际的最优解是，两个链表相加长度就会相等，那么如何使长度相加呢，
    只要在第一链表遍历完之后，换到另一个去遍历就可以了。
 */

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode h1 = pHead1;
        ListNode h2 = pHead2;

        while (h1 != h2)
        {
            h1 = h1.next;
            h2 = h2.next;

            if (h1 != h2) // 总的循环只会遍历两次链表，如果没有公共结点，最终两个指针会在null处停下来
            {
                if (h1 == null)
                    h1 = pHead2;
                if (h2 == null)
                    h2 = pHead1;
            }
        }

        return h1;

    }
}