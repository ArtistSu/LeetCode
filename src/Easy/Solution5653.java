package Easy;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/17 10:36 上午
 * Description:
 */
public class Solution5653 {
    public static void main(String[] args) {
        Solution5653 s = new Solution5653();
        s.countGoodRectangles(new int[][]{{5,8},{3,9},{5,12},{16,5}});
    }
    public int countGoodRectangles(int[][] rectangles) {
        List<Integer> result = new ArrayList<>();
        for (int[] temp:
             rectangles) {
            if(temp[0] > temp[1]){
                result.add(temp[1]);
            }else{
                result.add(temp[0]);
            }
        }
        Map<Integer,Integer> countSides = new HashMap<>();
        int maxAppearance = 0;
        int tempSide = 0;
        for (int sideLength :
                result) {
            if(countSides.containsKey(sideLength)){
                countSides.put(sideLength,countSides.get(sideLength)+1);
                if(tempSide<=sideLength) {
                    maxAppearance = countSides.get(sideLength);
                }
            }else{
                countSides.put(sideLength,1);
                if(tempSide < sideLength){
                    tempSide = sideLength;
                    maxAppearance = Math.max(maxAppearance,countSides.get(sideLength));
                }
            }
        }
        return maxAppearance;
    }

}
