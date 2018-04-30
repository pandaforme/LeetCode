package _253;

import datastructure.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0 || intervals.length == 1)
            return intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        PriorityQueue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        for (int i = 0; i < intervals.length; i++) {
            if (!queue.isEmpty() && !isOverlap(queue.peek(), intervals[i])) {
                queue.poll();
            }

            queue.add(intervals[i]);
        }

        return queue.size();
    }


    private boolean isOverlap(Interval interval1, Interval interval2) {
        return interval1.start < interval2.end && interval2.start < interval1.end;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMeetingRooms(
                new Interval[]{new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)}
        ));

        System.out.println(new Solution().minMeetingRooms(
                new Interval[]{new Interval(4, 9), new Interval(4, 17), new Interval(9, 10)}
        ));

        System.out.println(new Solution().minMeetingRooms(
                new Interval[]{new Interval(1, 10), new Interval(3, 12), new Interval(4, 5),
                        new Interval(3, 10), new Interval(12, 15)}
        ));
    }
}
