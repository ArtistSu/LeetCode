package JavaCode;

public class Java668 {
    /**
     * Time Complexity: O(m * log(mn) ) {@param m} is the number of rows, {@param n} is the number of columns
     * Space Complexity: O(1)
     * @topic Kth Smallest Number in Multiplication Table
     * @author ArtistS
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            // complete rows * columns
            int countBase = x / n * n;
            // the number of the rest numbers smaller than current digit x
            for(int i = x / n +1; i <= m; i++){
                countBase += x / i;
            }
            if(countBase >= k){
                right = x;
            }else{
                left = x +1;
            }
        }
        return left;
    }
}
