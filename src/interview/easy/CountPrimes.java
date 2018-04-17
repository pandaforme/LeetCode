package interview.easy;

public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];

        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = (i * i); j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean b : prime) {
            if (b)
                count++;
        }

        return count;
    }

    // O(n^2)
//    public int countPrimes(int n) {
//        int count = 0;
//        for (int i = 2; i < n; i++) {
//            if (isPrime(i)) {
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//    private boolean isPrime(int n) {
//        for (int i = 2; i * i <= n; i++) {
//            if (n % i == 0)
//                return false;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10000));
    }
}
