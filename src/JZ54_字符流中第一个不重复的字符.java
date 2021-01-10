/*
    这道题目的思路还是比较清晰的。关键在于java集合的一些方法要使用熟练。
    使用一个HashSet记录所有已经重复的字符。
    使用一个LinkedHashSet记录所有只出现一次的字符，并且记录他们出现的顺序。
 */


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class Solution {
    //Insert one char from stringstream
    private HashSet duplicatedSet = new HashSet();
    private LinkedHashSet singleSet = new LinkedHashSet();


    public void Insert(char ch)
    {
        if (duplicatedSet.contains(ch))
            return;
        else if (singleSet.contains(ch))
        {
            singleSet.remove(ch);
            duplicatedSet.add(ch);
        }
        else
            singleSet.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        Iterator iterator = singleSet.iterator();
        if (iterator.hasNext())
            return (char) iterator.next();
        else
            return '#';
    }
}