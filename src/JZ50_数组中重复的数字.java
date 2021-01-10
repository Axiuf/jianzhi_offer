/*
    这道题目第一反应使用的是哈希法，没什么问题。
    然后有一种特别的方案，不是完全切合题意，但是仍然可以学习。
    从下标为0的数字开始扫描，要求每个数字都对应到自己的下标的位置，如果不是，则与其应该在的位置的数字交换，每次这样循环下去，
    则也能找到重复的数字。
 */

import java.util.HashSet;

public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        HashSet set = new HashSet();
        for (int i = 0; i < length; i++)
        {
            if (set.contains(numbers[i]))
            {
                duplication[0] = numbers[i];
                return true;
            }
            else
            {
                set.add(numbers[i]);
            }
        }

        return false;
    }
}