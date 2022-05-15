package JavaCode;

import java.util.Arrays;

public class Java937 {
    /**
     * 1表示两个比较的数字位置互换，0和-1则是位置不发生变化
     * Time Complexity: O(nlogn) n is the length of {@arg logs}
     * Space Complexity: O(n)
     * @topic Reorder Data in Log Files
     * @author ArtistS
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> compare(o1, o2));
        return logs;
    }

    private int compare(String log1, String log2) {
        int sep1 = log1.indexOf(' ') + 1;
        int sep2 = log2.indexOf(' ') + 1;
        if (Character.isDigit(log1.charAt(sep1)) && Character.isDigit(log2.charAt(sep2))) {
            return 0;
        } else if (Character.isDigit(log1.charAt(sep1))) {
            return 1;
        } else if (Character.isDigit(log2.charAt(sep2))) {
            return -1;
        } else {
            int cmp = log1.substring(sep1).compareTo(log2.substring(sep2));
            if (cmp == 0) {
                return log1.compareTo(log2);
            }
            return cmp;
        }
    }
}
