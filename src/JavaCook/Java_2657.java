package JavaCook;

/**
 * @author ArtistS
 * @tag FrequenceArray
 * @prb https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
 * Time complexity: O(n) n is the length of A or B
 * Space complexity: O(n)
 */
public class Java_2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n+1];
        int[] res = new int[n];
        int common = 0;

        for(int i = 0; i < n; i++){
            if(++freq[A[i]] == 2){
                common++;
            }
            if(++freq[B[i]] == 2){
                common++;
            }
            res[i] = common;
        }

        return res;
    }
}