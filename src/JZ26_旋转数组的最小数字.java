import java.util.ArrayList;

/*
    二分法：查找数组中的逆序对，类似于数组查找。每次中值要比较的不是目标值，而是端点值。
    由于是往右旋转，比较右端点值才有意义。每次比较之后减小区间。
    重点注意的是原数组为非递减数组，所以会出现中值和端点值相等，这时候右端点减1，往中间慢慢靠拢。
 */

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return 0;
        return findMin(array, 0, array.length-1);
    }

    public int findMin(int [] array, int left, int right)
    {
        if (left == right)
        {
            return array[left];
        }

        int mid = (left + right) / 2;

        if (array[mid] < array[right])
        {
            return findMin(array, left, mid);
        }
        else if (array[mid] > array[right])
        {
            return findMin(array, mid+1, right);
        }
        else if (array[mid] == array[right])
            {
                return findMin(array, left, right-1);
            }

        return 0;
    }
}