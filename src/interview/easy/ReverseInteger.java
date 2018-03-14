package interview.easy;

public class ReverseInteger {
    public int reverse(int x) {
        long result = 0;

        int tmp = Math.abs(x);
        int length = String.valueOf(tmp).length();
        while (tmp != 0) {
            result += Math.pow(10, --length) * (tmp % 10);
            tmp = tmp / 10;
        }

        result = x >= 0 ? result : -result;
        result = result > Integer.MAX_VALUE ? 0 : result;
        result = result < Integer.MIN_VALUE ? 0 : result;
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(120));
        System.out.println(new ReverseInteger().reverse(123));
        System.out.println(new ReverseInteger().reverse(-123));
        System.out.println(new ReverseInteger().reverse(1534236469));
        System.out.println(new ReverseInteger().reverse(-2147483648));
    }

}
