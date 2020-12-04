/*
    连续子列的最大和，数据结构第一课的例子，这个学过很多遍了，所以没什么问题。
    基本思想就是动态规划。
 */

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++)
        {
            sum += array[i];
            if (sum >= max) max = sum;
            if (sum <= 0) sum = 0;
        }
        return max;
    }
}