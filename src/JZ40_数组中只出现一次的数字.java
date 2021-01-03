/*
    这道题最直接的做法是哈希，即利用HashSet来判断结合内部元素是否存在，这是个时间复杂度为N的方法。
    唯一的问题是要熟悉Java中集合的使用，这个一定要熟悉，背诵常用的API，知道相关的API所在的包，因为
    牛客网中没有自动补全的功能，需要自己手动的去写。
 */


//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.HashMap;

public class Solution {
    public void FindNumsAppearOnce_1(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++)
        {
            if (map.containsKey(array[i]))
                map.put(array[i], 2);
            else
                map.put(array[i], 1);
        }

        int count = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (map.get(array[i]) == 1)
            {
                if (count == 0)
                {
                    num1[0] = array[i];
                    count = 1;
                }
                else
                {
                    num2[0] = array[i];
                    break;
                }
            }
        }
    }

    /*
        非常巧妙的位运算。这里要深入的理解一下位运算的机制，左移右移等等。
        ^ 异或：任何一个数与自己本身的异或的结果都为0
                任何一个数与0异或的结果都为自己本身
        这样吧数组中所有的数累加异或，相同的两个数都化为了0，剩下的结果是唯二两个不同的数的异或的结果。
        这个结果用二进制的数表示出来，每一位1代表此位两数不一样，每一位0代表此位两数相同。

        & 与运算：用1000...n个0..00与一个数与运算之后，如果还为前个数，则表示两数此位都为1
        用这个方法，判断二进制的两个数某个位上是否相等。
     */

    public void FindNumsAppearOnce_2(int [] array,int num1[] , int num2[])
    {
        public class Solution {
            public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
                int xorRes = 0;
                for (int i = 0; i < array.length; i++)
                {
                    xorRes ^= array[i];
                }

                int mask = 1;
                while ((mask & xorRes) == 0)
                    mask = mask << 1;

                for (int i = 0; i < array.length; i++)
                {
                    if ((mask & array[i]) == mask)
                        num1[0] ^= array[i];
                    else
                        num2[0] ^= array[i];
                }
            }
        }
    }
}