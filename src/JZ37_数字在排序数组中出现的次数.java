/*
    这题没啥好说的，就是利用二分查找找到数字在数组中的下标，然后往前往后看即可。
    这里考虑一下可以使用Arrays.binarySearch()函数替换手写的二分查找。
 */

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0)
            return 0;
        int left = 0, right = array.length - 1;
        int mid = 0;
        while (left <= right)
        {
            mid = (left + right) / 2;
            if (k > array[mid])
                left = mid + 1;
            else if (k < array[mid])
                right = mid - 1;
            else if (k == array[mid])
                break;
        }

        if (k != array[mid])
            return 0;
        left = mid - 1;
        right = mid + 1;
        int cnt = 1;
        while (left >= 0 && array[left] == k)
        {
            cnt++;
            left -= 1;
        }
        while (right < array.length && array[right] == k)
        {
            cnt++;
            right += 1;
        }

        return cnt;
    }
}