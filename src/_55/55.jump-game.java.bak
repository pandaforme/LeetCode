package _55;

class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return false;

        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target)
                target = i;
        }

        return target == 0;
    }
//    public boolean canJump(int[] nums) {
//        if (nums.length == 0)
//            return false;
//
//        boolean[] dp = new boolean[nums.length];
//        dp[0] = true;
//
//        for (int i = 1; i < dp.length; i++) {
//            int k = 1;
//            while (i - k >= 0) {
//                if (dp[i - k] && nums[i - k] >= k) {
//                    dp[i] = true;
//                    break;
//                }
//                k++;
//            }
//        }
//
//        return dp[nums.length - 1];
//    }

//    public boolean canJump(int[] nums) {
//        if (nums.length == 0)
//            return false;
//
//        Stack<Integer> stack = new Stack<>();
//        stack.add(0);
//
//        while (!stack.isEmpty()) {
//            int current = stack.pop();
//            if (nums[current] >= (nums.length - 1) - current)
//                return true;
//
//            for (int i = 1; i <= nums[current]; i++) {
//                stack.push(current + i);
//            }
//        }
//
//        return false;
//    }

//    public boolean canJump(int[] nums) {
//        if (nums.length == 0)
//            return false;
//
//        return helper(nums, 0, nums.length - 1);
//    }
//
//    private boolean helper(int[] nums, int start, int target) {
//        if (start >= nums.length)
//            return false;
//
//        if (nums[start] >= target - start)
//            return true;
//
//        if (nums[start] == 0)
//            return false;
//
//        for (int i = 1; i <= nums[start]; i++) {
//            if (helper(nums, start + i, target)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{0}));
        System.out.println(new Solution().canJump(new int[]{2, 5, 0, 0}));
        System.out.println(new Solution().canJump(new int[]{1, 1, 1, 1}));
        System.out.println(new Solution().canJump(new int[]{2, 0}));
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
