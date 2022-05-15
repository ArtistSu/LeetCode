package JavaCode;

import java.util.*;

public class Java398 {
    /**
     * @topic Random Pick Index
     * @author ArtistS
     */
    Map<Integer, String> res;
    public Java398(int[] nums) {
        res = new HashMap<>();
        for(int i=0; i < nums.length;i++){
            if(res.containsKey(nums[i])){
                String value = res.get(nums[i])+" "+i;
                res.put(nums[i], value);
            }else{
                res.put(nums[i],String.valueOf(i));
            }
        }
    }

    public int pick(int target) {
        if(res.containsKey(target)){
            String[] indexes = res.get(target).split(" ");
            Random random = new Random();
            int randomIndex = random.nextInt(indexes.length);
            return Integer.parseInt(indexes[randomIndex]);
        }
        return -1;
    }
}
