package java;

public class java485 {
        int[] nums = new int[6];

        public int findMaxConsecutiveOnes(int[] nums){
            int maxConsecutive = 0;
            int currConsecutive = 0;
            for (int currItem :
                    nums) {
                if (currItem == 1){
                    currConsecutive++;
                    if(currConsecutive > maxConsecutive){
                        maxConsecutive = currConsecutive;
                    }
                }
                if (currItem == 0){
                    currConsecutive = 0;
                    if(currConsecutive > maxConsecutive){
                        maxConsecutive = currConsecutive;
                    }
                }
            }
            return maxConsecutive;
        }
}
