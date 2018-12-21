import java.util.Arrays;
import java.util.Comparator;

public class Solution_for_non_overlapping_intervals {


    class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

      public int eraseOverlapIntervals(Interval[] intervals) {
            if (intervals.length == 0) return 0;
            int nonOverlap = 1;
            int seq = 0;
            Arrays.sort(intervals, (i1, i2) -> i1.end - i2.end);
            for (int i=1; i<intervals.length; i++) {
                if (intervals[i].start >= intervals[seq].end) {
                    seq = i;
                    nonOverlap++;
                }
            }
            return intervals.length - nonOverlap;
        }
    }

