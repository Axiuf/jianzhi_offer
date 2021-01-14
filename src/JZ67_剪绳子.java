/*
    这道题目稍微复杂一点，我刚开始一点思路也没有，所以这里就按照题解来一步步的做下去。
 */


public class Solution {
    /*
        主函数这里只是单独判断一下边界条件，在n为2或者3的时候单独返回值，其他的扔给递归函数去做。
     */
    public int cutRope(int target) {
        if (target == 2)
            return 1;
        else if(target == 3)
            return 2;

        return back_track(target);
    }

    /*
        这里递归的核心思想是。对于任意一个数n，其分解后最大的乘积和必定是在一下的情况中取最大值：1*f(n-1), 2*f(n-2),
        ..., i*f(n-1), ..., (n-1)*f(1) 这个部分一定要理解透彻

        然后第二个要理解清楚的部分是：这里递归的片段是一个子段，所以他可以不分解，所以递归的边界条件是，如果n小与等于4，
        则原数n为最大乘积。

        这个方法的时间复杂度为n!，空间复杂度为n
     */
    public int back_track(int n)
    {
        if (n <= 4)
            return n;

        int ret = 0;

        for (int i = 1; i < n; i++)
        {
            ret = Math.max(ret, i * back_track(n - i));
        }

        return ret;
    }
}

/*
    这里是上面的解法的改进方法。记忆化递归。考虑到每次递归中有大量的数实际上在重复计算，所以单独开一个数组，记下递归中
    中间值，大大减少了计算时间，时间复杂度度降低为：n^2 (这里可以理解为，每次计算f(i)为一个n，然后对于每个f(i)再乘上一个
    n-i又是一个n，所以时间复杂度为n^2
 */

import java.util.ArrayList;

public class Solution {
    public int cutRope(int target) {
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;

        int[] mark = new int[target + 1];
        return back_track(target, mark);
    }

    public int back_track(int n, int[] mark)
    {
        if (n <= 4)
            return n;

        if (mark[n] != 0)
            return mark[n];

        int ret = 0;
        for (int i = 1; i < n; i++)
        {
            ret = Math.max(ret, i * back_track(n - i, mark));
        }

        mark[n] = ret;
        return ret;
    }
}

/*
    这里是所谓的第三种动态规划的方法，感觉只是把方法二的递归改成了循环而已，其他没啥变化
 */

public class Solution {
    public int cutRope(int target) {
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;

        int[] f = new int[target + 1];

        for (int i = 1; i <= 4; i++)
            f[i] = i;

        for (int i = 5; i <= target; i++)
        {
            for (int j = 1; j < i; j++)
                f[i] = Math.max(f[i], j * f[i - j]);
        }

        return f[target];
    }
}

/*
    另外有一种数学做法，时间和空间的复杂度都是最优解，这个跟我的直觉看起来是一致的。就是把绳子分成最小为3（除去2的
    最小质数）的单元，不足3则补为2或者是4。然后直接计算。这里的数学推导暂且不论。
 */