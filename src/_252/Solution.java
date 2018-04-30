package _252;

import datastructure.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0 || intervals.length == 1)
            return true;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        for (int i = 1; i < intervals.length; i++) {
            if (isOverlap(intervals[i - 1], intervals[i]))
                return false;
        }

        return true;
    }


    private boolean isOverlap(Interval interval1, Interval interval2) {
        return interval1.start < interval2.end && interval2.start < interval1.end;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canAttendMeetings(new Interval[]{new Interval(13, 20), new Interval(13, 17)}));
    }
}
