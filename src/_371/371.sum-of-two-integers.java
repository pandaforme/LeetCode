package _371;

class Solution {
    public int getSum(int a, int b) {
//        while(b != 0){
//            int carry = a & b;
//            a = a ^ b;
//            b = carry << 1;
//        }
//
//        return a;

        int result = 0;
        int carry = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            int tmpA = (a >> i) & mask;
            int tmpB = (b >> i) & mask;

            result = (i == 0) ? result : result >>> 1;
            result |= (tmpA ^ tmpB ^ carry) << 31;

            if (tmpA == 1 && tmpB == 1 && carry == 0)
                carry = 1;
            else if (tmpA == 1 && tmpB == 1 && carry == 1)
                carry = 1;
            else if (tmpA == 1 && tmpB == 0 && carry == 1)
                carry = 1;
            else if (tmpA == 0 && tmpB == 1 && carry == 1)
                carry = 1;
            else
                carry = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSum(2, 5));
        System.out.println(new Solution().getSum(2, -5));
        System.out.println(new Solution().getSum(-2, 5));
        System.out.println(new Solution().getSum(-2, -5));
    }
}
