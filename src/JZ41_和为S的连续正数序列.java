/*
    这道题目的思路只有一句话，滑动窗口。
    点破了这一点之后，后面的编程部分很很简单。
    要特别注意的是滑动窗口的起始值是什么，循环体中的部分是什么，循环结束的条件是什么。
 */


import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int i = 1;
        int j = 1;
        int tmp = 0;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        while (i <= (sum / 2))
        {
            if (tmp < sum)
            {
                tmp += j;
                j++;
            }
            else if (tmp > sum)
            {
                tmp -= i;
                i++;
            }
            else if (tmp == sum)
            {
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = i; k < j; k++)
                {
                    list.add(k);
                }
                ret.add(list);
                tmp -= i;
                i++;
            }
        }

        return ret;
    }
}