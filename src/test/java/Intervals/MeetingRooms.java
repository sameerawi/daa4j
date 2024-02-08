package Intervals;

// Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei),
// determine if a person could attend all meetings.

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms
{

    //Definition of Interval:
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(Interval[] intervals)
    {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 0; i < intervals.length; i++)
        {
            if ( i+1 < intervals.length && intervals[i].end > intervals[i+1].start )
                return false;
        }

        return true;
    }

    @Test
    public void test()
    {
        assert (!canAttendMeetings(new Interval[]{new Interval(0,30), new Interval(5,10), new Interval(15,20)}));
        assert (canAttendMeetings(new Interval[]{new Interval(7,10), new Interval(2,4)}));
    }
}
