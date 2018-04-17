package interview.easy;

public class ReverseBits {
    public int reverseBits(int n) {
        if (n == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            n = n >>> 1;

            if(i != 31)
                result = result << 1;
        }

        return result;
    }
}
