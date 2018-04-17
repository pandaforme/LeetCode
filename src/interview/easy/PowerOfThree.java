package interview.easy;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        int max3PowerInt = 1162261467; // 3^19, 3^20 = 3486784401 > MaxInt32
        if (n <= 0) return false;
        return max3PowerInt % n == 0;
    }

    // brute force
//    public boolean isPowerOfThree(int n) {
//        if (n == 0)
//            return false;
//
//        while (n % 3 == 0) {
//            n = n / 3;
//        }
//
//        return n == 1;
//    }

    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(8));
        System.out.println(new PowerOfThree().isPowerOfThree(15));
        System.out.println(new PowerOfThree().isPowerOfThree(9));
        System.out.println(new PowerOfThree().isPowerOfThree(0));
        System.out.println(new PowerOfThree().isPowerOfThree(1));
    }
}
