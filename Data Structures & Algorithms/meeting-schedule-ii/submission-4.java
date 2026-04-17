/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
     public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        // Sort intervals by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // Min-heap to track the earliest end time
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            // If the room due to free earliest is free, remove it
            if (!heap.isEmpty() && interval.start >= heap.peek()) {
                heap.poll();
            }
            // Allocate a new room (or reuse the old one)
            heap.offer(interval.end);
        }

        // Number of rooms required is the size of the heap
        return heap.size();
    }
}
