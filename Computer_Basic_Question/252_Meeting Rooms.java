I.Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
  
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }
}
/*********************************/
II. Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
  
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size()  == 0) return 0;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2) {
                return o1.start != o2.start ? o1.start - o2.start : o1.end-o2.end;
            }
        });
        int room = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.size(); i++) {
            pq.offer(intervals.get(i).end);//automatic sort the end time
            if (intervals.get(i).start < pq.peek()) {
                room++;
            } else {
                pq.poll();
            }
            
        }
        return room; 
    }
}
