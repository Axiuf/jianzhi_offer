/*
    涉及到的知识主要是位运算和三码问题。这个的基本概念要知道。
    然后解题思路在于：两个数的 和 等于 两个数 按位异或 的结果加上 按位与 的结果（再往左移一位，即进位）
    当 按位与 的结果不为零时，持续的循环。
 */


public class Solution {
    public int Add(int num1,int num2) {
        while (num2 != 0)
        {
            int ans = (num1&num2)<<1;
            num1 ^= num2;
            num2 = ans;
        }
        return num1;
    }
}