/*
    这道题没啥好说的，主要是调用标准库的话就好做很多。
    另外就算要自己手动实现的话，也无非是在指定的索引位置一个个加上去从头构建字符串罢了
 */

public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0)
            return "";
        int digit = n % str.length();
        String res = str.substring(digit) + str.substring(0, digit);
        return res;
    }
}