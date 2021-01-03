/*
    我这里使用的哈希法，直接把所有的数字存在一个HashSet中，然后遍历整个数组，查看可能的的条件是否满足。
 */

import java.util.ArrayList;
import java.util.HashSet;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum_1(int [] array,int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++)
        {
            set.add(array[i]);
        }
        int multi = Integer.MAX_VALUE;
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < array.length; i++)
        {
            if (set.contains(sum - array[i]) && array[i] < (sum - array[i])
                    && (sum - array[i]) * array[i] < multi)
            {
                if (!ret.isEmpty())
                {
                    ret.set(0, array[i]);
                    ret.set(1, sum - array[i]);
                }
                else
                {
                    ret.add(array[i]);
                    ret.add(sum - array[i]);
                }
                multi = (sum - array[i]) * array[i];
            }
        }

        return ret;
    }

    /*
        双指针法，两侧逼近，这题和上面41那道题异曲同工。
     */

    public ArrayList<Integer> FindNumbersWithSum_2(int [] array,int sum) {
        int i = 0;
        int j = array.length - 1;
        ArrayList<Integer> ret = new ArrayList<>();

        while (i < j)
        {
            if (array[i] + array[j] == sum)
            {
                ret.add(array[i]);
                ret.add(array[j]);
                break;
            }
            else if (array[i] + array[j] < sum)
            {
                i++;
            }
            else if (array[i] + array[j] > sum)
            {
                j--;
            }
        }

        return ret;
    }
}