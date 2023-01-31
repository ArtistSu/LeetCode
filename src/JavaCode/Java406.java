package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java406 {
    public static void main(String[] args) {
        new Java406().reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }

    /**
     * Time Complexity: O(n^2) {@param n} is the length of {@param people}
     * Space Complexity: O(logn)
     * @topic Queue Reconstruction by Height
     * @author ArtistS
     * @method Greedy
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        Arrays.stream(people).forEach(x-> System.out.print("("+x[0]+" "+ x[1]+")"));
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
            ans.stream().forEach(x-> System.out.print("("+x[0]+" "+ x[1]+")"));
            System.out.println(" ");
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
