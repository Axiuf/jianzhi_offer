/*
    这道题是课堂上讲过的原题，之前也做过一遍。
    但是这次遇到了还是不会做。这个要多多进行反思才可以。
    基本思想是利用一个栈来模拟整个过程，同时分别设置两个指标来记录压入和弹出序列的下标。
    我这里的思想是压入的序列是可操作的序列，所有以压入序列的下标来标记循环的开始和结束。
    弹出序列是判断流程进行的分支，所以内部判断以弹出序列为主。
    这里要特别注意的一个点是，为什么只有在压入弹出首元素相等的时候，才需要去检查压入的元素和栈顶的元素是否相等。
    之前考虑的一个问题，当我们判断一个弹出序列的数的时候，要不要先去看看他和栈顶的元素是否相等。
    实际上在我们的这个过程中是不用的。根据我们的这个流程设置，压入弹出序列要匹配的话，必定先出现压出弹出序列的顶端
    元素相等，而不会凭空要求弹出一个栈内部的元素。

    还是要多理解栈的数据结构和特性。
 */

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack aStack = new Stack();
        int i = 0;
        int j = 0;
        while (i < pushA.length)
        {
            if (popA[j] == pushA[i])
            {
                i++;
                j++;
                while (!aStack.isEmpty() && popA[j] == (int) aStack.peek())
                {
                    aStack.pop();
                    j++;
                }
            }
            else if (popA[j] != pushA[i])
            {
                aStack.push(pushA[i]);
                i++;
            }
        }
        return aStack.isEmpty();
    }
}