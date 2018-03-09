package interview.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = 0;
            if (i == digits.length - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + carry;
            }

            carry = sum / 10;
            if (sum >= 10) {
                list.add(0, sum % 10);
            } else {
                list.add(0, sum);
            }

        }

        if (carry != 0) {
            list.add(0, carry);
        }

        return list.stream().mapToInt(e -> e).toArray();
    }

    // tricky solution...
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] tmp = new int[digits.length + 1];
        tmp[0] = 1;

        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{8, 9, 9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9})));

        System.out.println(Arrays.toString(new PlusOne().plusOne1(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne1(new int[]{8, 9, 9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne1(new int[]{1})));
        System.out.println(Arrays.toString(new PlusOne().plusOne1(new int[]{9})));
    }
}
