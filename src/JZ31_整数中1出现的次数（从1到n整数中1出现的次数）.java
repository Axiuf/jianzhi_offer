/*
    这道题还是很考验找规律的能力的。自己首先的想法是把数字转换为字符串，然后遍历每个数字，找到其中1的个数然后累加即可。
    但是这样的话时间复杂度几乎是n^2（两次遍历）。
    然后实际的解法非常巧妙，是找规律的（我一开始也是找规律，但是头有点大就放弃了）。诀窍在于理解密码锁。
    把数字每个位上1可能出现的次数相加起来，即为最后的结果。这里分为了3种情况，当前为0，1，或者其他的时候，思维方式就是
    把这个位数固定，其他的位数有多少可能的组合。要仔细理解理解了。
 */

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int digit = 1;
        int cnt = 0;

        while (high != 0 || cur != 0)
        {
            if (cur == 0)
                cnt += high * digit;
            else if (cur == 1)
                cnt += high * digit + low + 1;
            else
                cnt += (high + 1) * digit;

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }

        return cnt;
    }
}