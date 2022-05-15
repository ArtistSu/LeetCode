package JavaCode;

public class Interview01_05 {
    /**
     * Time Complexity: O(n * m) {@code n} is the length of {@param first}, {@code m} is the length of {@param second}
     * Space Complexity: O(n * m)
     * @topic One Away LCCI
     * @author ArtistS
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {

        int n = first.length();
        int m = second.length();
        if(n == 0 && m == 0 || Math.min(n,m)== 0 && Math.abs(m-n) == 1){
            return true;
        }
        if(Math.min(n,m)== 0 && Math.abs(m-n)>1){
            return false;
        }
        int[][] editDis = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            editDis[i][0] = i;
        }
        for(int j = 0; j <= m; j++){
            editDis[0][j] = j;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(first.charAt(i-1) == second.charAt(j-1)){
                    editDis[i][j] = editDis[i-1][j-1];
                }else{
                    editDis[i][j] = Math.min(Math.min(editDis[i-1][j-1], editDis[i-1][j]),Math.min(editDis[i-1][j-1], editDis[i][j-1]))+1;
                }
            }
        }
        return editDis[n][m] <= 1 ? true : false;
    }
}
