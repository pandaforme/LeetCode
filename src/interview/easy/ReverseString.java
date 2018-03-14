package interview.easy;

public class ReverseString {
    public String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }


    public String reverseString1(String s) {
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < result.length() / 2; i++) {
            Character tmp = result.charAt(i);
            result.setCharAt(i, result.charAt((s.length() - 1) - i));
            result.setCharAt((s.length() - 1) - i, tmp);
        }
        return result.toString();
    }

    public String reverseString2(String s) {
        if (s == null || s.length() == 0)
            return "";

        return reverseString2(s.substring(1)) + s.charAt(0);
    }

    public String reverseString3(String previous, String s) {
        if (s == null || s.length() == 0)
            return previous;

        return reverseString3(s.charAt(0) + previous, s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("12345"));
        System.out.println(new ReverseString().reverseString1("12345"));
        System.out.println(new ReverseString().reverseString2("12345"));
        System.out.println(new ReverseString().reverseString3("", "12345"));
    }
}
