package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag Array HashTable DynamicProgramming
 * @prb https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
 * Time complexity: O(n^2logM) M is the largest number of arr
 * Space complexity: O(n)
 */
public class Java_873 {
    public int lenLongestFibSubseq(int[] arr) {
        Set set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int longest = 0, pre = 0, current = 0, localLongest = 2;
        for (int first = 0; first < arr.length - 1; first++) {
            for (int second = first + 1; second < arr.length; second++) {
                pre = arr[first];
                current = arr[second];
                while (set.contains(pre + current)) {
                    localLongest++;
                    int temp = current;
                    current = pre + current;
                    pre = temp;
                    longest = Math.max(localLongest, longest);
                }
                localLongest = 2;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        new Java_873().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }
}