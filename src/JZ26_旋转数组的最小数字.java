import java.util.ArrayList;
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