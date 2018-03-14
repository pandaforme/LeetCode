package interview.easy;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        String previous = countAndSay(n - 1);

        int left = 0;
        int right = 0;
        String result = "";
        while (right < previous.length()) {
            while (right < previous.length() && previous.charAt(left) == previous.charAt(right)) {
                right++;
            }

            result += String.valueOf((right - left)) + String.valueOf(previous.charAt(left));

            left = right;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(2));
        System.out.println(new CountAndSay().countAndSay(3));
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
    }
}
