package JavaCode;

public class Java941 {
    /**
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr
     * @return
     * @author: Allen Su
     */
    public boolean validMountainArray(int[] arr) {
        if(arr.length <= 2){
            return false;
        }
        int step = arr.length;
        int i = 0;

        while(i+1<step && arr[i] < arr[i+1]){
            i++;
        }

        if(i==0 || i == step-1){
            return false;
        }

        while(i+1<step && arr[i]> arr[i+1]){
            i++;
        }
        return i == step-1;
    }

}
