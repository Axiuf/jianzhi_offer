/*
    这是一个简单的约瑟夫环的问题，最简单直接的方法是用链表来模拟整个游戏的过程，剩下的那个节点的值就是要求的答案。
    但是这样做的时间复杂度是N^2。空间复杂度为N。实际上并不是最优的解。

    要实现最优解，就要理解后面的内在的规律。也就是约瑟夫环的递推公式：f(n, m) = (f(n-1) + m) % n。
    理解的关键在于，在有n个数的时候，和剩下n-1个数的时候，结果的互相映射。
 */

import java.util.ArrayList;

public class Solution {
    public int LastRemaining_Solution_1(int n, int m) {
        if (n == 0)
            return -1;

        ArrayList list = new ArrayList();
        for (int i = 0; i < n; i++)
            list.add(i);

        int startIndex = 0;
        while (list.size() > 1)
        {
            int target = (startIndex + m - 1) % list.size();
            list.remove(target);
            startIndex = target % list.size();
        }

        return (int) list.get(0);
    }

    /*
    递归的做法。
     */
    public int LastRemaining_Solution_2(int n, int m) {
        if (n == 0)
            return -1;
        if (n == 1)
            return 0;
        return (LastRemaining_Solution(n-1, m) + m) % n;
    }

    /*
    思想和递归是一样的，采用迭代的方法，降低了空间复杂度。
     */
    public int LastRemaining_Solution_3(int n, int m) {
        if (n == 0)
            return -1;

        int index = 0;
        for (int i = 2; i <= n; i++)
        {
            index = (index + m) % i;
        }

        return index;
    }
}