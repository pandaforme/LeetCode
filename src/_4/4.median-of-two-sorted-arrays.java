package _4;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;

        // k means index, but we need to its order
        // for example: num => 2, 4, 5, 7, 9
        // k = 2, num[k] = 5, but 5 is third number in num
        // k + 1 means its order
        int k = l / 2;
        if (l % 2 == 1) {
            return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k + 1);
        } else {
            int k1 = findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k + 1);
            int k2 = findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k);
            return (k1 + k2) / 2.0;
        }
    }

    private int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        if (start1 > end1)
            return nums2[start2 + k - 1];
        if (start2 > end2)
            return nums1[start1 + k - 1];

        int middle1 = start1 + (end1 - start1) / 2;
        int middle2 = start2 + (end2 - start2) / 2;

        if (nums1[middle1] <= nums2[middle2]) {
            // the #elements smaller or equal nums1[middle1] are middle1 - start1 + 1
            // the #elements smaller than nums2[middle2] are (middle2  - start2 + 1 - 1) = middle2  - start2
            // so the #elements smaller than nums2[middle1] are middle1 - start1 + middle2 - start2 + 1
            if (k <= (middle1 - start1 + middle2 - start2 + 1))
                // so eliminate impossible part: nums2[middle2] ~ nums2[end2]
                return findKth(nums1, start1, end1, nums2, start2, middle2 - 1, k);
            else {
                // k > middle1 + middle2 + 1
                // so eliminate impossible part: nums1[start1] ~ nums1[middle1]
                return findKth(nums1, middle1 + 1, end1, nums2, start2, end2, k - (middle1 - start1) - 1);
            }
        } else {
            if (k <= (middle1 - start1 + middle2 - start2 + 1))
                return findKth(nums1, start1, middle1 - 1, nums2, start2, end2, k);
            else {
                return findKth(nums1, start1, end1, nums2, middle2 + 1, end2, k - (middle2 - start2) - 1);
            }
        }
    }

    // better version of brute force solution
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int l = nums1.length + nums2.length;
//
//        Integer k1 = null;
//        Integer k2 = null;
//        if (l % 2 == 1) {
//            k1 = (l / 2) + 1;
//        } else {
//            k1 = (l / 2) + 1;
//            k2 = l / 2;
//        }
//        int i = 0;
//        int j = 0;
//        int count = 0;
//        int currentEmlemt;
//        int k1Element = 0;
//        int k2Element = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] < nums2[j]) {
//                currentEmlemt = nums1[i];
//                i++;
//            } else {
//                currentEmlemt = nums2[j];
//                j++;
//            }
//
//            count++;
//            if (k2 == null && count == k1)
//                return currentEmlemt;
//            if (k2 != null && count == k2)
//                k2Element = currentEmlemt;
//            else if (k2 != null && count == k1)
//                k1Element = currentEmlemt;
//        }
//
//        if (i >= nums1.length) {
//            while (j < nums2.length) {
//                currentEmlemt = nums2[j];
//                j++;
//                count++;
//                if (k2 == null && count == k1)
//                    return currentEmlemt;
//                if (k2 != null && count == k2)
//                    k2Element = currentEmlemt;
//                else if (k2 != null && count == k1)
//                    k1Element = currentEmlemt;
//            }
//        } else {
//            while (i < nums1.length) {
//                currentEmlemt = nums1[i];
//                i++;
//                count++;
//                if (k2 == null && count == k1)
//                    return currentEmlemt;
//                if (k2 != null && count == k2)
//                    k2Element = currentEmlemt;
//                else if (k2 != null && count == k1)
//                    k1Element = currentEmlemt;
//            }
//        }
//
//        return (k1Element + k2Element) / 2.0;
//    }

    // brute force
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] num = new int[nums1.length + nums2.length];
//
//        int i = 0;
//        int j = 0;
//        int x = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] < nums2[j]) {
//                num[x] = nums1[i];
//                i++;
//            } else {
//                num[x] = nums2[j];
//                j++;
//            }
//            x++;
//        }
//
//        if (i >= nums1.length) {
//            while (j < nums2.length) {
//                num[x] = nums2[j];
//                j++;
//                x++;
//            }
//        } else {
//            while (i < nums1.length) {
//                num[x] = nums1[i];
//                i++;
//                x++;
//            }
//        }
//
//        if (num.length % 2 == 1) {
//            return num[num.length / 2];
//        } else {
//            return (num[num.length / 2] + num[(num.length / 2) - 1]) / 2.0;
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }

}
