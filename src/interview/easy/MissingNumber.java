package interview.easy;

public class MissingNumber {
    // this is a weird question
    // if you can solve at O(n), why do you solve it directly?
    // because you have iterated this array, you can get the answer and don't get the answer via another ways.
    // like xor or sum ...
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }

        return result;
    }
}
