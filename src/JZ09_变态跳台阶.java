/*
    这道题是道智力题，或是逻辑推理题，和代码或是数据结构的关系不大。
    最关键的是要理解如何计算跳上第n阶台阶所需要的步数。
    从第0阶到第i阶有f(i)种，然后从第i阶跳一步到第n阶。
    f(n) = f(n-1) + f(n-2) + ... + f(i) + ... + f(2) + f(1) + f(0)
    进一步的，f(n) = 2 * f(n-1)
    再进一步的，f(n) = 2^(n-1)
 */



public class Solution {
    public int JumpFloorII(int target) {
        if (target == 0 || target == 1)
            return 1;
        else
            return (int) Math.pow(2, target - 1);
    }
}