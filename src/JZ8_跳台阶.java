/*
    这道题和那道变态跳台阶的题目是一样。
    最重要的是理解题目f(n) = f(n-1) + f(n-2)
    理解这个就好做，最简单的是递归，但是时间复杂度达到了O(2^n)
    考虑使用动态规划优化时间复杂度和空间复杂度。
 */


public class Solution {
    public int JumpFloor(int target) {
        int a = 1, b = 1;
        int sum = b;
        if (target == 0 || target == 1)
            return sum;
        for (int i = 2; i <= target; i++)
        {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }
}