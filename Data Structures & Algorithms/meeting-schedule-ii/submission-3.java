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
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for (Interval interval: intervals) {
            start.add(interval.start);
            end.add(interval.end);
        }

        Collections.sort(start);
        Collections.sort(end);

        int i=0,j=0, result = 0, count =0;
        while(i<intervals.size() && j<intervals.size()) {
            if (start.get(i) < end.get(j)) {
                count++;
                i++;
            } else {
                j++;
                count--;
            }
            result = Math.max(result, count);
        }

        return result;
    }
}
