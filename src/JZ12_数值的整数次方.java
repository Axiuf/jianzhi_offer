/*
    这题要考察的是对指数计数的概念运用，不能使用库函数Math.pow()
    考虑到一些边界的情况，比如说指数是负数怎么办。那么首先把底数取倒数，然后把指数取相反数就可以了。
    然后有三种解法：首先是暴力解法，直接循环相乘，但是这种解法的时间复杂度太高。
    接着是采用递归的方法（即快速幂），考虑到x的n次方等于x的n/2次方的平法，大大减少了累乘的次数。相当于二分了。
    时间复杂度没问题，但是考虑到递归，所以空间复杂度较高。
    最后是取技巧的方法，即利用位运算，把指数化为2进制的多项式形式，利用位运算判断是否乘入。同时设计一个x算子存储对应
    位的累乘因子。具体实现看代码即可理解。
 */

public class Solution {
    public double Power(double base, int exponent) {
        if (exponent < 0)
        {
            base = 1 / base;
            exponent = - exponent;
        }

        double res = 1.0;
        double x = base;
        while (exponent != 0)
        {
            if ((exponent&1) == 1)
            {
                res *= x;
            }
            x *= x;
            exponent = exponent >> 1;
        }

        return res;
    }
}