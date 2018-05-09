package _334;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= firstMin)
                firstMin = num;
            else if (num <= secondMin)
                secondMin = num;
            else
                return true;

        }

        return false;
    }

    // apply the solution of LeetCode 300
//    public boolean increasingTriplet(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//
//        for (int num : nums) {
//            if (list.isEmpty() || list.get(list.size() - 1) < num)
//                list.add(num);
//            else {
//                int search = Collections.binarySearch(list, num);
//                int index = search < 0 ? -search - 1 : search;
//                list.set(index, num);
//            }
//
//            if (list.size() == 3)
//                return true;
//        }
//
//        return false;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{1, 1, 2, 2, 2}));
        System.out.println(new Solution().increasingTriplet(new int[]{1, 1, 2, 2, 3}));
        System.out.println(new Solution().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }
}
