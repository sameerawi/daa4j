package Sorting;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort
{
    public int [] quickSort(int [] arr)
    {
        sort(arr, 0, arr.length-1);

        return arr;
    }

    public void sort(int [] arr, int l, int h)
    {
        if (l>=h)
            return;

        int pivot = l, i = l, j = h;

        do
        {
            if (arr[i] <= arr[pivot])
            {
                i++;
                continue;
            }

            if (arr[j] >= arr[pivot])
            {
                j--;
                continue;
            }

            // swap sides
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        } while(i <= j);

        // swap pivot
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;

        // partition
        sort(arr, l, j-1); // left
        sort(arr,j+1, h); // right
    }

    @Test
    public void test()
    {
        assert (Arrays.equals( new int[] {3,5,6,8,9,10,12,15,16} , quickSort(new int[] {10,16,8,12,15,6,3,9,5})));
        assert (Arrays.equals( new int[] {1} , quickSort(new int[] {1})));
        assert (Arrays.equals( new int[] {1,2} , quickSort(new int[] {2,1})));
        assert (Arrays.equals( new int[] {-5,-2, 0, 1, 5} , quickSort(new int[] {5,0,1,-2,-5})));
    }
}
