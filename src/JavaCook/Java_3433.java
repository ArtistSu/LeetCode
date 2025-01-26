package JavaCook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ArtistS
 * @tag Sorting String
 * @prb https://leetcode.com/problems/count-mentions-per-user/description/
 * Time complexity: O(nlogn + m) nlogn for sorting, m for processing events(m is total number of words in all messages)
 * Space complexity: O(n)
 */
public class Java_3433 {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offTime = new int[numberOfUsers];

        // Sort event
        // a.get(1) - b.get(1) > 0 -> Ascending
        // a.get(1) - b.get(1) < 0 -> Descending
        Collections.sort(events, (a, b) ->
                Integer.parseInt(a.get(1)) == Integer.parseInt(b.get(1)) ?
                        b.get(0).compareTo(a.get(0)) :
                        Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1)));

        // Handle msg
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).get(0).equals("MESSAGE")) {
                messageFunc(events.get(i), mentions, offTime);
            } else if (events.get(i).get(0).equals("OFFLINE")) {
                offlineFunc(events.get(i), offTime);
            }
        }
        return mentions;
    }

    public void messageFunc(List<String> event, int[] mentions, int[] offTime) {
        int time = Integer.parseInt(event.get(1));
        String[] strs = event.get(2).split(" ");

        for (String str : strs) {
            if (str.equals("ALL")) {
                for (int i = 0; i < mentions.length; i++) {
                    mentions[i] += 1;
                }
            } else if (str.equals("HERE")) {
                for (int i = 0; i < mentions.length; i++) {
                    if (offTime[i] == 0) {
                        mentions[i] += 1;
                    } else if (offTime[i] + 60 <= time) {
                        mentions[i] += 1;
                        offTime[i] = 0;
                    }
                }
            }else {
                int idx = Integer.parseInt(str.substring("id".length()));
                mentions[idx] += 1;
            }
        }
    }

    public void offlineFunc(List<String> event, int[] offTime) {
        int time = Integer.parseInt(event.get(1));
        String[] strs = event.get(2).split(" ");

        for (String str : strs) {
            int idx = Integer.parseInt(str);
            offTime[idx] = time;
        }
    }

    public static void main(String[] args) {
        List<List<String>> testCase = new ArrayList<>();
        List<String> events_1 = new ArrayList<>();
        events_1.add("MESSAGE");
        events_1.add("2");
        events_1.add("id1 id0 id2 id3");

        List<String> events_2 = new ArrayList<>();
        events_2.add("OFFLINE");
        events_2.add("2");
        events_2.add("1");

        List<String> events_3 = new ArrayList<>();
        events_3.add("OFFLINE");
        events_3.add("1");
        events_3.add("0");

        List<String> events_4 = new ArrayList<>();
        events_4.add("MESSAGE");
        events_4.add("61");
        events_4.add("HERE");

        testCase.add(events_1);
        testCase.add(events_2);
        testCase.add(events_3);
        testCase.add(events_4);

        System.out.println(Integer.parseInt(events_1.get(1)));
        String[] strs = events_1.get(2).split(" ");
        for(String str : strs){
            // Ignore the fist 2 letters and get the rest of the letters;
            System.out.println(Integer.parseInt(str.substring("id".length())));
        }
    }
}