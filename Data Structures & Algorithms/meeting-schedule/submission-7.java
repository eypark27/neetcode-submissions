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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        Interval[] intervalList = new Interval[intervals.size()];
        intervals.toArray(intervalList);

        for (int i = 1; i < intervalList.length; i++) {
            Interval intervalA = intervalList[i - 1];
            Interval intervalB = intervalList[i];

            if (intervalA.end > intervalB.start) {
                return false;
            }
        }

        return true;
    }
}
