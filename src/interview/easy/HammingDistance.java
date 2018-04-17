package interview.easy;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;

        int count = 0;
        while (tmp != 0) {
            if ((tmp & 1) == 1)
                count++;

            tmp = tmp >>> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1, 4));
    }
}
