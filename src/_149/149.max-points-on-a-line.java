package _149;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            return "Point [" +
                    "x=" + x +
                    ", y=" + y +
                    "]";
        }
    }

    public int maxPoints(Point[] points) {
        if (points.length < 3)
            return points.length;

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < points.length; i++) {

            // <slope, count>
            Map<BigDecimal, Integer> map = new HashMap<>();
            int sameCount = 1;
            for (int j = i + 1; j < points.length; j++) {
                // handle a same point...
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    sameCount++;
                    continue;
                }

                BigDecimal slope;
                if (points[j].y == points[i].y) {
                    slope = new BigDecimal(1);
                } else {
                    BigDecimal x = new BigDecimal(points[j].x - points[i].x);
                    BigDecimal y = new BigDecimal(points[j].y - points[i].y);

                    slope = x.divide(y, MathContext.DECIMAL128);
                }

                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }

            final Optional<Integer> max = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getValue);
            result = Math.max(max.orElse(0) + sameCount, result);
        }

        return result;
    }

//    public int maxPoints(Point[] points) {
//        if (points.length < 3)
//            return points.length;
//
//        int result = Integer.MIN_VALUE;
//
//        for (int i = 0; i < points.length; i++) {
//            int sameCount = 0;
//            for (int j = i + 1; j < points.length; j++) {
//                // formula
//                // (y - y1)/(y2 - y1) = (x - x1)/(x2 - x1)
//
//                // handle same point...
//                if (points[i].x == points[j].x && points[i].y == points[j].y) {
//                    sameCount++;
//                    result = Math.max(sameCount + 1, result);
//                    continue;
//                }
//
//                int outterCount = 2;
//                int innerCount = 0;
//                for (int k = j + 1; k < points.length; k++) {
//                    double y = 0.0;
//                    double x = 0.0;
//
//                    // y = y1
//                    if (points[j].y == points[i].y && points[k].y == points[i].y) {
//                        innerCount++;
//                    }
//                    // point[k] doesn't exist this line
//                    else if (points[j].y == points[i].y && points[k].y != points[i].y) {
//                    }
//                    // x = x1
//                    else if (points[j].x == points[i].x && points[k].x == points[i].x) {
//                        innerCount++;
//                    }
//                    // point[k] doesn't exist this line
//                    else if (points[j].x == points[i].x && points[k].x != points[i].x) {
//                    } else {
//                        y = (double) (points[k].y - points[i].y) / (double) (points[j].y - points[i].y);
//                        x = (double) (points[k].x - points[i].x) / (double) (points[j].x - points[i].x);
//                        if (x == y)
//                            innerCount++;
//                    }
//                }
//
//                result = Math.max(outterCount + innerCount + sameCount, result);
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxPoints(new Point[]{
                new Point(4, 0), new Point(4, -1), new Point(4, 5)}));

        System.out.println(new Solution().maxPoints(new Point[]{
                new Point(3, 9), new Point(2, 2), new Point(4, 0),
                new Point(5, 1), new Point(1, 1), new Point(3, 3)}));

        System.out.println(new Solution().maxPoints(new Point[]{
                new Point(1, 1), new Point(0, 0), new Point(1, -1)}));

        // test cases contain duplicated point..., WTF
        System.out.println(new Solution().maxPoints(new Point[]{
                new Point(1, 1), new Point(1, 1), new Point(2, 3)}));

        System.out.println(new Solution().maxPoints(new Point[]{
                new Point(0, -12), new Point(5, 2), new Point(2, 5),
                new Point(0, -5), new Point(1, 5), new Point(2, -2),
                new Point(5, -4), new Point(3, 4), new Point(-2, 4),
                new Point(-1, 4), new Point(0, -5), new Point(0, -8),
                new Point(-2, -1), new Point(0, -11), new Point(0, -9)}));
    }
}
