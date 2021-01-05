/*
    我这里写的是一种比较通用的方法，当时的第一个思路就是这个，后面只要把逻辑理顺了就没事。
    但是题目给的条件实际上更为简单，使用数组总长度为5且大小王的数量不超过4的trick会使得后面的
    代码更为简单。这里后面还会写一下官方解答的代码。

    这里排序之后也可以使用最小值和最大值的差小于5的方法。
 */

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public boolean isContinuous_1(int [] numbers) {
        if (numbers == null || numbers.length == 0)
            return false;

        Arrays.sort(numbers);
        int king = 0;
        int index = 0;
        while (index < numbers.length && numbers[index] == 0)
        {
            king++;
            index++;
        }
        if (king == numbers.length || (king == numbers.length - 1))
        {
            return true;
        }

        for (int i = index + 1; i < numbers.length; i++)
        {
            while (numbers[i] != (numbers[index] + 1) && king != 0)
            {
                king--;
                numbers[index]++;
            }

            if (numbers[i] == (numbers[index] + 1))
            {
                index++;
            }
            else if (numbers[i] != (numbers[index] + 1) && king == 0)
            {
                break;
            }
        }

        if (index == numbers.length - 1)
            return true;
        else
            return false;
    }


    /*
        这里是官方解题的答案。前面的方法的时间复杂度为NlogN，下面的方法的时间复杂度为N。这里的关键在于，
        要理解符合题设的要求能组成顺子的条件是，首先数组中不能有大于0的重复值。第二个关键的问题是，要满足
        去除了0之后的最大最小值的差要小于5。

        另外还有一点的是，这两个方法的时间复杂度和空间复杂度的差别，下面这种方法的时间复杂度低，但是空间复杂度
        为N。
     */
    public boolean isContinuous_2(int [] numbers) {
        import java.util.HashSet;

        public class Solution {
            public boolean isContinuous(int [] numbers) {
                if (numbers.length == 0)
                    return false;

                HashSet set = new HashSet();
                int min = 14;
                int max = 0;
                for (int i = 0; i < numbers.length; i++)
                {
                    if (numbers[i] > 0 && set.contains(numbers[i]))
                        return false;
                    else if (numbers[i] > 0 && !set.contains(numbers[i]))
                    {
                        set.add(numbers[i]);
                        min = min < numbers[i] ? min : numbers[i];
                        max = max > numbers[i] ? max : numbers[i];
                    }
                }

                if (max - min < 5)
                    return true;
                else
                    return false;

            }
        }
    }
}