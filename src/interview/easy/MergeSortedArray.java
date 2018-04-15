package interview.easy;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // move backward
        for (int i = m - 1; i >= 0; i--) {
            nums1[n + i] = nums1[i];
        }

        int i = n;
        int j = 0;
        int k = 0;
        while (j < n && i < m + n) {
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums1[i];
                k++;
                i++;
            } else {
                nums1[k] = nums2[j];
                k++;
                j++;
            }
        }

        while (j < n) {
            nums1[k] = nums2[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{
                1, 2, 3, 4, 0, 0
        };
        new MergeSortedArray().merge(ints, 4, new int[]{5, 6}, 2);
        System.out.println(Arrays.toString(ints));

        ints = new int[]{
                1, 2, 3, 4, 0, 0, 0, 0, 0
        };
        new MergeSortedArray().merge(ints, 4, new int[]{5, 6, 7, 8, 9}, 5);
        System.out.println(Arrays.toString(ints));
    }
}
