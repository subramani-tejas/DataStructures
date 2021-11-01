package com.codewithtejas.LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
    private final int DAY_START = 10;
    private final int DAY_END = 17;

    // get hours from the meeting times list
    public List<Integer> getHours(List<String> meetingTimes) {
        List<Integer> hh = new ArrayList<>();
        for (String hours : meetingTimes)
            hh.add(Integer.parseInt(hours.substring(0, 2)));
        return hh;
    }

    // get minutes from the meeting times list
    public List<Integer> getMinutes(List<String> meetingTimes) {
        List<Integer> mm = new ArrayList<>();
        for (String minutes : meetingTimes)
            mm.add(Integer.parseInt(minutes.substring(3)));
        return mm;
    }

    // get my meetings today
    public List<List<String>> getMyMeetings() {
        List<String> meeting01 = new ArrayList<>();
        meeting01.add("10:00");
        meeting01.add("11:00");

        List<String> meeting02 = new ArrayList<>();
        meeting02.add("12:30");
        meeting02.add("14:30");

        List<String> meeting03 = new ArrayList<>();
        meeting03.add("14:30");
        meeting03.add("15:00");

        List<String> meeting04 = new ArrayList<>();
        meeting04.add("16:00");
        meeting04.add("17:00");

        List<List<String>> myMeetingsToday = new ArrayList<>();
        myMeetingsToday.add(meeting01);
        myMeetingsToday.add(meeting02);
        myMeetingsToday.add(meeting03);
        myMeetingsToday.add(meeting04);

        return myMeetingsToday;
    }

    // get other's meetings today
    public List<List<String>> getOthersMeetings() {

        List<String> meeting02 = new ArrayList<>();
        meeting02.add("11:30");
        meeting02.add("14:30");

        List<String> meeting03 = new ArrayList<>();
        meeting03.add("14:30");
        meeting03.add("15:00");

        List<String> meeting04 = new ArrayList<>();
        meeting04.add("15:00");
        meeting04.add("17:00");

        List<List<String>> myMeetingsToday = new ArrayList<>();
        myMeetingsToday.add(meeting02);
        myMeetingsToday.add(meeting03);
        myMeetingsToday.add(meeting04);

        return myMeetingsToday;
    }

    // free 30min slots in today's meetings (10:00 --> 17:00)
    public List<List<String>> getFreeSlots(List<List<String>> meetings) {
        List<List<String>> freeSlots = new ArrayList<>();

            for (var oneMeeting: meetings)
                System.out.println(oneMeeting);

        return freeSlots;
    }

    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();

        // My meetings
        var myMeetings = scheduler.getMyMeetings();
        // System.out.println(myMeetings);

        // other person's meetings
        var othersMeetings = scheduler.getOthersMeetings();
        // System.out.println(othersMeetings);

        // System.out.println("-----------------------");

        // free 30min slots in my meetings
        var myFreeSlots = scheduler.getFreeSlots(myMeetings);
        // System.out.println(myFreeSlots);
    }
}
