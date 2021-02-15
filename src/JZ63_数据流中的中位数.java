/*
    这个题目的关键是理解题目的意思，是在动态变化的数据流中计算中位数，基本上就是在已排序的数组中进行插入删除操作。这种情况下
    考虑时间复杂度一般会使用的结构是最小堆。Java中的最小堆有内置的库是优先队列：PriorityQueue，给它传递一个自定义的Comparator可以
    实现最大堆。

    然后具体到这一题的情况，基本上就是要找到数据流中中间位置的数。这里考虑把整个排序好的数列分为两部分，左半部分用最大堆维护，
    右半部分用最小堆维护，当总的数量为偶数的时候，从两个堆的堆顶取数然后求均值即可。当数量为奇数的时候，默认把中位数放在左边的最大堆里
    从最大堆里面取出堆顶的数即可。
 */



import java.util.*;

public class Solution {

    private int cnt = 0;
    private PriorityQueue<Integer> low = new PriorityQueue<>();
    private PriorityQueue<Integer> high = new PriorityQueue<>(new Comparator<Integer>()
    {
        public int compare(Integer o1, Integer o2)
        {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        cnt++;

        if ((cnt & 1) == 1)
        {
            if (!low.isEmpty() && num > low.peek())
            {
                low.offer(num);
                num = low.poll();
            }
            high.offer(num);
        }
        else
        {
            if (!high.isEmpty() && num < high.peek())
            {
                high.offer(num);
                num = high.poll();
            }
            low.offer(num);
        }
    }

    public Double GetMedian() {
        double res = 0;
        if ((cnt & 1) == 1)
        {
            res = high.peek();
        }
        else
        {
            res = (high.peek() + low.peek()) / 2.0;
        }

        return res;
    }


}