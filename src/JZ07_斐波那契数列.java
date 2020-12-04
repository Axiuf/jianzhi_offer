/*
    这题没啥好说的。只是这种解法原来叫做动态规划啊。
    难道不是第一时间直接想到着这种解法吗，为啥解题还有用递归的。
    还有递归的记忆化搜索，是设置一个数组存储中间的计算过程。
    对于要输出所有的斐波那契数列的情况可能有用。
    这种就直接这么写完事了吧。
 */

public class Solution {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;
        int b = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++)
        {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }
}