//class Solution {
////    // brutal force
////    public String longestPalindrome(String s) {
////        for (int w = s.length(); w >= 2; w--) {
////            for (int i = 0; i < s.length(); i++) {
////                if (i + w <= s.length()) {
////                    String substring = s.substring(i, i + w);
////                    boolean palindrome = isPalindrome(substring);
////                    if (palindrome) {
////                        return substring;
////                    }
////                } else {
////                    break;
////                }
////            }
////        }
////
////        return String.valueOf(s.charAt(0));
////    }
//
////    // dp
////    public String longestPalindrome(String s) {
////        boolean[][] dp = new boolean[s.length()][s.length()];
////
////        int maxI = 0;
////        int maxJ = 0;
////        int max = 1;
////        for (int w = 0; w <= s.length(); w++) {
////            for (int i = 0; i < s.length(); i++) {
////                int j = i + w;
////                if (j < s.length() && s.charAt(i) == s.charAt(j)) {
////                    if (i + 1 > j - 1) {
////                        dp[j][i] = true;
////                        dp[i][j] = true;
////
////                        if (j - i + 1 > max) {
////                            max = j - i + 1;
////                            maxI = i;
////                            maxJ = j;
////                        }
////                    } else if (dp[i + 1][j - 1]) {
////                        dp[i][j] = dp[i + 1][j - 1];
////                        dp[j][i] = dp[i + 1][j - 1];
////
////                        if (2 + (j - 1) - (i + 1) + 1 > max) {
////                            max = 2 + (j - 1) - (i + 1) + 1;
////                            maxI = i;
////                            maxJ = j;
////                        }
////                    }
////                }
////            }
////        }
////
////        return s.substring(maxI, maxJ + 1);
////    }
//
//    // expand method
//    public String longestPalindrome(String s) {
//        int max = Integer.MIN_VALUE;
//        int maxI = 0;
//        int maxJ = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int odd = expandPalindrome(s, i, i);
//            int even = expandPalindrome(s, i, i + 1);
//            int m = Math.max(odd, even);
//            if (m > max) {
//                max = m;
//                if (m == odd) {
//                    maxI = i - ((m - 1) / 2);
//                    maxJ = i + ((m - 1) / 2);
//                } else {
//                    maxI = i - ((m - 2) / 2);
//                    maxJ = (i + 1) + ((m - 2) / 2);
//                }
//            }
//        }
//
//        return s.substring(maxI, maxJ + 1);
//    }
//
//    private int expandPalindrome(String s, int i, int j) {
//        while (i >= 0 && j < s.length() && (s.charAt(i) == s.charAt(j))) {
//            i--;
//            j++;
//        }
//
//        return j - i - 1;
//    }
//
//    private boolean isPalindrome(String s) {
//        int front = 0;
//        int back = s.length() - 1;
//
//        do {
//            if ((s.charAt(front) != s.charAt(back))) {
//                return false;
//            }
//            front++;
//            back--;
//        } while (front <= back);
//
//        return true;
//    }
//}
