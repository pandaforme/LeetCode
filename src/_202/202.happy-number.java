package _202;

class Solution {
    public boolean isHappy(int n) {
        // because if it isn't a happy number, it loops endlessly in a cycle which does not include 1.
        // I remind the algorithm of detecting a cycle

        int slow = n;
        int fast = n;

        do {
            slow = sum(slow);
            fast = sum(sum(fast));
        } while (slow != fast && slow != 1);

        return slow == 1;
    }

    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
        System.out.println(new Solution().isHappy(14));
    }
}
