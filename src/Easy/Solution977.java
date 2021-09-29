

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author SuJiexi
 * @PackageName:Easy
 * @ClassName:Solution977
 * @Decription: Given an array of integers A sorted in non-decreasing order, return an array of
 * the squares of each number, also in sorted non-decreasing order.1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000,A is sorted in non-decreasing order.
 * @date 2019/5/1215:30
 */
public class Solution977 {
    //TimeComplexity:O(n^2)
    //SpaceComplexity:O(1)
    public int[] sortedSquares(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int temp = A[i];
            for (int j = i; j > 0; j--) {
                if (A[j] * A[j] < A[j - 1] * A[j - 1]) {
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }

        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        return A;
    }

    //TimeComplexity:O(n^2)
    //SpaceComplexity:O(1)
    public int[] sortedSquares2(int[] A) {
        int length = A.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = A[i] * A[i];
        }
        Arrays.sort(result);
        return result;
    }

}

