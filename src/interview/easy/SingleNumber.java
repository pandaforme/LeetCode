package interview.easy;

//Given an array of integers, every element appears twice except for one. Find that single one.
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{1, 2, 3, 2, 1}));
    }
}
