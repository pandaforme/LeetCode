package _12;

class Solution {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] symbols = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < values.length; i += 2) {
            if (values[i] > num)
                continue;

            int tmp = num / values[i];

            if (1 <= tmp && tmp <= 3) {
                while (tmp != 0) {
                    stringBuilder.append(symbols[i]);
                    num -= values[i];
                    tmp--;
                }
            } else if (tmp == 4) {
                stringBuilder.append(symbols[i]).append(symbols[i - 1]);
                num -= values[i - 1];
                num += values[i];

            } else if (5 <= tmp && tmp <= 8) {
                stringBuilder.append(symbols[i - 1]);
                num -= values[i - 1];

                tmp -= 5;
                while (tmp != 0) {
                    stringBuilder.append(symbols[i]);
                    num -= values[i];
                    tmp--;
                }
            } else if (tmp == 9) {
                stringBuilder.append(symbols[i]).append(symbols[i - 2]);
                num -= values[i - 2];
                num += values[i];
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
        System.out.println(new Solution().intToRoman(4));
        System.out.println(new Solution().intToRoman(9));
        System.out.println(new Solution().intToRoman(58));
        System.out.println(new Solution().intToRoman(1994));
    }
}
