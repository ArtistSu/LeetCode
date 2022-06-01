package JavaCode;

import java.util.Arrays;

public class Java473 {
    /**
     * Time Complexity: O(4^n) {@code n} is the number of {@param machsticks}
     * Space Complexity: O(n)
     * @method backtrack
     * @topic Matchsticks to Square
     * @author ArtistS
     * @param matchsticks
     * @return
     */
    public boolean makesquare(int[] matchsticks) {
        int total = Arrays.stream(matchsticks).sum();
        if(total % 4 != 0 || matchsticks.length < 4){
            return false;
        }

        Arrays.sort(matchsticks);
        for(int i = 0, j = matchsticks.length-1; i < j; i++, j--){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] edges = new int[4];
        int side = total / 4;
        return dfs(edges, matchsticks, 0, side);

    }

    public boolean dfs(int[] edges, int[] matchsticks, int startIndex, int side){
        if(startIndex == matchsticks.length){
            return true;
        }
        for(int i = 0; i< edges.length; i++){
            edges[i] += matchsticks[startIndex];
            if(edges[i] <= side && dfs(edges, matchsticks, startIndex+1, side)){
                return true;
            }
            edges[i] -= matchsticks[startIndex];
        }
        return false;
    }
}
