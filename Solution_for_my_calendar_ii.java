import java.util.ArrayList;
import java.util.List;

public class Solution_for_my_calendar_ii {
    class MyCalendarTwo {
        List<int[]> books;
        List<int[]> overlaps;

        public MyCalendarTwo() {
             books = new ArrayList<>();
             overlaps = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] overlap : overlaps) {
                if (Math.max(overlap[0], start) < Math.min(overlap[1], end)) {
                    return false;
                }
            }
            for (int[] book : books) {
                int overlapStart = Math.max(book[0], start);
                int overlapEnd = Math.min(book[1], end);
                if (overlapStart < overlapEnd) {
                    overlaps.add(new int[]{overlapStart, overlapEnd});
                }
            }
            books.add(new int[]{start, end});
            return true;
        }
    }
}
