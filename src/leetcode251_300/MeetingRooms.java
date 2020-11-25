package leetcode251_300;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yesongren on 2020/11/25
 * 252. Meeting Rooms
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}
