/*
    这道题就是简单的哈希的思想来做的。这里要注意的点是，原来的情况我使用了LinkedHashMap和HashSet，用自带的数据
    结构实现哈希，但是这里处理的是字符串。所以直接用底层ASCII码配合数组就可以了
 */

import java.util.*;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0)
            return -1;
        if (str.length() == 1)
            return 0;

        HashSet duplicated = new HashSet();
        LinkedHashMap single = new LinkedHashMap();

        for (int i = 0; i < str.length(); i++)
        {
            if (duplicated.contains(str.charAt(i)))
                continue;
            else if (single.containsKey(str.charAt(i)))
            {
                single.remove(str.charAt(i));
                duplicated.add(str.charAt(i));
            }
            else
            {
                single.put(str.charAt(i), i);
            }
        }

        Iterator iterator = single.entrySet().iterator();
        if (iterator.hasNext())
            return (int) (((Map.Entry) iterator.next()).getValue());
        else
            return -1;
    }
}

/*
    数组的做法
 */

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        if (str.length() == 1)
            return 0;

        int[] num = new int[128];
        for (int i = 0; i < str.length(); i++)
        {
            num[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++)
        {
            if (num[str.charAt(i)] == 1)
            {
                return i;
            }
        }

        return -1;
    }
}

/*
    这个最巧妙，熟练的运用了String的方法
 */

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.indexOf(str.charAt(i)) == i && str.indexOf(str.charAt(i), i + 1) == -1)
                return i;
        }

        return -1;
    }
}