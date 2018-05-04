package _371;

class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSum(2, 5));
        System.out.println(new Solution().getSum(2, -5));
        System.out.println(new Solution().getSum(-2, 5));
        System.out.println(new Solution().getSum(-2, -5));
    }
}
