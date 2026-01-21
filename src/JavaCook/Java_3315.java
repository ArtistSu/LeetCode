package JavaCook;

import java.util.List;

/**
 * @author ArtistS
 * @tag Array BitManipulation
 * @prb <a href="https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/editorial/?envType=daily-question&envId=2026-01-21">...</a>
 * @TimeComplexity O(nlogm)
 * @SpaceComplexity O(1)
 */
public class Java_3315{
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];

        for(int i = 0; i < nums.size(); i++){
            int curr = nums.get(i);
            int res = -1;
            int candidate = 1;
            while((curr & candidate) != 0){
                res = curr - candidate;
                candidate <<= 1;
            }
            result[i] = res;
        }
        return result;
    }
}