package leetcode.contest;

import java.util.TreeMap;

public class FindReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }

        int start = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer index : map.keySet()) {
            String source = sources[map.get(index)];
            String tmp = S.substring(index, index + source.length());
            if (tmp.equals(source)) {
                stringBuilder.append(S, start, index);
                stringBuilder.append(targets[map.get(index)]);
                start = index + tmp.length();
            }
        }

        stringBuilder.append(S, start, S.length());

        return stringBuilder.toString();
    }
//    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
//        Map<Integer, String> indexTarget = new HashMap<>();
//        Map<Integer, Integer> indexSource = new HashMap<>();
//
//        for (int i = 0; i < indexes.length; i++) {
//            String source = sources[i];
//
//            String tmp = S.substring(indexes[i], indexes[i] + source.length());
//            if (tmp.equals(source)) {
//                indexTarget.put(indexes[i], targets[i]);
//                indexSource.put(indexes[i], indexes[i] + tmp.length());
//            }
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        int index = 0;
//        while (index < S.length()) {
//            if (!indexTarget.containsKey(index)) {
//                stringBuilder.append(S, index, index + 1);
//                index++;
//            } else {
//                stringBuilder.append(indexTarget.get(index));
//                index = indexSource.get(index);
//            }
//        }
//
//        return stringBuilder.toString();
//    }

    public static void main(String[] args) {
        System.out.println(new FindReplaceString().findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
        System.out.println(new FindReplaceString().findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));
        System.out.println(new FindReplaceString().findReplaceString("vmokgggqzp", new int[]{3, 5, 1}, new String[]{"kg", "ggq", "mo"}, new String[]{"s", "so", "bfr"}));
    }
}
