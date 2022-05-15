package JavaCode;

public class Java1641 {
    /**
     * Time Complexity: O(n) {@code n} equal to the value of {@param n}
     * Space Complexity: O(n)
     * @topic Count Sorted Vowel Strings
     * @author ArtistS
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        int res = 0;
        int[][] arr = new int[n][5];
        for(int i = 0; i < 5; i++){
            arr[0][i] = 1;
        }
        for(int i = 1; i < n; i++){
            arr[i][4] = 1;
            for(int j = 3; j >= 0; j--){
                arr[i][j] = arr[i][j+1] + arr[i-1][j];
            }
        }
        for(int i = 0; i < 5; i++){
            res += arr[n-1][i];
        }
        return res;
    }
}
