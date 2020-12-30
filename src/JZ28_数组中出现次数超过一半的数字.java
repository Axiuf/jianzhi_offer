/*
    这题我首先的思路是，调用API对数组进行排序，获得一个从小到大的序列。然后从左往右对数组进行扫描，计算连续相等的数字的
    个数，如果存在个数大于总数一半的数字，即找到了题目想要的结果。问题在于排序是调用了API的，Java排序的底层算法应该是快
    速排序，快速排序的时间复杂度为NlogN，并不是最优的结果。

    另外数组进行排序之后，其实更简单的方法是，如果存在众数，则中位数一定是众数。只需要简单的判断一下中位数的个数是否大于
    总数的一半就可以了。
 */

import java.util.Arrays;

public class Solution {
    public int MoreThanHalfNum_Solution_1(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];

        Arrays.sort(array);
        int i = 0, j = 1;
        int sum = 1;
        while (j < array.length)
        {
            if (array[j] == array[i])
            {
                sum++;
                if (sum >= (array.length / 2 + 1))
                    return array[i];
            }
            else
            {
                i = j;
                sum = 1;
            }
            j++;
        }

        return 0;
    }

    /*
        这里这道题的思路是，遍历数组，两个不等则消去，如果存在众数，则最后剩下来的一定是众数。只要检验一下最后的数的个数就
        可以了。这里的思路理解起来不难，重点是如何去实现两个数不等则消去的具体代码。参考的实现是，从头遍历数组，每次比较相
        邻的两个。设第一个为候选众数，如果第二个数与其相等，其个数+1，如果第二个数与其不等，则个数—1，个数为0则全部重置。
     */
    public int MoreThanHalfNum_Solution_2(int [] array)
    {
        int cond = -1;
        int cnt = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (cnt == 0)
            {
                cond = array[i];
                cnt++;
            }
            else
            {
                if (cond == array[i])
                {
                    cnt++;
                }
                else
                {
                    cnt--;
                }
            }
        }

        cnt = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == cond)
            {
                cnt++;
            }
        }
        if (cnt > array.length / 2)
        {
            return cond;
        }
        else
        {
            return 0;
        }
    }
