package interview.easy;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String tmp = haystack.substring(i, i + needle.length());
            if (tmp.equals(needle))
                return i;
        }

        return -1;
    }

    // don't use subString
    public int strStr1(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length())
                    return i;
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("hello", "ll"));
        System.out.println(new ImplementStrStr().strStr("aaaaa", "bba"));

        System.out.println(new ImplementStrStr().strStr1("hello", "ll"));
        System.out.println(new ImplementStrStr().strStr1("aaaaa", "bba"));
        System.out.println(new ImplementStrStr().strStr1("", ""));
    }
}
