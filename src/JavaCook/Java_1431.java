package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Array LC75
 * @prb https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_1431{
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int most =  0;
        for(int candy : candies){
            most = Math.max(candy,most);
        }

        List<Boolean> res = new ArrayList<>();
        for(int candy : candies){
            if(candy + extraCandies >= most){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }

    public List<Boolean> kidsWithCandiesV2(int[] candies, int extraCandies) {
        int most =  0;
        for(int candy : candies){
            most = Math.max(candy,most);
        }

        List<Boolean> res = new ArrayList<>();
        for(int candy : candies){
            res.add(candy + extraCandies >= most);
        }
        return res;
    }
}