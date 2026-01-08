package JavaCook;

/**
 * @author ArtistS
 * @tag Array Greedy
 * @prb https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // We have flowerbed.length plots.
        int plotsNum = flowerbed.length;
        if(plotsNum == 1){
            if(flowerbed[0] == 1){
                return n <= 0;
            }else{
                return true;
            }
        }

        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0]=1;
            n--;
        }

        if(flowerbed[plotsNum-1] == 0 && flowerbed[plotsNum-2] == 0){
            flowerbed[plotsNum-1]=1;
            n--;
        }

        for(int i = 1; i < plotsNum-1;i++){
            if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    public boolean canPlaceFlowersV2(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                boolean leftEmptyOrNot = (i == 0) || (flowerbed[i-1] == 0);
                boolean rightEmptyOrNot = (i == flowerbed.length-1) || (flowerbed[i+1] == 0);

                if(leftEmptyOrNot && rightEmptyOrNot){
                    flowerbed[i] = 1;
                    n--;
                    if(n <= 0) return true;
                }
            }
        }
        return n <= 0;
    }
}
