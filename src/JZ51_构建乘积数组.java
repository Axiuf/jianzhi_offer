import java.util.ArrayList;

/*
    构建乘积数组这道题最主要的算法思想是B[i] = B[i-1] * B[i+1]，把乘积分为两部分分别去求积。
    而每部分都是一个累乘的过程，这样就实现了中间乘积的重用。
    第一次循环先求左边，中间结果可以直接放在结果数组中。
    第二次循环求右边，中间结果放在temp临时变量当中。特别注意临界值。
 */

public class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];

        B[0] = 1;
        for (int i = 1; i < B.length; i++)
        {
            B[i] = B[i - 1] * A[i - 1];
        }

        int temp = 1;
        for (int i = B.length - 2; i >= 0; i--)
        {
            temp = temp * A[i + 1];
            B[i] = B[i] * temp;
        }

        return B;
    }
}