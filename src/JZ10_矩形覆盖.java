/*
    这道题代码和跳台阶那道题是一样的。
    关键在于怎么理解这个递推的公式：f(n) = f(n-1) + f(n-2)
    对于任意2*n的矩阵，可以在2*(n-1)的矩阵右边加上一个竖着的方块即可（为什么不在左边加，因为之前已经考虑到这种对称性了）
    或者在2*(n-2)的矩阵右边加上两个横着的方块也可以。
    由于n为1或者2的情况是特殊的（原子的），所以只用考虑这两个即可。
 */

public class Solution {
    public int RectCover(int target) {
        if (target == 1)
            return 1;
        else if (target == 2)
            return 2;

        int a = 1, b = 2, sum = 0;
        for (int i = 3; i <= target; i++)
        {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;

    }
}