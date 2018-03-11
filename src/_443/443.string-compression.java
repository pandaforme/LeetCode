package _443;

class Solution {
    public int compress(char[] chars) {
        int insertPoint = 0;
        int left = 0;
        int right = 0;

        while (right < chars.length) {
            while (right < chars.length && chars[right] == chars[left]) {
                right++;
            }

            int diff = right - left;
            if (diff > 1) {
                String s = Integer.toString(diff);

                char[] tmp = new char[1 + s.length()];
                tmp[0] = chars[left];
                for (int i = 0; i < s.length(); i++) {
                    tmp[i + 1] = s.charAt(i);
                }

                insertPoint = insert(insertPoint, chars, tmp);
            } else if (diff == 1) {
                insertPoint = insert(insertPoint, chars, new char[]{chars[left]});
            }

            left = right;
        }

        return insertPoint;
    }

    private int insert(int insertPoint, char[] chars, char[] elements) {
        for (Character element : elements) {
            chars[insertPoint] = element;
            insertPoint++;
        }

        return insertPoint;
    }

    public static void main(String[] args) {
        char[] chars = {'a'};
        System.out.println(new Solution().compress(chars));
        System.out.println(chars);

        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(new Solution().compress(chars1));
        System.out.println(chars1);


        char[] chars2 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(new Solution().compress(chars2));
        System.out.println(chars2);
    }
}
