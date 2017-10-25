//class Solution {
////    public int findKthLargest(int[] nums, int k) {
////        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
////
////        for (int num : nums) {
////            queue.offer(num);
////        }
////
////        int result = 0;
////        while (k != 0) {
////            if (queue.isEmpty())
////                return -1;
////
////            result = queue.poll();
////            k--;
////        }
////
////        return result;
////    }
//
//    public int findKthLargest(int[] nums, int k) {
//        return find(nums, nums.length - k, 0, nums.length - 1);
//    }
//
//    private int find(int[] nums, int k, int start, int end) {
//        if (start > end) return Integer.MAX_VALUE;
//
//        int pivot = nums[end];
//
//        int left = start;
//        for (int i = start; i < end; i++) {
//            if (nums[i] <= pivot) {
//                swap(nums, left, i);
//                left++;
//            }
//        }
//
//        swap(nums, left, end);
//
//        if (left == k) {
//            return nums[left];
//        } else if (left > k) {
//            return find(nums, k, start, left - 1);
//        } else {
//            return find(nums, k, left + 1, end);
//        }
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
//        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4, 5, 6, 6, 6, 6}, 6));
//    }
//}